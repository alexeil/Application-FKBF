package main.java.generators;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.ServiceException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;


public class RankingGeneratorFromGoogle

{
    // Generate a service account and P12 key:
// https://developers.google.com/identity/protocols/OAuth2ServiceAccount
    // private final String CLIENT_ID = "8d11e924bc79c066e1abe45c4bb1bcb0a6197b0f";
    //private static final String CLIENT_ID = "thierry.boschat@gmail.com";
    //private static final String CLIENT_ID = "80017292995.project.googleusercontent.com";
    // private static final String CLIENT_ID ="8d11e924bc79c066e1abe45c4bb1bcb0a6197b0f@developer.gserviceaccount.com";
    // private static final String CLIENT_ID = "application-fkbf@appspot.gserviceaccount.com";
    //private static final String CLIENT_ID = "80017292995-mqlpcjna2j7idg5b2au3cf69m6thca0k.apps.googleusercontent.com";
    private final static String CLIENT_ID = "240460901799-compute@developer.gserviceaccount.com";
    //
    // Add requested scopes.
    // private static final List<String> SCOPES = Arrays.asList("https://spreadsheets.google.com/feeds");
   // private static final List<String> SCOPES = Arrays.asList("https://spreadsheets.google.com/feeds", "https://spreadsheets.google.com/feeds/spreadsheets/private/full", "https://docs.google.com/feeds");
    private static final List<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/drive.file", "https://www.googleapis.com/auth/userinfo.email",
            "https://www.googleapis.com/auth/userinfo.profile", "https://docs.google.com/feeds", "https://spreadsheets.google.com/feeds",
            "http://spreadsheets.google.com/feeds/spreadsheets/", "https://spreadsheets.google.com/feeds/spreadsheets/private/full");


    // The name of the p12 file you created when obtaining the service account
   // private static final String P12FILE = "E:\\dev\\src\\Application-FKBF\\Application FKBF\\Application FKBF-8d11e924bc79.p12";
    private final static String P12FILE = "E:\\dev\\src\\Application-FKBF\\Application FKBF\\src\\main\\resources\\API-project-Spreadsheet-39f77a0dc547.p12";
    private static SpreadsheetService service;


    public static void main(String[] args) throws GeneralSecurityException,
            IOException, ServiceException, URISyntaxException {

        //  SpreadsheetService service = new SpreadsheetService(
        //          "google-spreadsheet");
        //  GoogleCredential credential = getCredentials();
        //  service.setOAuth2Credentials(credential);

        //  https://docs.google.com/spreadsheets/d/1Dnw8hN_8UEE0Y7SLOl7BpYyuMA0tEcJuXHlasjMOjCE/edit?usp=sharing
     //   URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/1Dnw8hN_8UEE0Y7SLOl7BpYyuMA0tEcJuXHlasjMOjCE");
        URL SPREADSHEET_FEED_URL = new URL(
                "https://spreadsheets.google.com/feeds/spreadsheets/private/full/1Dnw8hN_8UEE0Y7SLOl7BpYyuMA0tEcJuXHlasjMOjCE");

        // URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/worksheets/1SuBy4pTyIMHEJhGH9cMDtu4mQAGAjfnUlgAXdOD277M");
        //  SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
        //      SpreadsheetFeed.class);

        // initialise le service
        service = initService();

        // récupère la spreadsheet
        //SpreadsheetEntry spreadsheet = service.getEntry(SPREADSHEET_FEED_URL, SpreadsheetEntry.class);
        SpreadsheetEntry feed = service.getEntry(SPREADSHEET_FEED_URL,
                SpreadsheetEntry.class);

        //List<SpreadsheetEntry> spreadsheets = feed.getEntries();

        //if (spreadsheets.size() == 0) {
            // // TODO: There were no spreadsheets, act accordingly.
       // }
        //
      //  SpreadsheetEntry spreadsheet = spreadsheets.get(0);
      //s  System.out.println(spreadsheet.getTitle().getPlainText());

    }

    public static SpreadsheetService initService()
            throws GeneralSecurityException, IOException {

        if (service == null) {
            HttpTransport httpTransport = new NetHttpTransport();
            JacksonFactory jsonFactory = new JacksonFactory();

            GoogleCredential credential = null;

            credential = new GoogleCredential.Builder()
                    .setTransport(httpTransport).setJsonFactory(jsonFactory)
                    .setServiceAccountId(CLIENT_ID)
                    .setServiceAccountScopes(SCOPES)
                    .setServiceAccountPrivateKeyFromP12File(getP12File())
                    .build();

            service = new SpreadsheetService("Test");

            service.setOAuth2Credentials(credential);

        }
        return service;
    }

    private static File getP12File() {
        File p12 = new File(P12FILE);
        return p12;
    }

   /* private static GoogleCredential getCredentials() throws GeneralSecurityException,
            IOException, URISyntaxException {
        JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

       // URL fileUrl = this.getClass().getResource(P12FILE);
        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountId(CLIENT_ID)
                .setServiceAccountPrivateKeyFromP12File(
                        new File(P12FILE))
                .setServiceAccountScopes(SCOPES).build();
                 credential.refreshToken();

        return credential;
    }*/

}

