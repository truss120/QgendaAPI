package edu.bcm.rds.api.sap.main;

import edu.bcm.rds.api.sap.client.SAPClient;

public class SAPMain {

    public static void main(String[] args) {

        SAPClient client = new SAPClient();

        String token = client.getToken("username", "pw");
        //  String struct = client.getSchedulingUrls(token, "5688650");//4941876
        //  System.out.println("***** struct: "+ struct);

        client.runReportNow(token, "5688650");
        //  client.logout();
        System.exit(8);

        //System.out.println("***** Token: " + token);
    }
}
