package com.infobrain.meroticket.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.infobrain.meroticket.Networks.CheckConnection;
import com.infobrain.meroticket.R;
import com.infobrain.meroticket.SqliteDB.DBHelper;
import com.infobrain.meroticket.SqliteDB.SQLiteOperations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SplashSceen extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 3500;
    String URL;
    DBHelper dbObject;
    View view;
    SQLiteOperations sqlte;
//    Integer id;

    private static final String DATABASE_NAME = "locationData.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);
//        String sample = {"Table1":[{"Username":"dipen","Password":"b","C_Code":"1001"}],"Table":[{"P_Name":"Dipendra Kumar","Mobile_No":"9851132290","Address":"asd","Email":"","Bus_Id":"7","Seat_No":"B08,B09","For_Date":"2017-12-28","Boarding_Point":"Sundhara 6:30","Route_Id":"35","Remarks":"Cash","Payment_Mode":"Cash","Total_Amt":"1800"}]};



//        Toast.makeText(this, booking_URL, Toast.LENGTH_SHORT).show();
////        String booking_URL =  " { \" Table1 \" + \" :[{ \" + \" Username \" + \":\" + \\\" dipen \\\", \\\" Password \\\"+ \" : \" + \"b\", \\\" C_Code \\\"+ \" : \" +\"1001\"+\"}],\"+ \\\" Table \\\"+ \":[{\" + \\\"P_Name\\\" + \":\" + \\\"Dipendra Kumar\\\"+ \",\" + \\\"Mobile_No\\\" + \":\" +\"9851132290\"+\",\"+\\\"Address\\\"+\":\"+\"asd\"+\",\"+\\\"Email\\\"+\":\"+\" \"+\",\"+\\\"Bus_Id\\\"+\":\"+\"7\"+\",\"+\\\"Seat_No\\\"+\":\"+\"B08,B09\"+\",\"+\\\"For_Date\\\"+\":\"+\"2017-12-28\"+\",\"+\\\"Boarding_Point\\\"+\":\"+\"Sundhara 6:30\"+\",\"+\\\"Route_Id\\\"+\":\"+\"35\"+\",\"+\\\"Remarks\\\"+\":\"+\\\"Cash\\\"+\",\"+\\\"Payment_Mode\\\"+\":\"+\\\"Cash\\\"+\",\"+\\\"Total_Amt\\\"+\":\"+\"1800\"+\\\"}]}\\\" ";
//        Log.e("booking URL", booking_URL);

        final Singleton c_code = (Singleton) getApplicationContext();
        //Set name and email in global/application context
        c_code.setC_code("1001");
        String com_code = c_code.getC_code();


        dbObject = new DBHelper(this);
        URL = "https://laxmicapital.com.np/abc/services/webservice.asmx/Get_City_List?C_Code=" + com_code;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                checkInternetCon();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    public void checkInternetCon() {
        if (!CheckConnection.checkInternetConnection(this)) {
            AlertMessage();
            //Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
        } else {
            SaveCityList();
            Intent mainIntent = new Intent(SplashSceen.this, MainActivity.class);
            SplashSceen.this.startActivity(mainIntent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            SplashSceen.this.finish();

        }
    }

    public void AlertMessage() {
        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("No Internet Connection");
        builder.setCancelable(false)
                .setPositiveButton(R.string.TryAgain, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        checkInternetCon();


                    }
                })
                .setNegativeButton(R.string.Exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            // notification is pulled up
        } else {
            checkInternetCon();
        }
        super.onWindowFocusChanged(hasFocus);
    }


    private void SaveCityList() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray check_response = jsonObject.getJSONArray("Table1");
                    JSONObject check = check_response.getJSONObject(0);
                    Integer checkresponse = check.getInt("Response_Code");
                    DBHelper hlpr = new DBHelper(SplashSceen.this);
                    SQLiteDatabase db = hlpr.getWritableDatabase();
                    SQLiteOperations sqlte = new SQLiteOperations(hlpr, db);

                    
                    if (checkresponse == 100) {

                        JSONArray array = jsonObject.getJSONArray("Table");
                        Log.e("Array Length",String.valueOf(array.length()));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject contain = array.getJSONObject(i);
                            String location_name = contain.getString("City_Name");
                            Log.e("DATA ADDED", location_name);
                            sqlte.addLocation(location_name);

                        }

                    }
                } catch (JSONException e) {
                    Log.e("ERROR:", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("NETWORK PROBLEM", error.getMessage());

            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

    }


}



