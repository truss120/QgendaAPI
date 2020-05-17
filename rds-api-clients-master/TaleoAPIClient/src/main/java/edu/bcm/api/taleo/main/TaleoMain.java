package edu.bcm.api.taleo.main;

import edu.bcm.api.taleo.client.TaleoClient;
import edu.bcm.api.taleo.entity.*;
import edu.bcm.api.taleo.util.ExcelHelper;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaleoMain {

    private static final Logger LOGGER = Logger.getLogger(TaleoMain.class.getName());
    //Load properties/environment variables
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("taleoClient");
    private static Properties properties1;
    private static String userName;
    private static String pw;
    private static String orgCode;
    private static String reportOutputPath;

    public static void main(String[] argv) {

        try {
/*            properties = new Properties();
            loadProperties(properties);*/

            userName = resourceBundle.getString("userName");
            pw = resourceBundle.getString("password");
            orgCode = resourceBundle.getString("orgCode");
            //reportOutputPath = resourceBundle.getString("reportOutputPath");

            TaleoClient taleoClient = new TaleoClient();

            Date rptStartDate;
            Date rptEndDate;

            Map rptDatesMap = getOrientationReportDates();

            if (rptDatesMap != null) {
                //login to the Taleo APIs
                AuthToken authToken = taleoClient.login(orgCode, userName, pw);

                rptStartDate = (Date) rptDatesMap.get("startDate");
                rptEndDate = (Date) rptDatesMap.get("endDate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                LOGGER.setLevel(Level.FINE);

                LOGGER.fine("********************************************************************************");
                LOGGER.fine("StartDate: " + dateFormat.format(rptStartDate));
                LOGGER.fine("EndDate: " + dateFormat.format(rptEndDate));
                LOGGER.fine("********************************************************************************");

                //Retrieve all Requisitions for the target time period
                List<SearchResults> requistions = null;
                requistions = taleoClient.getRequistionsByDateRange(authToken, rptStartDate, rptEndDate);

                //extract Data and create the Orientation Report
                createTaleoOrientationReport(taleoClient, authToken, requistions);
            } else {
                LOGGER.info("********************************************************************************");
                LOGGER.info("No Orientation Reports available today (" + Calendar.getInstance().getTime() + ")");
                LOGGER.info("Orientation Reports are only generated on Wednesdays, Thursdays, and Fridays");
                LOGGER.info("********************************************************************************");
            }
            //Logout of the Taleo APIs
            Boolean success = taleoClient.logout();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Map<String, Date> getOrientationReportDates() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Map<String, Date> rptDates = null;

        Calendar today = Calendar.getInstance();
        Calendar rptStartDate = Calendar.getInstance();
        Calendar rptEndDate = Calendar.getInstance();

/*            //used to test various scenarios by forcing reports to be generated for different dates
            today.add(Calendar.DATE, -1);
            rptStartDate = (Calendar) today.clone();*/

        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);

        //Orientation reports are only generated on Wednesdays, Thursdays, and Fridays
        if (dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY || dayOfWeek == Calendar.FRIDAY) {

            if (dayOfWeek == Calendar.WEDNESDAY) {
                //advance the startDate to next Sunday
                while (rptStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    rptStartDate.add(Calendar.DATE, 1);
                }

                //start from startDate and advance to Monday
                rptEndDate = (Calendar) rptStartDate.clone();
                while (rptEndDate.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                    rptEndDate.add(Calendar.DATE, 1);
                }

            } else if (dayOfWeek == Calendar.THURSDAY) {
                //advance the start date to next Tuesday
                while (rptStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.TUESDAY) {
                    rptStartDate.add(Calendar.DATE, 1);
                }

                //advance the end date to Tuesday as needed
                rptEndDate = (Calendar) rptStartDate.clone();
                while (rptEndDate.get(Calendar.DAY_OF_WEEK) != Calendar.TUESDAY) {
                    rptEndDate.add(Calendar.DATE, 1);
                }
            } else if (dayOfWeek == Calendar.FRIDAY) {
                //advance the date to next Wednesday
                while (rptStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY) {
                    rptStartDate.add(Calendar.DATE, 1);
                }

                //advance the end date to Wednesday as needed
                rptEndDate = (Calendar) rptStartDate.clone();
                while (rptEndDate.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY) {
                    rptEndDate.add(Calendar.DATE, 1);
                }
            }

            rptDates = new HashMap<String, Date>();

            rptDates.put("startDate", rptStartDate.getTime());
            rptDates.put("endDate", rptEndDate.getTime());

            LOGGER.info("********************************************************************************");
            LOGGER.info("StartDate: " + dateFormat.format(rptStartDate.getTime()));
            LOGGER.info("EndDate: " + dateFormat.format(rptEndDate.getTime()));
            LOGGER.info("********************************************************************************");
        }

        return rptDates;
    }

    private static void createTaleoOrientationReport(TaleoClient taleoClient, AuthToken authToken, List<SearchResults> requistions) {

        List<OrientationRecord> orientationRecords;
        List<CandToReqs> candidateApps;

        if (requistions != null && !requistions.isEmpty()) {
            LOGGER.info("########## of Requisitions found ========== " + requistions.size());

            orientationRecords = new ArrayList<OrientationRecord>();

            //Step 2: For each Requisition, find all Candidate Applications
            for (SearchResults result : requistions) {
                Requisition req = result.getRequisition();
                Department dept = taleoClient.getSapDepartmentById(authToken, req.getDepartment());
                req.setSapDepartment(dept.getDepartmentName());

                OrientationRecord orientationRecord = new OrientationRecord();
                //get the Requisition owners
                List<RequisitionOwner> owners = taleoClient.getRequisitionOwners(authToken, req.getReqId());
                //The eventual report only has room for one Owner Firstname", so use the first owner in the list
                RequisitionOwner requisitionOwner = null;
                if (owners != null && owners.size() > 0) {
                    requisitionOwner = owners.get(0);
                    orientationRecord.setRequisitionOwnerFirstName(requisitionOwner.getUser().getFirstName());
                }

                candidateApps = taleoClient.getCandidateApplications(authToken, req.getReqId());

                //Step 3: For each Candidate Applicant, combine with the Requisition info to create and OrientationRecord
                for (CandToReqs candToReqs : candidateApps) {
                    CandidateApplication candidateApplication = candToReqs.getCandidateApplication();

                    //only process hired candidates
                    if (candidateApplication.getStatus() == 16) {//in Taleo, Status = 16 ==> Hired
                        Candidate candidate = taleoClient.getCandidateByID(authToken, candidateApplication.getCandidateId());

                        orientationRecord.setBcmDepartment(req.getSapDepartment());
                        orientationRecord.setBcmid(req.getBcmid());
                        orientationRecord.setReqId(req.getReqId());

                        orientationRecord.setJobTitle(req.getTitle());
                        orientationRecord.setSAPStartDate(req.getSAPStartDate());
                        LOGGER.fine("----------------- | ReqID = " + req.getReqId() + " | CandLastname = " + candidate.getLastName() + " | SAPStartDate = " + req.getSAPStartDate());

                        orientationRecord.setReqDepartmentalContact(req.getReqDepartmentalContact());

                        orientationRecord.setEmail(candidate.getEmail());
                        orientationRecord.setVisaSponsorship(candidate.getVisaSponsorship());
                        orientationRecord.setLegalFirstName(candidate.getFirstName());
                        orientationRecord.setLegalLastName(candidate.getLastName());
                        orientationRecord.setLegalStatus(candidate.getLegalStatus());
                        orientationRecord.setStartDate(candidate.getStartDate());
                        orientationRecord.setHiredDate(candidate.getHiredDate());
                        //add the new record to the list
                        if (!orientationRecords.contains(orientationRecord)) {
                            orientationRecords.add(orientationRecord);
                        }
                    }
                }
            }
            //Step 4: Send the final list of OrientationRecords to output
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.createTaleoOrientationReport(orientationRecords, reportOutputPath);
        }
    }

    private static void printObjects(List<TaleoObject> taleoObjects) {
        //print out the TaleoObjects;
        if (taleoObjects != null) {
            Iterator iter = taleoObjects.iterator();
            while (iter.hasNext()) {
                TaleoObject obj = (TaleoObject) iter.next();
                LOGGER.info(obj.toString());
            }
            LOGGER.info("************** No of records found ======== " + taleoObjects.size());
        } else {
            LOGGER.info("************** No records found");
        }
    }
}

