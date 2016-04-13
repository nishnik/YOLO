package kgp.tech.interiit.sos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.ParseUser;

import java.util.Calendar;

import kgp.tech.interiit.sos.Utils.MyReceiver;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
//
//        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Calendar timeOff9 = Calendar.getInstance();
            Intent intent = new Intent(this,MyReceiver.class);
            PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT);
            am.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis() + 30000, sender);

            startActivity(new Intent(this, MapsActivity.class));
            finish();
//        } else {
//            // Start and intent for the logged out activity
//            startActivity(new Intent(this, Login.class));
//            finish();
//        }
    }
}
