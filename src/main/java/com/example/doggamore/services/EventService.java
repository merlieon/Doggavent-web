package com.example.doggamore.services;

import com.example.doggamore.handlers.HttpHandler;
import com.example.doggamore.models.Event;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class EventService {

    @Autowired
    HttpHandler httpHandler;

    // Getting all events to list
    public List<Event> getAllEvents() throws IOException, JSONException, ParseException {
        String url = "https://doggavent.herokuapp.com/api/json/events";
        JSONArray eventResponse = new JSONArray(httpHandler.httpGetConnection(url).toString());

        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < eventResponse.length(); i++) {
            int id = eventResponse.getJSONObject(i).getInt("id");
            String eventTitle = eventResponse.getJSONObject(i).getString("eventTitle");
            String eventContent = eventResponse.getJSONObject(i).getString("eventContent");
            String eventCreatedDate = eventResponse.getJSONObject(i).getString("createdDate");
            eventList.add(new Event(id,eventTitle,eventContent,eventCreatedDate));

        }
        return eventList;
    }


    //Creating event
    public void createEvent(String  url, Event newEvent) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Event eventResult = restTemplate.postForObject(url,newEvent,Event.class);
    }

    // Deleting event
    public String deleteEvent(String url, String id){
        String uri = url;
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, params);
        return "delete";
    }

}
