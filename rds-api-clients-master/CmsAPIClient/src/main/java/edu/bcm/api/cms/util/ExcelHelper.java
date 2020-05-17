package edu.bcm.api.cms.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ExcelHelper {

    private static final Logger LOGGER = Logger.getLogger(ExcelHelper.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("cmsClient");

    public ExcelHelper() {
    }

    public List<String> getProfileIdCSVs() {

        List<String> profileCSVs = new ArrayList<String>();
        StringBuilder profilesCSV = new StringBuilder();

        try {

            XSSFWorkbook workbook = null;
            String filename = resourceBundle.getString("MasterProfilesFileName");
            String filepath = resourceBundle.getString("MasterProfilesFilePath");
            String fileUri = filepath + File.separator + filename;

            FileInputStream excelFile = new FileInputStream(new File(fileUri));


            workbook = new XSSFWorkbook(excelFile);
            XSSFSheet profileIdSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = profileIdSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Cell currentCell = currentRow.getCell(0);

                if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    Double cellValue = currentCell.getNumericCellValue();
                    profilesCSV.append("'" + cellValue.intValue() + "',");//use intValue to remove decimals
                    // profilesCSV.append(cellValue.intValue()+ ",");//use intValue to remove decimals

                }
                if (profilesCSV.length() > 1000 || !iterator.hasNext()) {//stay well below 4000 (max characters for SOQL IN clause)
                    profilesCSV.deleteCharAt(profilesCSV.lastIndexOf(","));
                    profileCSVs.add(profilesCSV.toString());
                    long numOfIDs = profilesCSV.toString().chars().filter(ch -> ch == ',').count();

                    profilesCSV = new StringBuilder();
                }
            }
            workbook.close();
            excelFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return profileCSVs;
    }

    public String getProfileIdCSV() {

        StringBuilder profilesCSV = new StringBuilder();

        try {

            XSSFWorkbook workbook = null;
            String filename = resourceBundle.getString("MasterProfilesFileName");
            String filepath = resourceBundle.getString("MasterProfilesFilePath");
            String fileUri = filepath + File.separator + filename;

            FileInputStream excelFile = new FileInputStream(new File(fileUri));


            workbook = new XSSFWorkbook(excelFile);
            XSSFSheet profileIdSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = profileIdSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Cell currentCell = currentRow.getCell(0);

                if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    Double cellValue = currentCell.getNumericCellValue();
                    profilesCSV.append(cellValue.intValue() + ",");//use intValue to remove decimals
                }
            }
            workbook.close();
            excelFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return profilesCSV.toString();
    }

    public String getBcmColumns(String dataType) {

        StringBuilder fieldsCSV = new StringBuilder();

        try {

            XSSFWorkbook workbook = null;
            String filename = resourceBundle.getString("FieldsRequestedFileName");
            String filepath = resourceBundle.getString("FieldsRequestedFilePath");
            String fileUri = filepath + File.separator + filename;

            FileInputStream excelFile = new FileInputStream(new File(fileUri));

            workbook = new XSSFWorkbook(excelFile);
            XSSFSheet fieldListSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = fieldListSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Cell currentCell = currentRow.getCell(0);

                if (dataType.equalsIgnoreCase(currentCell.getStringCellValue())) {
                    //fieldsCSV.append("'" + currentRow.getCell(1).getStringCellValue()+ "',");
                    fieldsCSV.append(currentRow.getCell(1).getStringCellValue() + ",");

                }
            }
            fieldsCSV.deleteCharAt(fieldsCSV.lastIndexOf(","));//remove trailing comma

            workbook.close();
            excelFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fieldsCSV.toString();
    }
}
