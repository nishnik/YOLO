package kgp.tech.interiit.sos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseUser;

import java.io.FileOutputStream;
import java.util.Calendar;

import kgp.tech.interiit.sos.Utils.MyReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by vamsikrishna on 12-Feb-15.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Calendar timeOff9 = Calendar.getInstance();
        Intent intent = new Intent(this,MyReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis() + 30000, sender);
        String str_to_write = "";
        //TODO: check if file exist dont write

        // an ideal life
        str_to_write += "home_bookmark-600\n";
        str_to_write += "work_bookmark-480\n";
        str_to_write += "place_of_worship-30\n";
        str_to_write += "cemetery-30\n";
        str_to_write += "park-120\n";
        str_to_write += "bus_station-30\n";
        str_to_write += "grocery_or_supermarket-90\n";
        str_to_write += "gym-60\n";


//        // hectic work
//        str_to_write += "home_bookmark-600\n";  // 10 hours
//        str_to_write += "work_bookmark-720\n"; //12 hours
//        str_to_write += "place_of_worship-30\n";
//        str_to_write += "cemetery-30\n";
//        str_to_write += "park-120\n";


            /*Test Data is being written here*/
        try { // update the entry of previous location
            Log.e("YOLO : Writing content:", str_to_write);
            FileOutputStream outputStream = openFileOutput("log_loc.txt", Context.MODE_PRIVATE);
            outputStream.write(str_to_write.getBytes());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(WelcomeActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}

//
//
//
//public class WelcomeActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////
////        if (ParseUser.getCurrentUser() != null) {
//            // Start an intent for the logged in activity
//
////        } else {
////            // Start and intent for the logged out activity
////            startActivity(new Intent(this, Login.class));
////            finish();
////        }
//    }
//}
