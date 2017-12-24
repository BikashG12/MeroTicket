package com.infobrain.meroticket.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infobrain.meroticket.Adapters.SeatSelectionAdapter;
import com.infobrain.meroticket.R;

import java.util.ArrayList;

/**
 * Created by rp on 11/20/17.
 */

public class ChooseBusSeat extends AppCompatActivity implements GridView.OnItemClickListener {

    //LinearLayout seat_snackbar;
    ArrayList<String> list = new ArrayList<String>();

    TextView snack;
    /*CardView card_snack;*/
    RelativeLayout card_snack;
    String bus_name;

    TextView proceed;

    GridView gridView;

    LinearLayout Layout_Of_Grid_View;

    float SeatPrice = 600;
    float total_price;

   // Integer counter = 0;

    TextView seat_all, price;

    Boolean status = false;

    Boolean seat_A1_flag = false;
    Boolean seat_A2_flag = false;
    Boolean seat_A3_flag = false;
    Boolean seat_A4_flag = false;
    Boolean seat_A5_flag = false;
    Boolean seat_A6_flag = false;
    Boolean seat_A7_flag = false;
    Boolean seat_A8_flag = false;
    Boolean seat_A9_flag = false;
    Boolean seat_A10_flag = false;
    Boolean seat_A11_flag = false;
    Boolean seat_A12_flag = false;

    Boolean seat_B1_flag = false;
    Boolean seat_B2_flag = false;
    Boolean seat_B3_flag = false;
    Boolean seat_B4_flag = false;
    Boolean seat_B5_flag = false;
    Boolean seat_B6_flag = false;
    Boolean seat_B7_flag = false;
    Boolean seat_B8_flag = false;
    Boolean seat_B9_flag = false;
    Boolean seat_B10_flag = false;
    Boolean seat_B11_flag = false;
    Boolean seat_B12_flag = false;

    Boolean seat_L1_flag = false;
    Boolean seat_L2_flag = false;
    Boolean seat_L3_flag = false;
    Boolean seat_L4_flag = false;
    Boolean seat_L5_flag = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_busseat);
        bus_name=getIntent().getStringExtra("bus_name");
        this.setTitle(bus_name);
        gridView = findViewById(R.id.choose_seats);

        Layout_Of_Grid_View = findViewById(R.id.grid_view);

        card_snack = findViewById(R.id.dummy_snack_bar);

        proceed = (findViewById(R.id.proceed));

        price = findViewById(R.id.price);

        seat_all = findViewById(R.id.txt1);

        SeatSelectionAdapter seatSelectionAdapter = new SeatSelectionAdapter(this);
        gridView.setAdapter(seatSelectionAdapter);
        gridView.setOnItemClickListener(this);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BordingPoint.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_image) {
            DialogImage();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 15:
                String seat_A1 = "A1";
                if (seat_A1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A1);
                    priceAdd(SeatPrice);
                    seat_A1_flag = true;
                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_A1);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A1_flag = false;
                    // counter--;
                    //counter(counter);
                }
                break;
            case 16:
                String seat_A2 = "A2";
                if (seat_A2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A2);
                    priceAdd(SeatPrice);
                    seat_A2_flag = true;
                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A2);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A2_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 18:
                String seat_B1 = "B1";
                if (seat_B1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B1);
                    priceAdd(SeatPrice);
                    seat_B1_flag = true;

                    // counter++;
                    //counter(counter);
                } else {
                    removeData(seat_B1);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B1_flag = false;
                    // counter--;
                    // counter(counter);
                }
                break;

            case 19:
                String seat_B2 = "B2";
                if (seat_B2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B2);
                    priceAdd(SeatPrice);
                    seat_B2_flag = true;

                    // counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B2);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B2_flag = false;

                    // counter--;
                    // counter(counter);
                }
                break;

            case 20:
                String seat_A3 = "A3";
                if (seat_A3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A3);
                    priceAdd(SeatPrice);
                    seat_A3_flag = true;

                    // counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A3);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A3_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 21:
                String seat_A4 = "A4";
                if (seat_A4_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A4);
                    priceAdd(SeatPrice);
                    seat_A4_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_A4);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A4_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 23:
                String seat_B3 = "B3";
                if (seat_B3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B3);
                    priceAdd(SeatPrice);
                    seat_B3_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_B3);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B3_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;
            case 24:
                String seat_B4 = "B4";
                if (seat_B4_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B4);
                    priceAdd(SeatPrice);
                    seat_B4_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B4);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B4_flag = false;

                    // counter--;
                    // counter(counter);
                }
                break;
            case 25:
                String seat_A5 = "A5";
                if (seat_A5_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A5);
                    priceAdd(SeatPrice);
                    seat_A5_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A5);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A5_flag = false;

                    // counter--;
                    // counter(counter);
                }
                break;
            case 26:
                String seat_A6 = "A6";
                if (seat_A6_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A6);
                    priceAdd(SeatPrice);
                    seat_A6_flag = true;

                    // counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A6);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A6_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;
            case 28:
                String seat_B5 = "B5";
                if (seat_B5_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B5);
                    priceAdd(SeatPrice);
                    seat_B5_flag = true;

                    // counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B5);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B5_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 29:
                String seat_B6 = "B6";
                if (seat_B6_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B6);
                    priceAdd(SeatPrice);
                    seat_B6_flag = true;

                    // counter++;
                    //counter(counter);
                } else {
                    removeData(seat_B6);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B6_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 30:
                String seat_A7 = "A7";
                if (seat_A7_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A7);
                    priceAdd(SeatPrice);
                    seat_A7_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A7);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A7_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;

            case 31:
                String seat_A8 = "A8";
                if (seat_A8_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A8);
                    priceAdd(SeatPrice);
                    seat_A8_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_A8);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A8_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;

            case 33:
                String seat_B7 = "B7";
                if (seat_B7_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B7);
                    priceAdd(SeatPrice);
                    seat_B7_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B7);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B7_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 34:
                String seat_B8 = "B8";
                if (seat_B8_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B8);
                    priceAdd(SeatPrice);
                    seat_B8_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B8);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B8_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 35:
                String seat_A9 = "A9";
                if (seat_A9_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A9);
                    priceAdd(SeatPrice);
                    seat_A9_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_A9);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A9_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;
            case 36:
                String seat_A10 = "A10";
                if (seat_A10_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A10);
                    priceAdd(SeatPrice);
                    seat_A10_flag = true;

                    // counter++;
                    // counter(counter);
                } else {
                    removeData(seat_A10);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A10_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;
            case 38:
                String seat_B9 = "B9";
                if (seat_B9_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B9);
                    priceAdd(SeatPrice);
                    seat_B9_flag = true;

                    // counter++;
                    //counter(counter);
                } else {
                    removeData(seat_B9);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B9_flag = false;

                    //counter--;
                    // counter(counter);
                }
                break;
            case 39:
                String seat_B10 = "B10";
                if (seat_B10_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B10);
                    priceAdd(SeatPrice);
                    seat_B10_flag = true;

                    //counter++;
                    // counter(counter);

                } else {
                    removeData(seat_B10);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B10_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 40:
                String seat_A11 = "A11";
                if (seat_A11_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A11);
                    priceAdd(SeatPrice);
                    seat_A11_flag = true;

                    //counter++;
                    // counter(counter);

                } else {
                    removeData(seat_A11);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A11_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 41:
                String seat_A12 = "A12";
                if (seat_A12_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_A12);
                    priceAdd(SeatPrice);
                    seat_A12_flag = true;

                    // counter++;
                    //counter(counter);

                } else {
                    removeData(seat_A12);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_A12_flag = false;

                    // counter--;
                    // counter(counter);
                }
                break;
            case 43:
                String seat_B11 = "B11";
                if (seat_B11_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B11);
                    priceAdd(SeatPrice);
                    seat_B11_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_B11);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B11_flag = false;

                    //counter--;
                    // counter(counter);

                }
                break;
            case 44:
                String seat_B12 = "B12";
                if (seat_B12_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_B12);
                    priceAdd(SeatPrice);
                    seat_B12_flag = true;

                    //counter++;
                    // counter(counter);
                } else {
                    removeData(seat_B12);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_B12_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 45:
                String seat_L1 = "L1";
                if (seat_L1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_L1);
                    priceAdd(SeatPrice);
                    seat_L1_flag = true;

                    //counter++;
                    // counter(counter);

                } else {
                    removeData(seat_L1);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_L1_flag = false;

                    //counter--;
                    //counter(counter);
                }
                break;
            case 46:
                String seat_L2 = "L2";
                if (seat_L2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_L2);
                    priceAdd(SeatPrice);
                    seat_L2_flag = true;

                    //counter++;
                    // counter(counter);

                } else {
                    removeData(seat_L2);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_L2_flag = false;

                    // counter--;
                    //counter(counter);

                }
                break;
            case 47:
                String seat_L3 = "L3";
                if (seat_L3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_L3);
                    priceAdd(SeatPrice);
                    seat_L3_flag = true;

                    //counter++;
                    //counter(counter);

                } else {
                    removeData(seat_L3);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_L3_flag = false;

                    //counter--;
                    //counter(counter);

                }
                break;

            case 48:
                String seat_L4 = "L4";
                if (seat_L4_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_L4);
                    priceAdd(SeatPrice);
                    seat_L4_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_L4);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_L4_flag = false;

                    // counter--;
                    //counter(counter);
                }
                break;
            case 49:
                String seat_L5 = "L5";
                if (seat_L5_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.icon_bus_seat_booked);
                    addData(seat_L5);
                    priceAdd(SeatPrice);
                    seat_L5_flag = true;

                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_L5);
                    view.setBackgroundResource(R.drawable.icon_bus_seat_normal);
                    priceSub(SeatPrice);
                    seat_L5_flag = false;

                    //counter--;
                    // counter(counter);
                }
                break;
        }
    }

    public void priceAdd(float seat_price) {
        total_price = total_price + seat_price;
        price.setText(String.valueOf(total_price));
        //Toast.makeText(this,String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }

    /*public void counter(Integer counter) {

        final Drawable drawable_selected = getResources().getDrawable(R.drawable.icon_bus_seat_booked);
        final Drawable drawable_normal = getResources().getDrawable(R.drawable.icon_bus_seat_normal);

        if (counter >= 8)
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(view.getBackground().equals(drawable_normal)){

                        Toast.makeText(ChooseBusSeat.this, "Bahira", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(ChooseBusSeat.this, "Bhitra", Toast.LENGTH_SHORT).show();

                        gridView.setOnItemClickListener(this);
                    }
                }
            });

    }*/
    //        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if (ChooseBusSeat.this.counter < 8 ) {
//                    gridView.setOnItemClickListener(this);
//
//                } else if (view.getBackground().equals(drawable_selected)) {
//                    gridView.setOnItemClickListener(this);
//                }
//            }
//        });


    public void priceSub(float seat_price) {
        total_price = total_price - seat_price;
        price.setText(String.valueOf(total_price));

        //Toast.makeText(this,String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }

    public void addData(String value) {

        list.add(value);
        seat_all.setText(list.toString().replaceAll("\\[|\\]", ""));
        if (String.valueOf(list.size()).equals(0)) {
            card_snack.setVisibility(View.GONE);
        } else {
            card_snack.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_menu, menu);
        MenuItem item=menu.findItem(R.id.action_image);
        item.getItemId();
        return true;
    }

    public void removeData(String value) {

        list.remove(value);
        seat_all.setText(list.toString().replaceAll("\\[|\\]", ""));
        if ((list.isEmpty())) {
            card_snack.setVisibility(View.GONE);
        } else {
            card_snack.setVisibility(View.VISIBLE);
        }
    }
    public void DialogImage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.show_image_viewer, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        dialog.show();
    }


}
