package com.msjBand.android.trip.task;

import android.os.AsyncTask;
import com.android.volley.RequestQueue;
import com.msjBand.android.trip.callbacks.MasterEventsLoadedListener;
import com.msjBand.android.trip.extras.EventUtils;
import com.msjBand.android.trip.network.VolleySingleton;
import com.msjBand.android.trip.pojo.Event;

import java.util.ArrayList;

/**
 * Created by andrewmzhang on 4/4/2016.
 */
public class TaskLoadMasterEvents extends AsyncTask<Void, Void, ArrayList<Event>>{


    private MasterEventsLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    private boolean success;

    public TaskLoadMasterEvents(MasterEventsLoadedListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }



    @Override
    protected ArrayList<Event> doInBackground(Void... params) {

        ArrayList<Event> listEvents = EventUtils.loadMasterEvents(requestQueue);
        return listEvents;
    }

    @Override
    protected void onPostExecute(ArrayList<Event> listEvents) {

        
        if (myComponent != null) {
            myComponent.onMasterEventsLoaded(listEvents);
        }
    }

}
