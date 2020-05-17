package edu.bcm.api.sharepoint.main;


import edu.bcm.api.sharepoint.client.SharePointClient;

import java.util.logging.Logger;

public class SharePointMain {

    private static final Logger LOGGER = Logger.getLogger(SharePointMain.class.getName());

    public static void main(String[] args) {

        SharePointClient client = new SharePointClient();

        try {

            client.listFlushotFile();
            System.exit(1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
