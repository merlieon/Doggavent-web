package com.example.doggamore.handlers;

import com.example.doggamore.models.Event;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HttpHandler {

    public String httpGetConnection(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        };

        in.close();
        return response.append(inputLine).toString();
    }

    public void getParams(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder strB = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()){
            strB.append(URLEncoder.encode(entry.getKey(), "UTF-8"));

        }
    }


    public String httpPostConnection(String url, Event event) throws IOException {
        URL obj = new URL(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Event> entity = new HttpEntity<Event>(event,headers);
        return restTemplate.exchange(url, HttpMethod.POST,entity,String.class).getBody();

    }



}
