package com.infobrain.meroticket.Activities;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
                SaveCityList();
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashSceen.this, MainActivity.class);
                SplashSceen.this.startActivity(mainIntent);
                SplashSceen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
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



