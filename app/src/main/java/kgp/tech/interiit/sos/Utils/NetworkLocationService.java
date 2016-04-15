package kgp.tech.interiit.sos.Utils;

/**
 * Created by nishantiam on 12-04-2016.
 */

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import kgp.tech.interiit.sos.AChartEnginePieChartActivity;
import kgp.tech.interiit.sos.R;

import static java.lang.Math.abs;


/**
 * Created by nishantiam on 22-01-2016.
 */
public class NetworkLocationService extends Service implements LocationListener {
    String TAG = "YOLO";
    protected LocationManager locationManager;
    String types_of_places[] = {"accounting","airport","amusement_park","aquarium","art_gallery","atm","bakery","bank","bar","beauty_salon","bicycle_store",
    "book_store","bowling_alley","bus_station","cafe","campground","car_dealer","car_rental","car_repair","car_wash","casino",
    "cemetery","church","city_hall","clothing_store","convenience_store","courthouse","dentist","department_store","doctor",
    "electrician","electronics_store","embassy","establishment","finance","fire_station","florist","food","funeral_home",
    "furniture_store","gas_station","general_contractor","grocery_or_supermarket","gym","hair_care","hardware_store",
    "health","hindu_temple","home_goods_store","hospital","insurance_agency","jewelry_store","laundry","lawyer","library",
    "liquor_store","local_government_office","locksmith","lodging","meal_delivery","meal_takeaway","mosque","movie_rental",
    "movie_theater","moving_company","museum","night_club","painter","park","parking","pet_store","pharmacy","physiotherapist",
    "place_of_worship","plumber","police","post_office","real_estate_agency","restaurant","roofing_contractor","rv_park",
    "school","shoe_store","shopping_mall","spa","stadium","storage","store","subway_station","synagogue","taxi_stand","train_station",
    "transit_station","travel_agency","university","veterinary_care","zoo"};
    Set<String> places_set = new HashSet<String>(Arrays.asList(types_of_places));

    Location location;
    private static final long MIN_DISTANCE_FOR_UPDATE = 0;
    private static final long MIN_TIME_FOR_UPDATE = 0;//1000 * 60 * 1;
    private static boolean first_write = true;

    public NetworkLocationService(Context context) {

        locationManager = (LocationManager) context
                .getSystemService(LOCATION_SERVICE);
    }

    //the default constructor is basically for startService method
    public NetworkLocationService() {
        super();
    }

    public Location getLocation() {
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!(checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        return location;
                    }
                    return null;
                } else {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        return location;
                    }
                    return null;
                }
            }
            else
            {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    return location;
                }
                return null;
            }
        }
        return null;
    }

    public long getTimeHash(String date_s) {
        long hash = 0;
        int date = Integer.parseInt(date_s.substring(0, 2));
        int hour = Integer.parseInt(date_s.substring(3, 5));
        int min = Integer.parseInt(date_s.substring(6, 8));
        return min + hour * 60 + date * 1440;
    }

    static String getJSON(String url, int timeout) {
        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    //Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
    static boolean isFirst_write = true;
    public void write_with_place(final LatLng loc_old, final long diff_time) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String key = "AIzaSyCTDMaJIhXDmGiz7dlJcmghD2LoVgKkTpI";
                    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + Double.toString(loc_old.latitude) + "," + Double.toString(loc_old.longitude) + "&radius=100&key=" + key;
                    String data = getJSON(url, 3000);
                    String mResponse = "";
                    String out_place = "other";
                    String ret = "";
                    JSONObject in_file_json = new JSONObject();
                    //if(!isFirst_write) {
                    // It doesnt handle some exceptions, like if it fails to load, whole data will be erased
                    // as out data doesnt give a damn about in data not being loaded
                    if(true) {
                        try {
                            InputStream inputStream = openFileInput("log_loc.txt");

                            if (inputStream != null) {
                                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                String receiveString = "";
                                StringBuilder stringBuilder = new StringBuilder();

                                while ((receiveString = bufferedReader.readLine()) != null) {
                                    stringBuilder.append(receiveString);
                                    int breakpoint = 0;
                                    for (int i = 0; i < receiveString.length(); i++) {
                                        if (receiveString.charAt(i) == '-') {
                                            breakpoint = i;
                                        }
                                    }
                                    try {
                                        in_file_json.put(receiveString.substring(0, breakpoint), new Long(receiveString.substring(breakpoint + 1, receiveString.length())));
                                    }
                                    catch (Exception e) {
                                    Log.e("JSON EXCEPTION", e.toString());
                                    }
                                }

                                inputStream.close();
                                ret = stringBuilder.toString();
                                Log.e(TAG + "Found content", ret);
                            }
                        } catch (FileNotFoundException e) {
                            Log.e("login activity", "File not found: " + e.toString());
                        } catch (IOException e) {
                            Log.e("login activity", "Can not read file: " + e.toString());
                        }
                    }

                    try {
                        JSONObject jsonRootObject = new JSONObject(data);

                        //Get the instance of JSONArray that contains JSONObjects
                        JSONArray jsonArray = jsonRootObject.getJSONArray("results");

                        boolean flag = true;
                        //Iterate the jsonArray and print the info of JSONObjects
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (!flag)
                                break;
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            JSONArray type_array = jsonObject.getJSONArray("types");
                            for (int j = 0; j < type_array.length(); j++) {
                                Log.e(TAG + "I have found: ", type_array.toString());
                                if (places_set.contains(type_array.getString(j))){
                                    Log.e("This lies there", type_array.getString(j));
                                    out_place = type_array.getString(j);
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (in_file_json.has(out_place)) {
                        in_file_json.put(out_place, in_file_json.getLong(out_place) + diff_time);
                    }
                    else {
                        in_file_json.put(out_place, diff_time);
                    }

                    String str_to_write = "";
                    for (int i=0;i<in_file_json.length();i++)
                    {
                        str_to_write += in_file_json.names().getString(i) + "-" + in_file_json.get(in_file_json.names().getString(i));
                        str_to_write += "\n";
                    }
                    try { // update the entry of previous location
                        Log.e(TAG + "Writing content", str_to_write);
                        FileOutputStream outputStream = openFileOutput("log_loc.txt", Context.MODE_PRIVATE);
                        outputStream.write(str_to_write.getBytes());
                        outputStream.close();
                        isFirst_write = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //return a;
            }});
        thread.run();

    }

    @Override
    public void onLocationChanged(Location location) {
        String filename = "temp_location";
        String log_of_loc = "log_of_loc";
        SimpleDateFormat sdf = new SimpleDateFormat("dd_HH_mm"); //we can further work upon this
        String currentDateandTime = sdf.format(new Date());
        String str_to_write = Double.toString(location.getLatitude()) + "-" + Double.toString(location.getLongitude()) +
                "-" + currentDateandTime.toString();
        FileOutputStream outputStream;
        double prev_lat = -1, prev_long = -1;
        long curr_time = getTimeHash(currentDateandTime.toString());
        long prev_time = -1;
        double dist = -1;
        LatLng old_loc = new LatLng(location.getLatitude(), location.getLongitude());
        try {
            FileInputStream inputStream = openFileInput(filename);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            r.close();
            inputStream.close();
            int first = -1, second = -1;
            for (int i = 0; i < total.length(); i++) {
                if (total.charAt(i) == '-') {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                        break;
                    }

                }
            }
            prev_lat = new Double(total.substring(0, first));
            prev_long = new Double(total.substring(first + 1, second));
            old_loc = new LatLng(prev_lat, prev_long);
            float results[] = new float[10];
            Location.distanceBetween(
                    location.getLatitude(),
                    location.getLongitude(),
                    prev_lat,
                    prev_long,
                    results);
            dist = results[0];
            prev_time = getTimeHash(total.substring(second + 1));
            Log.e(TAG + "File", "File contents: " + total );
        } catch (Exception e) {
            e.printStackTrace();
        }
        final LatLng loc_old = old_loc;

        write_with_place(old_loc, 10); //// Delete after testing
        if (abs(dist) > 200) // in metres
        {
            try { // update the entry of previous location
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(str_to_write.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (curr_time - prev_time > 10) //stayed at same place for more than 10 minutes
            {
                write_with_place(old_loc, curr_time - prev_time);

            }
        } else {
            // do nothing
        }
        if (first_write){
            try { // update the entry of previous location
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(str_to_write.getBytes());
                outputStream.close();
                first_write = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Log.e(TAG + "In AppLocation", str_to_write + " " + Double.toString(dist) + " " + Long.toString(curr_time - prev_time));
    }



    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.e("NetworkLocationService", "OnCreate");
        locationManager = (LocationManager) getApplicationContext()
                .getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!(checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    }

                } else {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    }

                }
            }
            else
            {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                }
            }
        }

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Log.e("Network Loc Service", "Service running");
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);


        Calendar timeOff9 = Calendar.getInstance();

        Intent intent2 = new Intent(this,MyReceiver.class);

        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent2,
                PendingIntent.FLAG_UPDATE_CURRENT);

        am.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis() + 55000, sender);
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Network Loc Service","onDestroy");
    }


    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

}