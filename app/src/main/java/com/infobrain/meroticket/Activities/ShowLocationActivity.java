package com.infobrain.meroticket.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.infobrain.meroticket.Adapters.LocationAdapter;
import com.infobrain.meroticket.DataModels.Location_DataModel;
import com.infobrain.meroticket.Fragments.frag_bus_search;
import com.infobrain.meroticket.R;

import java.util.ArrayList;
import java.util.List;

public class ShowLocationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String lo_name;
    public static final String[] location_names = new String[]{
            "Kathmandu", "Pokhara", "Lamjung", "Biratanagar", "Gorkha", "Baglung", "Mustang", "Jhapa", "Nepalgunj", "Bhaktapur", "Panauti", "Dolkha"
    };
    ListView listView;
    List<Location_DataModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_result);
        dataModels = new ArrayList<Location_DataModel>();
        for (int i = 0; i < location_names.length; i++) {
            Location_DataModel model = new Location_DataModel(location_names[i]);
            dataModels.add(model);
        }
        listView = (ListView) findViewById(R.id.location_list);
        LocationAdapter adapter = new LocationAdapter(this, dataModels);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Location_DataModel instantObject = (Location_DataModel) adapterView.getItemAtPosition(position);
        Toast toast = Toast.makeText(this, instantObject.getLocation_name(), Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        // lo_name=instantObject.getLocation_name();
        //sendData(lo_name);
        //intent.putExtra("location_name",instantObject.getLocation_name());
        /*Bundle bundle= new Bundle();
        bundle.putString("VALUE",instantObject.getLocation_name());
        frag_bus_search bus_search= new frag_bus_search();
        bus_search.setArguments(bundle);
        getActivity().finish();*/
        //String location_chooose=instantObject.getLocation_name();
        //lo_name=location_chooose;

        startActivity(intent);
    }

    /* public String getMydata(){
         return lo_name;
     }
 */
    public void sendData(String place_value) {
        Bundle bundle = new Bundle();
        bundle.putString("PLACE", place_value);

        frag_bus_search bus_search = new frag_bus_search();
        bus_search.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, bus_search).commit();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
