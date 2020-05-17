package edu.bcm.api.medhub.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bcm.api.medhub.client.MedHubClient;
import edu.bcm.api.medhub.entity.MedHubResident;
import edu.bcm.api.medhub.entity.ResidentSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class MedHubMain {
    private static final Logger LOGGER = Logger.getLogger(MedHubMain.class.getName());

    public static void main(String[] args) {

        MedHubClient client = new MedHubClient();

        client.sendImmunizationsReports("ecw-rapiws-d01.ad.bcm.edu");
        System.exit(7);


/*        client.findAllMatches("localhost");
        System.exit(8);

        String token = client.getPdmToken("","svc_edw", "W@r3house");
        System.out.println("***** Token: " + token);

        client.getAmulatoryEnrollmentCandidate(token, "sanyang");
        System.exit(9);*/

/*        Field[] fields = MedHubResident.class.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() + ": " + field.getType().getSimpleName());
        }
        System.exit(1);*/

        // client.loadAllResidents("ecw-rapiws-p01.ad.bcm.edu");//prod
        client.loadAllResidents("localhost");//local
        System.exit(4);

//        client.loadLdapPersons("ecw-rapiws-p01.ad.bcm.edu");
//        System.exit(1);

/*        client.findAllMatches("ecw-rapiws-p01.ad.bcm.edu");
        System.exit(1);*/

/*        client.getAllActivePersons("ecw-rapiws-p02.ad.bcm.edu");
        System.exit(1);*/

/*        testPdmAccountMatching("localhost");
        System.exit(1);*/


/*        client.propagateAllPendingIDM3("ecw-rapiws-p01.ad.bcm.edu");
        System.exit(1);*/

/*        List<String> userIDs = new ArrayList<>();
        userIDs.add("18383");
       // userIDs.add("16225");

        List<MedHubResident> residents = searchUsers(userIDs);

        for (MedHubResident res : residents) {
            LOGGER.info(res.toString());
            //    LOGGER.info(res.getFirstName() + " | " + res.getStatus() + " | " + res.getBirthDate());
        }
        System.exit(2);*/


/*        searchEmployees();
        System.exit(2);*/

/*        client.setTestMode(false);
        HashMap<String, String> fields = new HashMap<>();
        fields.put("empl_id", "207791");
        fields.put("email_address", "Davut.Cekmecelioglu2@bcm.edu");
        fields.put("username", "cekmecel");
        String userId = "18383";

        LOGGER.info("Before: " + client.getResidentDetails(userId));
        propagateIDM3Medhub(userId, fields);
        LOGGER.info("After: " + client.getResidentDetails(userId));

        System.exit(3);*/

        // client.testMedhubAPIConnection();
        // client.listAccessibleAPIs();
        // client.loadAllResidents();
        // client.loadLdapPersons();

/*        client.getAllResidentsString(15570, 19000);
        System.exit(5);*/

/*
        LOGGER.info(client.getAllResidentsString());

        LOGGER.info(client.getResidentDetails("15571"));
        System.exit(6);
*/
        List<ResidentSummary> residentSummaries = client.getActiveResidents();
        LOGGER.info("no of residents found = " + residentSummaries.size());
        System.out.print("Email | BcmECA | EmployeeID | EmailAddress ");

        for (ResidentSummary res : residentSummaries) {
            MedHubResident resident = client.getResidentDetails(res.getUserID());

            try {

                LOGGER.info(resident.getEmail() + " | " + resident.getBcmEca() + " | " + resident.getEmployeeID()
                        + " | " + resident.getEmailAddress());

            } catch (Exception e) {
                e.printStackTrace();
            }

            // System.exit(1);
        }

/*        List<String> programIDs = client.getAllProgramIDs();
        for(String pid: programIDs){
            LOGGER.info(pid);
        }*/
    }

    private static void testPdmAccountMatching(String host) {

        String content = "{\"bcmId\":\"\", \"eca\":\"\", \"email\":\"\", \"lastName\":\"\", \"middleName\":\"\"," +
                "\"firstName\":\"Melinda\", \"birthDate\":\"1964-02-15\", \"startDate\":\"2019-04-01\", \"hireDate\":\"2019-04-01\"," +
                "\"personType\":\"EMPLOYEE\", \"camsId\":\"\", \"sfId\":\"20000057\", \"medhubId\":\"\", \"idmId\":\"\"," +
                "\"accountRequestId\":\"5323\"}";
        // String myjson = "{\"bcmId\":\"\", \"eca\":\"\", \"email\":\"\", \"firstName\":\"New\", \"middleName\":\"Test\", \"lastName\":\"Hire\", \"birthDate\":\"1983-07-01\", \"startDate\":\"2019-08-02\", \"hireDate\":\"2019-08-02\", \"personType\":\"\", \"camsId\":\"\", \"sfId\":\"20000003\", \"medhubId\":\"\", \"idmId\":\"\", \"accountRequestId\":\"388\"}";
        String myjson = "{\"bcmId\":\"\", \"eca\":\"\", \"email\":\"\", \"firstName\":\"Mona\", \"middleName\":\"test\", " +
                "\"lastName\":\"Alweiss\", \"birthDate\":\"1977/12/18\", \"startDate\":\"\", \"hireDate\":\"\", " +
                "\"personType\":\"RESIDENT\", \"camsId\":\"\", \"sfId\":\"\", \"medhubId\":\"18422\", \"idmId\":\"\", \"accountRequestId\":\"262\"}";

        //  LOGGER.info(content);

        MedHubClient client = new MedHubClient();
        client.findPdmAccountMatches(host, myjson);

    }

    private static void propagateIDM3Medhub(String userId, HashMap fields) {
        MedHubClient client = new MedHubClient();

        if (userId != null && fields != null && fields.size() > 0) {

            String updatedStatus = client.updateResident(userId, fields);
            LOGGER.info("updatedStatus === " + updatedStatus);
        }
    }

    private static List<MedHubResident> searchUsers(List<String> userIDs) {
        ObjectMapper mapper = new ObjectMapper();
        MedHubClient client = new MedHubClient();
        client.setTestMode(false);

        List<MedHubResident> residents = null;

        try {
            String residentDetailsStringList = client.getResidentDetailsStringList(userIDs);
            // LOGGER.info(residentDetailsStringList);

            JsonNode jsonNode = mapper.readValue(residentDetailsStringList, JsonNode.class);
            residents = mapper.readValue(mapper.treeAsTokens(jsonNode), new TypeReference<List<MedHubResident>>() {
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return residents;
    }

    private static void searchEmployees() {
        ObjectMapper mapper = new ObjectMapper();
        MedHubClient client = new MedHubClient();
        client.setTestMode(false);
        List<ResidentSummary> residentSummaries = null;

        List<String> employees = new ArrayList<String>();
        employees.add("189778");
        employees.add("189782");
        employees.add("169833");
        employees.add("190022");


        try {
/*            String residentDetailsStringList = client.getResidentDetailsStringList(employees);
            LOGGER.info(residentDetailsStringList);
            JsonNode jsonNode = mapper.readValue(residentDetailsStringList, JsonNode.class);
            List<MedHubResident> residents = mapper.readValue(mapper.treeAsTokens(jsonNode), new TypeReference<List<MedHubResident>>() {
            });

 */
            for (String emp : employees) {
                LOGGER.info(client.findResidentByEmployeeId(emp));
                JsonNode jsonNode = mapper.readValue(client.findResidentByEmployeeId(emp), JsonNode.class);
                ResidentSummary summary = mapper.readValue(client.findResidentByEmployeeId(emp), ResidentSummary.class);

                LOGGER.info(client.getResidentDetails(summary.getUserID()).toString());

            }
            //System.exit(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void testLoadAllResidents() {
        List<MedHubResident> residents;
        List<ResidentSummary> residentSummaries;
        String residentStrings;
        MedHubClient medHubClient = new MedHubClient();
        ObjectMapper mapper = new ObjectMapper();

        try {
            medHubClient.setTestMode(true);
            residentStrings = medHubClient.getAllResidentsString();

            //use Jackson to extract returned JSON object into a corresponding Java Object
            JsonNode jsonNode = mapper.readValue(residentStrings, JsonNode.class);
            residents = mapper.readValue(mapper.treeAsTokens(jsonNode), new TypeReference<List<MedHubResident>>() {
            });

            for (MedHubResident resident : residents) {
                try {
                    String summaryStr = medHubClient.residentSearch(resident.getNameLast(), resident.getUsername(),
                            resident.getEmployeeID());
                    LOGGER.info("SummaryStr = " + summaryStr);
                    //use Jackson to extract returned JSON object into a corresponding Java Object
                    JsonNode summaryJsonNode = mapper.readValue(summaryStr, JsonNode.class);
                    residentSummaries = mapper.readValue(mapper.treeAsTokens(summaryJsonNode),
                            new TypeReference<List<ResidentSummary>>() {
                            });

                    if (residentSummaries != null && residentSummaries.size() == 1) {
                        //found an exact match
                        ResidentSummary summary = residentSummaries.get(0);
                        LOGGER.info(summary.toString());
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //todo:send email to admins
        }
    }

}
