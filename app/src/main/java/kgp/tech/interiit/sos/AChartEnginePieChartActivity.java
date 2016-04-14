package kgp.tech.interiit.sos;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.json.JSONObject;


/**
 * Created by Avijit Ghosh on 24-02-2015.
 */
//
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.text.SpannableString;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.maps.model.LatLng;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
////import android.app.ListActivity;
//
///**
// * MessageActivity is a main Activity to show a ListView containing Message items
// *
// * @author Adil Soomro
// *
// */
//public class MessageActivity extends AppCompatActivity {
//    /** Called when the activity is first created. */
//
//    ArrayList<Message> messages;
//    AwesomeAdapter adapter;
//    EditText text;
//    static Random rand = new Random();
//    static String sender;
//    private Toolbar toolbar;
//    private ListView listView;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_message);
//
//
//        toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
//        SpannableString s = new SpannableString("");
//        if(toolbar != null)
//        {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle(s);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            //sender = Utility.sender[rand.nextInt( Utility.sender.length-1)];
//
//        }
//
//        Intent iin= getIntent();
//        Bundle b = iin.getExtras();
//
//        if(b!=null && toolbar!=null)
//        {
//            String j =(String) b.get("name");
//            SpannableString s1 = new SpannableString(j);
//            TextView title= (TextView)findViewById(R.id.toolbar_title);
//            title.setText(j);
//            toolbar.findViewById(R.id.toolbar_title).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MessageActivity.this);
//// ...Irrelevant code for customizing the buttons and title
//                    LayoutInflater inflater = MessageActivity.this.getLayoutInflater();
//                    View dialogView = inflater.inflate(R.layout.contact_card, null);
//                    dialogBuilder.setView(dialogView);
//
//
//                    AlertDialog alertDialog = dialogBuilder.create();
//                    alertDialog.show();
//                    // Toast.makeText(getApplicationContext(), "CONTACTS CARD TO BE SHOWN. WORK IN PROGRESS.",
//                    //         Toast.LENGTH_LONG).show();
//                }
//            });
//            //getSupportActionBar().setTitle(s1);
//            sender=j;
//        }
//
//        listView = (ListView) findViewById(R.id.list);
//        text = (EditText) this.findViewById(R.id.text);
//
//        /*sender = Utility.sender[rand.nextInt( Utility.sender.length-1)];
//        this.setTitle(sender);*/
//        messages = new ArrayList<Message>();
//
//        messages.add(new Message("Hello", false));
//        messages.add(new Message("Hi!", true));
//        messages.add(new Message("Wassup??", false));
//        messages.add(new Message("nothing much, working on speech bubbles.", true));
//        messages.add(new Message("you say!", true));
//        messages.add(new Message("oh thats great. how are you showing them", false));
//
//
//        adapter = new AwesomeAdapter(this, messages);
//        listView.setAdapter(adapter);
//        addNewMessage(new Message("mmm, well, using 9 patches png to show them.", true));
//    }
//    public void sendMessage(View v)
//    {
//        String newMessage = text.getText().toString().trim();
//        if(newMessage.length() > 0)
//        {
//            text.setText("");
//            addNewMessage(new Message(newMessage, true));
//            new SendMessage().execute();
//        }
//    }
//    private class SendMessage extends AsyncTask<Void, String, String>
//    {
//        String sender="Somebody";
//        @Override
//        protected String doInBackground(Void... params) {
//            try {
//                Thread.sleep(2000); //simulate a network call
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            this.publishProgress(String.format("%s started writing", sender));
//            try {
//                Thread.sleep(2000); //simulate a network call
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.publishProgress(String.format("%s has entered text", sender));
//            try {
//                Thread.sleep(3000);//simulate a network call
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            return Random_Message.messages[rand.nextInt(Random_Message.messages.length-1)];
//
//
//        }
//        @Override
//        public void onProgressUpdate(String... v) {
//
//            if(messages.get(messages.size()-1).isStatusMessage)//check wether we have already added a status message
//            {
//                messages.get(messages.size()-1).setMessage(v[0]); //update the status for that
//                adapter.notifyDataSetChanged();
//                listView.setSelection(messages.size()-1);
//            }
//            else{
//                addNewMessage(new Message(true,v[0])); //add new message, if there is no existing status message
//            }
//        }
//        @Override
//        protected void onPostExecute(String text) {
//            if(messages.get(messages.size()-1).isStatusMessage)//check if there is any status message, now remove it.
//            {
//                messages.remove(messages.size()-1);
//            }
//
//            addNewMessage(new Message(text, false)); // add the orignal message from server.
//        }
//
//
//    }
//    void addNewMessage(Message m)
//    {
//        messages.add(m);
//        adapter.notifyDataSetChanged();
//        listView.setSelection(messages.size()-1);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        // Handle presses on the action bar items
////        switch (item.getItemId()) {
////
////            case R.id.action_attach:
////                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
////                intent.setType("*/*");
////                startActivityForResult(intent,1);
////
////                return true;
////            default:
////                return super.onOptionsItemSelected(item);
////        }
////    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // TODO Auto-generated method stub
//        switch(requestCode){
//            case 1:
//                if(resultCode==RESULT_OK){
//                    String FilePath = data.getData().getPath();
//                    //textFile.setText(FilePath);
//                    Toast.makeText(getApplicationContext(), FilePath,
//                            Toast.LENGTH_LONG).show();
//                }
//                break;
//
//        }
//    }
//
//}

public class AChartEnginePieChartActivity extends Activity {

    private static int[] COLORS = new int[] { Color.argb(200, 244, 158, 49), Color.argb(200, 206, 80, 45),Color.argb(200, 52, 110, 201),Color.argb(200, 69, 141, 27), Color.argb(200, 185, 122, 87) };

    JSONObject in_json = Chatlist.out_json;

    private static double[] VALUES = new double[5];// { 10, 11, 12, 13, 23 };

    private static String[] NAME_LIST = new String[] { "Social", "Leisure", "Others", "Work", "Health" };

    private static String[] VALUES_SHOW = new String[5];

    private CategorySeries mSeries = new CategorySeries("");

    private DefaultRenderer mRenderer = new DefaultRenderer();

    private GraphicalView mChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        for(int i=0; i<5; i++)
        {
            if (NAME_LIST[i].equals("Social")){
                try {
                    VALUES[i] = in_json.getLong("social_time");
                    long time_in = (long)VALUES[i];
                    long hour = time_in/60;
                    long minute = time_in%60;
                    String f1 = String.format("%02d", hour);
                    String f2 = String.format("%02d", minute);
                    VALUES_SHOW[i] = f1+":"+f2;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else if (NAME_LIST[i].equals("Work")){
                try {
                    VALUES[i] = in_json.getLong("work_time");
                    long time_in = (long)VALUES[i];
                    long hour = time_in/60;
                    long minute = time_in%60;
                    String f1 = String.format("%02d", hour);
                    String f2 = String.format("%02d", minute);
                    VALUES_SHOW[i] = f1+":"+f2;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else if (NAME_LIST[i].equals("Others")){
                try {
                    VALUES[i] = in_json.getLong("others_time");
                    long time_in = (long)VALUES[i];
                    long hour = time_in/60;
                    long minute = time_in%60;
                    String f1 = String.format("%02d", hour);
                    String f2 = String.format("%02d", minute);
                    VALUES_SHOW[i] = f1+":"+f2;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else if (NAME_LIST[i].equals("Leisure")){
                try {
                    VALUES[i] = in_json.getLong("leisure_time");
                    long time_in = (long)VALUES[i];
                    long hour = time_in/60;
                    long minute = time_in%60;
                    String f1 = String.format("%02d", hour);
                    String f2 = String.format("%02d", minute);
                    VALUES_SHOW[i] = f1+":"+f2;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else if (NAME_LIST[i].equals("Health")){
                try {
                    VALUES[i] = in_json.getLong("health_time");
                    long time_in = (long)VALUES[i];
                    long hour = time_in/60;
                    long minute = time_in%60;
                    String f1 = String.format("%02d", hour);
                    String f2 = String.format("%02d", minute);
                    VALUES_SHOW[i] = f1+":"+f2;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.argb(200, 200, 200, 200));
        mRenderer.setChartTitleTextSize(20);
        mRenderer.setLabelsTextSize(25);
        mRenderer.setLegendTextSize(30);
        mRenderer.setMargins(new int[]{20, 30, 15, 0});
        mRenderer.setChartTitle("Time Chart");
        mRenderer.setChartTitleTextSize(50);
        mRenderer.setLabelsColor(Color.argb(200, 0 ,0, 0));
        //mRenderer.setZoomButtonsVisible(true);
        mRenderer.setStartAngle(90);

        for (int i = 0; i < VALUES.length; i++) {
            mSeries.add(NAME_LIST[i] + " " + VALUES_SHOW[i] + "     \t", VALUES[i]);
            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
            renderer.setColor(COLORS[(mSeries.getItemCount() - 1) % COLORS.length]);
            mRenderer.addSeriesRenderer(renderer);
        }

        if (mChartView != null) {
            mChartView.repaint();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mChartView == null) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.chart);
            mChartView = ChartFactory.getPieChartView(this, mSeries, mRenderer);
            mRenderer.setClickEnabled(true);
            mRenderer.setSelectableBuffer(10);

            mChartView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();

                    if (seriesSelection == null) {
                        //Toast.makeText(AChartEnginePieChartActivity.this, "No chart element was clicked", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AChartEnginePieChartActivity.this,"Chart element data point index "+ (seriesSelection.getPointIndex()+1) + " was clicked" + " point value="+ seriesSelection.getValue(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            mChartView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();
                    if (seriesSelection == null) {
                        //Toast.makeText(AChartEnginePieChartActivity.this,"No chart element was long pressed", Toast.LENGTH_SHORT);
                        return false;
                    }
                    else {
                        Toast.makeText(AChartEnginePieChartActivity.this,"Chart element data point index "+ seriesSelection.getPointIndex()+ " was long pressed",Toast.LENGTH_SHORT);
                        return true;
                    }
                }
            });
            layout.addView(mChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        }
        else {
            mChartView.repaint();
        }
    }
}