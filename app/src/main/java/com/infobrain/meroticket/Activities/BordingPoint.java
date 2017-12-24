package com.infobrain.meroticket.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.infobrain.meroticket.Adapters.BordingPointAdapter;
import com.infobrain.meroticket.DataModels.BordingPointModel;
import com.infobrain.meroticket.DataModels.BusLayout_DataModel;
import com.infobrain.meroticket.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BordingPoint extends AppCompatActivity{
    Button next;
    private List<BordingPointModel> point_data;
    ListView boarding_point_list_View;
    private List<BordingPointModel> bordingPointModels = new ArrayList<>();
    private BordingPointAdapter bordingPointAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bording_point);
        boarding_point_list_View=(ListView)findViewById(R.id.boarding_point_list);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BordingPoint.this,BookingDetails.class);
                startActivity(intent);
            }
        });
        bordingPointAdapter = new BordingPointAdapter(bordingPointModels, getApplicationContext());
    }
    public void load_BoardingPoint(String url) {
        String URL_VALUE;
        URL_VALUE = url;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_VALUE, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("bus_boarding");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject contain = array.getJSONObject(i);
                      BordingPointModel bordingPointModel= new BordingPointModel(
                                contain.getString("boarding_point")
                        );
                       bordingPointModels.add(bordingPointModel);
                        //Toast.makeText(MainActivity.this, String.valueOf(model.add(data_data)), Toast.LENGTH_SHORT).show();
                    }
                    if (bordingPointModels != null) {
                        progressDialog.dismiss();

                    }

                } catch (JSONException e) {
                    Log.e("ERROR:", e.getMessage());
                    progressDialog.dismiss();
                }
                bordingPointAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(BusActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(90000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

    }
}
