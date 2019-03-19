import org.junit.jupiter.api.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.logging.Logger;


import org.json.JSONObject;


public class PatientTest {

    String urlBase = "http://localhost:8080/Patient-1.0-SNAPSHOT/rs/Patient/";
    Logger log = Logger.getLogger(PatientTest.class.getName());

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Test
    public void createPatient() throws IOException {

        InputStream is = null;

        is = new URL(urlBase + "newPatient?nom=SHAR&prenom=INGAN&addresse=labas&genre=M&ss=213").openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        HashMap<String, Object> ds = (HashMap<String, Object>) json.toMap().get("donneesSociales");
        Assertions.assertEquals("SHAR", ds.get("nom"));
        Assertions.assertEquals("INGAN", ds.get("prenom"));
        Assertions.assertEquals("SHAR", ds.get("nom"));
        Assertions.assertEquals("labas", ds.get("addresse"));
        Assertions.assertEquals("M", ds.get("genre"));


        is.close();


    }
    @Test
    public void createPatientThenDelete() throws IOException {

        InputStream is = null;

        is = new URL(urlBase + "newPatient?nom=SHAR&prenom=INGAN&addresse=labas&genre=M&ss=213").openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        is = new URL(urlBase + "deletePatient?id=" + json.get("id")).openStream();

        is.close();


    }
    @Test
    public void getPatientByNom() throws IOException {

        InputStream is = null;

        is = new URL(urlBase + "PatientByNom?nom=SHAR").openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));



        is.close();


    }
    @Test
    public void getPatientByNomPrenom() throws IOException {

        InputStream is = null;

        is = new URL(urlBase + "PatientByNomPrenom?nom=SHAR&prenom=INGAN").openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));



        is.close();


    }
}
