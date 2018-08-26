package tests;

import com.fatboa.facebook.ApiParser;

import java.net.URL;
import java.nio.file.*;

import org.glassfish.grizzly.streams.StreamReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ApiParserTest {

    @Test
    void getSenderId() {
        System.out.println();



       String content;
        try {
            content=new String(Files.readAllBytes(Paths.get(
                    getClass().getClassLoader().getResource("testFacebookAPI.json").getPath())));
        } catch (IOException e) {
            e.printStackTrace();
            fail("");
            return;
        }
        ApiParser apiParser;
        try {
            apiParser = ApiParser.Builder.build(content);
        } catch (IOException e) {
            fail(e.getMessage());
            return;
        }
        String senderId=apiParser.getSenderId();
        assertEquals("1797778690300375", senderId);
    }
}