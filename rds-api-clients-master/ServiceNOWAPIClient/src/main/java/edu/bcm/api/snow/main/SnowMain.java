package edu.bcm.api.snow.main;

import edu.bcm.api.snow.client.ServiceNowClient;
import edu.bcm.api.snow.entity.SGARequest;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class SnowMain {

    private static final Logger LOGGER = Logger.getLogger(ServiceNowClient.class.getName());

    public static void main(String[] args) {

        ServiceNowClient snc = new ServiceNowClient();

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateStr = "2020 12:00:00 AM-12-7";
            LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
            LocalDateTime parsedDatetime = LocalDateTime.parse(dateStr, formatter);

            System.out.println(parsedDatetime.toString());
            System.exit(1);


            String guestStrings = snc.getAllSGARequestStrings();
            FileWriter fileWriter = new FileWriter("/Users/Sanyang/Downloads/misc/testing2.json");
            fileWriter.write(guestStrings);
            fileWriter.close();
            //    System.out.println(guestStrings);
            System.exit(1);
            snc.setTestMode(false);
            LOGGER.info(snc.getBaseApiURL());
            List<SGARequest> sgaRequests = snc.getAllSGARequests();

            for (SGARequest req : sgaRequests) {
                if (req.getVisaType() != null && req.getVisaType().trim() != null) {
                    if (req.getLastName().equalsIgnoreCase("FLAVIANI")) {
                        LOGGER.info(req.toJsonString());
                    }
                }
            }

            //********** Load SGA data from SNOW
/*          String uri = "http://localhost:8080/pdmService/api";
            WebTarget webTarget = snc.client.target(UriBuilder.fromUri(uri).build());

            Response response = null;

            response = webTarget.path("/persons/loadAllGuests").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadAllResidents Status = " + response.getStatus());*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
