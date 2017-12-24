package com.infobrain.meroticket.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.infobrain.meroticket.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class ToLocationActivity extends AppCompatActivity {
    SharedPreferences preferences;
    ListView listView;
    MaterialSearchView searchView;
    public static final String[] location_names = new String[]{
            "Kathmandu", "Pokhara", "Lamjung", "Biratanagar", "Gorkha", "Baglung", "Mustang", "Jhapa", "Nepalgunj", "Bhaktapur", "Panauti", "Dolkha","Birjunj"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Destination");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        preferences = getSharedPreferences("TONAME", 0);
        listView = (ListView) findViewById(R.id.location_list);


        final ArrayAdapter to_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, location_names);
        listView.setAdapter(to_adapter);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                to_adapter.getFilter().filter(newText);

                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                String text = textView.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("to_name", text);
                editor.commit();
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }
}
