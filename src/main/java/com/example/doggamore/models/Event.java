package com.example.doggamore.models;

public class Event {

    int id;
    String eventTitle;
    String eventContent;

    public Event(){

    }

    public Event(int id, String eventTitle, String eventContent) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
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
}
