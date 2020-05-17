package edu.bcm.api.taleo.util;

/**
 * JCIFS is an Open Source client library that implements the CIFS/SMB networking protocol in 100% Java.
 * CIFS is the standard file sharing protocol on the Microsoft Windows platform
 * Visit their website at: jcifs.samba.org
 * <p>
 * Uses: jcifs-1.1.11.jar
 */

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class FileUtility {

    private static final Logger LOGGER = Logger.getLogger(FileUtility.class.getName());
    private static String networkUser = "svc_boreports";
    private static String networkPw = "B0bPr0d6";
    private static String networkPath = "smb://EVW-FMP-P001/D/Program Files/FileMaker/FileMaker Server/Data/Documents/";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("taleoClient");

    public FileUtility() {

        networkUser = resourceBundle.getString("networkUser");
        networkPw = resourceBundle.getString("networkPw");
        networkPath = "smb://" + resourceBundle.getString("networkPath");
    }

    public boolean copyFiles(XSSFWorkbook workbook) {

        boolean successful = false;
        ByteArrayOutputStream bos = null;
        SmbFileOutputStream sfos = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
            String fileName = dateFormat.format(Calendar.getInstance().getTime()) + "_NEO_TALEO.xlsx";

            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("bcm", networkUser, networkPw);
            String path = networkPath + fileName;
            LOGGER.info("Path: " + path);

            //convert the workbook into a byte array
            bos = new ByteArrayOutputStream();
            workbook.write(bos);

            byte[] bytes = bos.toByteArray();

            //write the data to the network share
            SmbFile sFile = new SmbFile(path, auth);
            sfos = new SmbFileOutputStream(sFile);
            sfos.write(bytes);

            successful = true;

        } catch (Exception e) {
            successful = false;
            e.printStackTrace();

        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (sfos != null) {
                    sfos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("Successful: " + successful);

        return successful;
    }

    public boolean copyFiles(String fileContent, String fileName) {

        boolean successful = false;

        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("bcm", networkUser, networkPw);
            String path = networkPath + fileName;
            LOGGER.fine("Path: " + path);

            SmbFile sFile = new SmbFile(path, auth);
            SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
            sfos.write(fileContent.getBytes());

            successful = true;
            LOGGER.info("Successful" + successful);

        } catch (Exception e) {
            successful = false;
            e.printStackTrace();
        }
        return successful;
    }
}
