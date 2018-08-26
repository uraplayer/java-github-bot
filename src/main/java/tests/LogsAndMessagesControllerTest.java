package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatboa.messaging.Log;
import com.fatboa.messaging.Logger;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LogsAndMessagesControllerTest {

    @Test
    void getLogsJsonHandler() {

        String botName = "botik";
        Log log = new Log("Message one");
        Logger.putLog(botName, log);

        URL getLogsURL;
        HttpURLConnection con;
        try {
            getLogsURL = new URL("http://localhost:5000/getlogsjson/" + botName);
            con = (HttpURLConnection) getLogsURL.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }

        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        String jsonString;
        try {
            jsonString = readContent(con);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }
        con.disconnect();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String srcString = mapper.writeValueAsString(log);
            assertEquals(srcString, jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private String readContent(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        return content.toString();
    }


}