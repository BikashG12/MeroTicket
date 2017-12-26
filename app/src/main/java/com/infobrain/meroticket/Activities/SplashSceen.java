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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    String URL;
    DBHelper dbObject;

    private static final String DATABASE_NAME = "locationData.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);


        dbObject = new DBHelper(this);
        URL = "https://laxmicapital.com.np/abc/services/webservice.asmx/Get_City_List?C_Code=1001";
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
            SplashSceen.this.finish();

        }
    }

    public void AlertMessage() {
        AlertDialog.Builder builder;
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
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject contain = array.getJSONObject(i);
                            String location_name = contain.getString("City_Name");
                            sqlte.addLocation(location_name);
                        }
                        db.close();
                    }
                } catch (JSONException e) {
                    Log.e("ERROR:", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

    }


}



