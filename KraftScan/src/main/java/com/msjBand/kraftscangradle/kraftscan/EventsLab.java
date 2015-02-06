package com.msjBand.kraftscangradle.kraftscan;


import android.content.Context;

import java.util.ArrayList;
import java.util.TimeZone;


public class EventsLab {

    private static EventsLab sEventsLab;
    private Context mAppContext;

    private ArrayList<Event> mEvents;

    private EventsLab(Context appContext) {

        mAppContext = appContext;
        mEvents = new ArrayList<Event>();

        // Mandatory Meeting
        Event e = new Event(TimeZone.getTimeZone("America/Los_Angeles"), 2015, 1, 29, 15, 30, 0);
        e.setTitle("Mandatory Meeting");
        e.setOccurred(false);
        mEvents.add(e);

        // Arrival @ 5am
        e = new Event(TimeZone.getTimeZone("America/Los_Angeles"), 2015, 3, 30, 5, 0, 0);
        e.setTitle("Airport SFO");
        e.setNotes("Arrive at SFO American Airlines Domestic Departures Terminal 2");
        e.setOccurred(false);
        mEvents.add(e);

        // Departure of Flight 2283
        e =  new Event(TimeZone.getTimeZone("America/Los_Angeles"), 2015, 3, 30, 8, 35, 0);
        e.setTitle("Flight 2283 Departure");
        e.setNotes("\tSan Fransisco Airport to Dallas Forth Worth International Airport. Remember to transfer to flight 048 at 7:35 local time. \n\nFlight 2283 Roster:\n"
        + "Monica Kraft\nWenhan Fang\nSathvik Vivek\nYu-Cheng Chou\nYu-Ting Chou\nJemmy Zhou\nRaymong Yin\nJianXiang Liu\nNikhil Pathania\nAllison Xu\nCharles Xu\nSharleen Zhou");
        e.setOccurred(false);
        mEvents.add(e);


    }

    public static EventsLab get(Context c) {
        if (sEventsLab == null) {

            sEventsLab = new EventsLab(c.getApplicationContext());
        }

        return sEventsLab;

    }

    public Event getEvent(int position) {

        return mEvents.get(position);

    }

    public ArrayList<Event> getEvents() {return mEvents;}





}
