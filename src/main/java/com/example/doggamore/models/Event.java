package com.example.doggamore.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {

    int id;
    String eventTitle;
    String eventContent;
    String createdDate;
    public Event(){

    }
    public Event(String eventTitle, String eventContent) {
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
    }
    public Event(String eventTitle, String eventContent, String createdDate) {
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.createdDate = createdDate;
    }

    public Event(int id, String eventTitle, String eventContent, String createdDate) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.createdDate = createdDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
