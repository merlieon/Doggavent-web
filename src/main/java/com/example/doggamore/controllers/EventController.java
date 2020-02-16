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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.jws.WebParam;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    HttpHandler httpHandler;

    String eventTitle;

    // Getting all events
    @GetMapping("/events")
    public String getEvents(Model model) throws IOException, JSONException, ParseException {
        model.addAttribute("eventList",eventService.getAllEvents());
        return "events";
    }

    // Getting event by id
    @GetMapping("/events/{id}")
    public String getEventById(@PathVariable("id") int id, Model model) throws IOException, JSONException, ParseException {
        Event event = new Event();
        for (Event e: eventService.getAllEvents()) {
            if (id == e.getId()){
                event.setEventTitle(e.getEventTitle());
                event.setEventContent(e.getEventContent());
                event.setCreatedDate(e.getCreatedDate());
            }
        }
        System.out.println(event.getEventContent());
        model.addAttribute("event", event);
        model.addAttribute("currentId", id);
        return "event";
    }

    // GetMappig for Creating new event
    @GetMapping(path = "/addevent")
    public String getAddEvent(Model model) {
        model.addAttribute("createEvent", new Event());
        return "addevent";
    }

    //Posting new creationg o event
    @PostMapping(path = "/addevent", consumes = "application/x-www-form-urlencoded")
    public String createEvent(@ModelAttribute Event event, Model model, SessionStatus status) throws IOException {

        eventService.createEvent("https://doggavent.herokuapp.com/api/event/add", new Event(event.getEventTitle(), event.getEventContent()));
        status.setComplete();
        return "redirect:addevent_success";
    }


    // Success of creating new event
    @GetMapping("/addevent_success")
    public String createEventSuccess(){
        return "addevent_success";
    }
    //ResponseEntity(HttpStatus.CREATED)

    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") String id, Model model){
        model.addAttribute("deleteEvent", eventService.deleteEvent("https://doggavent.herokuapp.com/api/event/{id}", id));
        return new ResponseEntity(HttpStatus.OK);
    }

}
