package edu.bcm.api.taleo.util;

import edu.bcm.api.taleo.entity.OrientationRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ExcelHelper {

    private static final Logger LOGGER = Logger.getLogger(ExcelHelper.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("cmsClient");

    public ExcelHelper() {
    }

    public void createTaleoOrientationReport(List<OrientationRecord> orientationRecordList,
                                             String... reportOutputPath) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
        String outputFilename =
                dateFormat.format(Calendar.getInstance().getTime()) + "_NEO_TALEO.xlsx";

        dateFormat.applyPattern(("yyyy-MM-dd"));
        XSSFWorkbook workbook = null;

        try {

            if (orientationRecordList != null && !orientationRecordList.isEmpty()) {
                workbook = new XSSFWorkbook();
                XSSFSheet worksheet = workbook.createSheet("sheet1");

                int rowNum = 0;

                //create header row
                Row header = worksheet.createRow(rowNum++);
                header.createCell(0).setCellValue("Requisitions - Sap Start Date");
                header.createCell(1).setCellValue("Requisitions - Bcm Id");
                header.createCell(2).setCellValue("Candidates - Legal Last Name");
                header.createCell(3).setCellValue("Candidates - Legal First Name");
                header.createCell(4).setCellValue("Requisitions - Sap Department");
                header.createCell(5).setCellValue("Requisitions - Job Title");
                header.createCell(6).setCellValue("Candidates - Work Authorization");
                header.createCell(7).setCellValue("Candidates - Visa Sponsorship");
                header.createCell(8).setCellValue("Requisition Owners - First Name");
                header.createCell(9).setCellValue("Candidates - Email");
                //header.createCell(10).setCellValue("Candidate - HiredDate");

                for (OrientationRecord orientationRecord : orientationRecordList) {
                    int colNum = 0;
                    Row row = worksheet.createRow(rowNum++);

                    Cell cell = row.createCell(colNum++);
                    if (orientationRecord.getSAPStartDate() != null) { //nullcheck to avoid NPE during formatting
                        //since the recorded sapStartDate is a weekend, add a day to match the NEO Reports in Taleo
                        GregorianCalendar sapStartDate = new GregorianCalendar();
                        sapStartDate.setTime(orientationRecord.getSAPStartDate());
                        sapStartDate.add(Calendar.DATE, 1);
                        cell.setCellValue(dateFormat.format(sapStartDate.getTime()));
                    } else {
                        cell.setCellValue(orientationRecord.getSAPStartDate());
                    }
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getBcmid());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getLegalLastName());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getLegalFirstName());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getBcmDepartment());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getJobTitle());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getLegalStatus());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getVisaSponsorship());
                    cell = row.createCell(colNum++);
                    //need to find out how to get this value from Taleo APIs
                    cell.setCellValue(orientationRecord.getRequisitionOwnerFirstName());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(orientationRecord.getEmail());
/*                    cell = row.createCell(colNum++);
                    if(orientationRecord.getHiredDate() != null) {
                        cell.setCellValue(dateFormat.format(orientationRecord.getHiredDate()));
                    }else{
                        cell.setCellValue(orientationRecord.getHiredDate());
                    }*/
                }
            }

            if (workbook != null) {
                if (reportOutputPath != null && reportOutputPath[0] != null) {
                    outputFilename = reportOutputPath[0] + File.separator + outputFilename;
                }
                FileOutputStream outputStream = new FileOutputStream(outputFilename);
                workbook.write(outputStream);

                //send a copy to the FileMakerPro Network share.
                FileUtility fileUtility = new FileUtility();
                fileUtility.copyFiles(workbook);

                workbook.close();
                outputStream.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
