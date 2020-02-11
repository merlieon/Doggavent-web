package com.example.doggamore.controllers;

import com.example.doggamore.handlers.HttpHandler;
import com.example.doggamore.models.Event;
import com.example.doggamore.services.EventService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    HttpHandler httpHandler;

    String eventTitle;

    @GetMapping("/events")
    public String getEvents(Model model) throws IOException, JSONException {
        model.addAttribute("eventList",eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/events/{id}")
    public String getEventById(@PathVariable("id") int id, Model model) throws IOException, JSONException {
       model.addAttribute("eventList",eventService.getAllEvents());
       model.addAttribute("currentId", id);
        return "event";
    }

    @GetMapping(path = "/addevent")
    public String getAddEvent(){
        return "addevent";
    }

    @PostMapping(path = "/addevent", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> createEvent(Event event) throws IOException {
        eventService.createEvent("https://doggavent.herokuapp.com/api/event/add");
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
