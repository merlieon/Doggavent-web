package com.example.doggamore.services;

import com.example.doggamore.handlers.HttpHandler;
import com.example.doggamore.models.Event;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    HttpHandler httpHandler;

    public List<Event> getAllEvents() throws IOException, JSONException {
        String url = "https://doggavent.herokuapp.com/api/json/events";
        JSONArray eventResponse = new JSONArray(httpHandler.httpGetConnection(url).toString());

        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < eventResponse.length(); i++) {
            int id = eventResponse.getJSONObject(i).getInt("id");
            String eventTitle = eventResponse.getJSONObject(i).getString("eventTitle");
            String eventContent = eventResponse.getJSONObject(i).getString("eventContent");

            eventList.add(new Event(id,eventTitle,eventContent));

        }
        return eventList;
    }


    public void createEvent(String  url) throws IOException {
        Event newEvent = new Event(100,"new titlsdfsdfe", "new contasdasdsadent");
        RestTemplate restTemplate = new RestTemplate();
        Event eventResult = restTemplate.postForObject(url,newEvent,Event.class);
    }


}
