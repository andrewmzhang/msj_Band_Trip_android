package oldfiles.services;


import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import oldfiles.callbacks.MasterEventsLoadedListener;
import oldfiles.pojo.Event;
import oldfiles.task.TaskLoadMasterEvents;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class UpdateEventsMasterService extends GcmTaskService implements MasterEventsLoadedListener {

    public void onMasterEventsLoaded(ArrayList<Event> listMovies) {
        Log.d("MyService", "Listener Triggered");



        return;
    }

    public UpdateEventsMasterService() {
    }


    @Override
    public int onRunTask(TaskParams taskParams) {
        Log.d("MyService", "Task run");
        Handler h = new Handler(getMainLooper());
        h.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(UpdateEventsMasterService.this, "Updating Events", Toast.LENGTH_SHORT).show();
                Log.d("MyService", "Service updated");
            }
        });
        ArrayList<Event> e;
        try {
            e = new TaskLoadMasterEvents(this).execute().get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
            return GcmNetworkManager.RESULT_RESCHEDULE;
        } catch (ExecutionException e1) {
            e1.printStackTrace();
            return GcmNetworkManager.RESULT_RESCHEDULE;
        }
        if (e == null) {
            Log.d("UpdateEventService", "E is null");
            h.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(UpdateEventsMasterService.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                    Log.d("MyService", "Service updated");
                }
            });
            return  GcmNetworkManager.RESULT_RESCHEDULE;
        }


        return GcmNetworkManager.RESULT_SUCCESS;
    }



}