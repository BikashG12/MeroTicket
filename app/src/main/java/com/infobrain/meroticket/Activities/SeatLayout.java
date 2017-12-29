package com.infobrain.meroticket.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.infobrain.meroticket.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by frank on 12/26/2017.
 */

public class SeatLayout extends AppCompatActivity implements View.OnClickListener {
    private String layout_id = "2";
    private TextView A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17;
    private TextView B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18;
    private TextView C1, C2, C3;
    private TextView seat_all, price, proceed;
    private String[] seat_id = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "B1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "B10", "B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "C1", "C2", "C3"};
    private String[] booked_Seats_no = {"A1", "B10", "a9", "B17"};
    private ArrayList<String> seat_list = new ArrayList<String>();
    float SeatPrice, total_price;
    private String bus_name, bus_price;
    private RelativeLayout card_snack;


    private Boolean seat_A1_flag = false;
    private Boolean seat_A2_flag = false;
    private Boolean seat_A3_flag = false;
    private Boolean seat_A4_flag = false;
    private Boolean seat_A5_flag = false;
    private Boolean seat_A6_flag = false;
    private Boolean seat_A7_flag = false;
    private Boolean seat_A8_flag = false;
    private Boolean seat_A9_flag = false;
    private Boolean seat_A10_flag = false;
    private Boolean seat_A11_flag = false;
    private Boolean seat_A12_flag = false;
    private Boolean seat_A13_flag = false;
    private Boolean seat_A14_flag = false;
    private Boolean seat_A15_flag = false;
    private Boolean seat_A16_flag = false;
    private Boolean seat_A17_flag = false;


    private Boolean seat_B1_flag = false;
    private Boolean seat_B2_flag = false;
    private Boolean seat_B3_flag = false;
    private Boolean seat_B4_flag = false;
    private Boolean seat_B5_flag = false;
    private Boolean seat_B6_flag = false;
    private Boolean seat_B7_flag = false;
    private Boolean seat_B8_flag = false;
    private Boolean seat_B9_flag = false;
    private Boolean seat_B10_flag = false;
    private Boolean seat_B11_flag = false;
    private Boolean seat_B12_flag = false;
    private Boolean seat_B13_flag = false;
    private Boolean seat_B14_flag = false;
    private Boolean seat_B15_flag = false;
    private Boolean seat_B16_flag = false;
    private Boolean seat_B17_flag = false;
    private Boolean seat_B18_flag = false;


    private Boolean seat_C1_flag = false;
    private Boolean seat_C2_flag = false;
    private Boolean seat_C3_flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus_name = getIntent().getStringExtra("bus_name");
        this.setTitle(bus_name);
        bus_price = getIntent().getStringExtra("seat_price");
        SeatPrice=Float.parseFloat(bus_price);
        inflate_layout(layout_id);
    }

    private void inflate_layout(String code) {
        switch (code) {
            case "1":
                setContentView(R.layout.linear_bus_layout);
                card_snack = findViewById(R.id.bottom_snack_bar);
                proceed = (findViewById(R.id.proceed));
                price = findViewById(R.id.price);
                seat_all = findViewById(R.id.txt1);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), BordingPoint.class);
                        startActivity(intent);

                    }
                });


                //A sides
                A1 = findViewById(R.id.A01);
                A2 = findViewById(R.id.A02);
                A3 = findViewById(R.id.A03);
                A4 = findViewById(R.id.A04);
                A5 = findViewById(R.id.A05);
                A6 = findViewById(R.id.A06);
                A7 = findViewById(R.id.A07);
                A8 = findViewById(R.id.A08);
                A9 = findViewById(R.id.A09);
                A10 = findViewById(R.id.A10);
                A11 = findViewById(R.id.A11);
                A12 = findViewById(R.id.A12);
                A13 = findViewById(R.id.A13);
                A14 = findViewById(R.id.A14);
                A15 = findViewById(R.id.A15);
                A16 = findViewById(R.id.A16);
                A17 = findViewById(R.id.A17);

                //B side seats
                B1 = findViewById(R.id.B01);
                B2 = findViewById(R.id.B02);
                B3 = findViewById(R.id.B03);
                B4 = findViewById(R.id.B04);
                B5 = findViewById(R.id.B05);
                B6 = findViewById(R.id.B06);
                B7 = findViewById(R.id.B07);
                B8 = findViewById(R.id.B08);
                B9 = findViewById(R.id.B09);
                B10 = findViewById(R.id.B10);
                B11 = findViewById(R.id.B11);
                B12 = findViewById(R.id.B12);
                B13 = findViewById(R.id.B13);
                B14 = findViewById(R.id.B14);
                B15 = findViewById(R.id.B15);
                B16 = findViewById(R.id.B16);
                B17 = findViewById(R.id.B17);
                B18 = findViewById(R.id.B18);
                //click listener
                A1.setOnClickListener(this);
                A2.setOnClickListener(this);
                A3.setOnClickListener(this);
                A4.setOnClickListener(this);
                A5.setOnClickListener(this);
                A6.setOnClickListener(this);
                A7.setOnClickListener(this);
                A8.setOnClickListener(this);
                A9.setOnClickListener(this);
                A10.setOnClickListener(this);
                A11.setOnClickListener(this);
                A12.setOnClickListener(this);
                A13.setOnClickListener(this);
                A14.setOnClickListener(this);
                A15.setOnClickListener(this);
                A16.setOnClickListener(this);
                A17.setOnClickListener(this);
                B1.setOnClickListener(this);
                B2.setOnClickListener(this);
                B3.setOnClickListener(this);
                B4.setOnClickListener(this);
                B5.setOnClickListener(this);
                B6.setOnClickListener(this);
                B7.setOnClickListener(this);
                B8.setOnClickListener(this);
                B9.setOnClickListener(this);
                B10.setOnClickListener(this);
                B11.setOnClickListener(this);
                B12.setOnClickListener(this);
                B13.setOnClickListener(this);
                B14.setOnClickListener(this);
                B15.setOnClickListener(this);
                B16.setOnClickListener(this);
                B17.setOnClickListener(this);
                B18.setOnClickListener(this);


                checkSeat();
                break;
            case "2":
                setContentView(R.layout.layout_4);
                card_snack = findViewById(R.id.bottom_snack_bar);
                proceed = (findViewById(R.id.proceed));
                price = findViewById(R.id.price);
                seat_all = findViewById(R.id.txt1);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), BordingPoint.class);
                        startActivity(intent);

                    }
                });
                //Cabinet SEATS
                C1 = findViewById(R.id.C01);
                C2 = findViewById(R.id.A0A);
                C3 = findViewById(R.id.C03);
                //A sides
                A1 = findViewById(R.id.A01);
                A2 = findViewById(R.id.A02);
                A3 = findViewById(R.id.A03);
                A4 = findViewById(R.id.A04);
                A5 = findViewById(R.id.A05);
                A6 = findViewById(R.id.A06);
                A7 = findViewById(R.id.A07);
                A8 = findViewById(R.id.A08);
                A9 = findViewById(R.id.A09);
                A10 = findViewById(R.id.A10);
                A11 = findViewById(R.id.A11);
                A12 = findViewById(R.id.A12);
                A13 = findViewById(R.id.A13);
                A14 = findViewById(R.id.A14);
                A15 = findViewById(R.id.A15);
                A16 = findViewById(R.id.A16);
                A17 = findViewById(R.id.A17);

                //B side seats
                B1 = findViewById(R.id.B01);
                B2 = findViewById(R.id.B02);
                B3 = findViewById(R.id.B03);
                B4 = findViewById(R.id.B04);
                B5 = findViewById(R.id.B05);
                B6 = findViewById(R.id.B06);
                B7 = findViewById(R.id.B07);
                B8 = findViewById(R.id.B08);
                B9 = findViewById(R.id.B09);
                B10 = findViewById(R.id.B10);
                B11 = findViewById(R.id.B11);
                B12 = findViewById(R.id.B12);
                B13 = findViewById(R.id.B13);
                B14 = findViewById(R.id.B14);
                B15 = findViewById(R.id.B15);
                B16 = findViewById(R.id.B16);
                B17 = findViewById(R.id.B17);
                B18 = findViewById(R.id.B18);

                A1.setOnClickListener(this);
                A2.setOnClickListener(this);
                A3.setOnClickListener(this);
                A4.setOnClickListener(this);
                A5.setOnClickListener(this);
                A6.setOnClickListener(this);
                A7.setOnClickListener(this);
                A8.setOnClickListener(this);
                A9.setOnClickListener(this);
                A10.setOnClickListener(this);
                A11.setOnClickListener(this);
                A12.setOnClickListener(this);
                A13.setOnClickListener(this);
                A14.setOnClickListener(this);
                A15.setOnClickListener(this);
                A16.setOnClickListener(this);
                A17.setOnClickListener(this);


                B1.setOnClickListener(this);
                B2.setOnClickListener(this);
                B3.setOnClickListener(this);
                B4.setOnClickListener(this);
                B5.setOnClickListener(this);
                B6.setOnClickListener(this);
                B7.setOnClickListener(this);
                B8.setOnClickListener(this);
                B9.setOnClickListener(this);
                B10.setOnClickListener(this);
                B11.setOnClickListener(this);
                B12.setOnClickListener(this);
                B13.setOnClickListener(this);
                B14.setOnClickListener(this);
                B15.setOnClickListener(this);
                B16.setOnClickListener(this);
                B17.setOnClickListener(this);
                B18.setOnClickListener(this);
                C1.setOnClickListener(this);
                C2.setOnClickListener(this);
                C3.setOnClickListener(this);

                checkSeat();
                break;

        }

    }

    public void priceAdd(float seat_price) {
        total_price = total_price + seat_price;
        price.setText(String.valueOf(total_price));
        //Toast.makeText(this,String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }

    public void priceSub(float seat_price) {
        total_price = total_price - seat_price;
        price.setText(String.valueOf(total_price));

        //Toast.makeText(this,String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }

    public void addData(String value) {
        seat_list.add(value);
        seat_all.setText(seat_list.toString().replaceAll("\\[|\\]", ""));
        if (String.valueOf(seat_list.size()).equals(0)) {
            card_snack.setVisibility(View.GONE);
        } else {
            card_snack.setVisibility(View.VISIBLE);
        }
    }

    public void removeData(String value) {

        seat_list.remove(value);
        seat_all.setText(seat_list.toString().replaceAll("\\[|\\]", ""));
        if ((seat_list.isEmpty())) {
            card_snack.setVisibility(View.GONE);
        } else {
            card_snack.setVisibility(View.VISIBLE);
        }
    }


    public void checkSeat() {

        List<String> values = new ArrayList<String>(Arrays.asList(booked_Seats_no));
        for (String string : seat_id) {
            if (values.contains(string)) {
                Toast.makeText(this, "seat " + string + " booked", Toast.LENGTH_SHORT).show();
                int resID = getResources().getIdentifier(string, "id", getPackageName());
                TextView v = (TextView) findViewById(resID);
                v.setBackgroundResource(R.drawable.ic_seat_booked);
                v.setEnabled(false);
                v.setClickable(false);
           /*     Log.e("RESID",Integer.toString(resID));
                Log.e("BOOKED SEAT",string);*/
            } else {
                System.out.println("Action cannot be set");
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A01:
                String seat_A1 = "A01";
                if (seat_A1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A1);
                    priceAdd(SeatPrice);
                    seat_A1_flag = true;
                    //counter++;
                    //counter(counter);
                } else {
                    removeData(seat_A1);
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    priceSub(SeatPrice);
                    seat_A1_flag = false;
                    // counter--;
                    //counter(counter);
                }
                break;

            case R.id.A02:
                String seat_A2 = "A02";
                if (seat_A2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A2);
                    priceAdd(SeatPrice);
                    seat_A2_flag = true;
                } else {
                    removeData(seat_A2);
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    priceSub(SeatPrice);
                    seat_A2_flag = false;
                }

                break;
            case R.id.A03:
                String seat_A3 = "A03";
                if (seat_A3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A3);
                    priceAdd(SeatPrice);
                    seat_A3_flag = true;
                } else {
                    removeData(seat_A3);
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    priceSub(SeatPrice);
                    seat_A3_flag = false;
                }
                break;
            case R.id.A04:
                String seat_A4 = "A04";
                if (seat_A4_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A4);
                    priceAdd(SeatPrice);
                    seat_A4_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A4);
                    priceSub(SeatPrice);
                    seat_A4_flag = false;
                }
                break;
            case R.id.A05:
                String seat_A5 = "A05";
                if (seat_A5_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A5);
                    priceAdd(SeatPrice);
                    seat_A5_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A5);
                    priceSub(SeatPrice);
                    seat_A5_flag = false;
                }
                break;
            case R.id.A06:
                String seat_A6 = "A06";
                if (seat_A6_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A6);
                    priceAdd(SeatPrice);
                    seat_A6_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A6);
                    priceSub(SeatPrice);
                    seat_A6_flag = false;
                }
                break;
            case R.id.A07:
                String seat_A7 = "A07";
                if (seat_A7_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A7);
                    priceAdd(SeatPrice);
                    seat_A7_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A7);
                    priceSub(SeatPrice);
                    seat_A7_flag = false;
                }
                break;
            case R.id.A08:
                String seat_A8 = "A08";
                if (seat_A8_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A8);
                    priceAdd(SeatPrice);
                    seat_A8_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A8);
                    priceSub(SeatPrice);
                    seat_A8_flag = false;
                }
                break;
            case R.id.A09:
                String seat_A9 = "A09";
                if (seat_A9_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A9);
                    priceAdd(SeatPrice);
                    seat_A9_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A9);
                    priceSub(SeatPrice);
                    seat_A9_flag = false;
                }
                break;
            case R.id.A10:
                String seat_A10 = "A10";
                if (seat_A10_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A10);
                    priceAdd(SeatPrice);
                    seat_A10_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A10);
                    priceSub(SeatPrice);
                    seat_A10_flag = false;
                }
                break;
            case R.id.A11:
                String seat_A11 = "A11";
                if (seat_A11_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A11);
                    priceAdd(SeatPrice);
                    seat_A11_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A11);
                    priceSub(SeatPrice);
                    seat_A11_flag = false;
                }
                break;
            case R.id.A12:
                String seat_A12 = "A12";
                if (seat_A12_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A12);
                    priceAdd(SeatPrice);
                    seat_A12_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A12);
                    priceSub(SeatPrice);
                    seat_A12_flag = false;
                }
                break;
            case R.id.A13:
                String seat_A13 = "A13";
                if (seat_A13_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A13);
                    priceAdd(SeatPrice);
                    seat_A13_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A13);
                    priceSub(SeatPrice);
                    seat_A13_flag = false;
                }
                break;
            case R.id.A14:
                String seat_A14 = "A14";
                if (seat_A14_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A14);
                    priceAdd(SeatPrice);
                    seat_A14_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A14);
                    priceSub(SeatPrice);
                    seat_A14_flag = false;
                }
                break;
            case R.id.A15:
                String seat_A15 = "A15";
                if (seat_A15_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A15);
                    priceAdd(SeatPrice);
                    seat_A15_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A15);
                    priceSub(SeatPrice);
                    seat_A15_flag = false;
                }
                break;
            case R.id.A16:
                String seat_A16 = "A16";
                if (seat_A16_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A16);
                    priceAdd(SeatPrice);
                    seat_A16_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A16);
                    priceSub(SeatPrice);
                    seat_A16_flag = false;
                }
                break;
            case R.id.A17:
                String seat_A17 = "A17";
                if (seat_A17_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_A17);
                    priceAdd(SeatPrice);
                    seat_A17_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_A17);
                    priceSub(SeatPrice);
                    seat_A17_flag = false;
                }
                break;
            case R.id.B01:
                String seat_B1 = "B1";
                if (seat_B1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B1);
                    priceAdd(SeatPrice);
                    seat_B1_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B1);
                    priceSub(SeatPrice);
                    seat_B1_flag = false;
                }
                break;
            case R.id.B02:
                String seat_B2 = "B02";
                if (seat_B2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B2);
                    priceAdd(SeatPrice);
                    seat_B2_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B2);
                    priceSub(SeatPrice);
                    seat_B2_flag = false;
                }
                break;
            case R.id.B03:
                String seat_B3 = "B03";
                if (seat_B3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B3);
                    priceAdd(SeatPrice);
                    seat_B3_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B3);
                    priceSub(SeatPrice);
                    seat_B3_flag = false;
                }
                break;
            case R.id.B04:
                String seat_B4 = "B04";
                if (seat_B4_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B4);
                    priceAdd(SeatPrice);
                    seat_B4_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B4);
                    priceSub(SeatPrice);
                    seat_B4_flag = false;
                }
                break;
            case R.id.B05:
                String seat_B5 = "B05";
                if (seat_B5_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B5);
                    priceAdd(SeatPrice);
                    seat_B5_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B5);
                    priceSub(SeatPrice);
                    seat_B5_flag = false;
                }
                break;
            case R.id.B06:
                String seat_B6 = "B06";
                if (seat_B6_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B6);
                    priceAdd(SeatPrice);
                    seat_B6_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B6);
                    priceSub(SeatPrice);
                    seat_B6_flag = false;
                }
                break;
            case R.id.B07:
                String seat_B7 = "B07";
                if (seat_B7_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B7);
                    priceAdd(SeatPrice);
                    seat_B7_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B7);
                    priceSub(SeatPrice);
                    seat_B7_flag = false;
                }
                break;
            case R.id.B08:
                String seat_B8 = "B08";
                if (seat_B8_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B8);
                    priceAdd(SeatPrice);
                    seat_B8_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B8);
                    priceSub(SeatPrice);
                    seat_B8_flag = false;
                }
                break;
            case R.id.B09:
                String seat_B9 = "B09";
                if (seat_B9_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B9);
                    priceAdd(SeatPrice);
                    seat_B9_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B9);
                    priceSub(SeatPrice);
                    seat_B9_flag = false;
                }
                break;
            case R.id.B10:
                String seat_B10 = "B10";
                if (seat_B10_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B10);
                    priceAdd(SeatPrice);
                    seat_B10_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B10);
                    priceSub(SeatPrice);
                    seat_B10_flag = false;
                }
                break;
            case R.id.B11:
                String seat_B11 = "B11";
                if (seat_B11_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B11);
                    priceAdd(SeatPrice);
                    seat_B11_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B11);
                    priceSub(SeatPrice);
                    seat_B11_flag = false;
                }
                break;
            case R.id.B12:
                String seat_B12 = "B12";
                if (seat_B12_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B12);
                    priceAdd(SeatPrice);
                    seat_B12_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B12);
                    priceSub(SeatPrice);
                    seat_A2_flag = false;
                }
                break;
            case R.id.B13:
                String seat_B13 = "B13";
                if (seat_B13_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B13);
                    priceAdd(SeatPrice);
                    seat_B13_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B13);
                    priceSub(SeatPrice);
                    seat_B13_flag = false;
                }
                break;
            case R.id.B14:
                String seat_B14 = "B14";
                if (seat_B14_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B14);
                    priceAdd(SeatPrice);
                    seat_B14_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B14);
                    priceSub(SeatPrice);
                    seat_B14_flag = false;
                }
                break;
            case R.id.B15:
                String seat_B15 = "B15";
                if (seat_B15_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B15);
                    priceAdd(SeatPrice);
                    seat_B15_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B15);
                    priceSub(SeatPrice);
                    seat_B15_flag = false;
                }
                break;
            case R.id.B16:
                String seat_B16 = "B16";
                if (seat_B16_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B16);
                    priceAdd(SeatPrice);
                    seat_B16_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B16);
                    priceSub(SeatPrice);
                    seat_B16_flag = false;
                }
                break;
            case R.id.B17:
                String seat_B17 = "B17";
                if (seat_B17_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B17);
                    priceAdd(SeatPrice);
                    seat_B17_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B17);
                    priceSub(SeatPrice);
                    seat_B17_flag = false;
                }
                break;
            case R.id.B18:
                String seat_B18 = "B18";
                if (seat_B18_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_B18);
                    priceAdd(SeatPrice);
                    seat_B18_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_B18);
                    priceSub(SeatPrice);
                    seat_B18_flag = false;
                }
                break;
            case R.id.C01:
                String seat_C1 = "C01";
                if (seat_C1_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_C1);
                    priceAdd(SeatPrice);
                    seat_C1_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_C1);
                    priceSub(SeatPrice);
                    seat_C1_flag = false;
                }
                break;
            case R.id.A0A:
                String seat_C2 = "A0A";
                if (seat_C2_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_C2);
                    priceAdd(SeatPrice);
                    seat_C2_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_C2);
                    priceSub(SeatPrice);
                    seat_C2_flag = false;
                }
                break;
            case R.id.C03:
                String seat_C3 = "C03";
                if (seat_C3_flag.equals(false)) {
                    view.setBackgroundResource(R.drawable.ic_seat_selected);
                    addData(seat_C3);
                    priceAdd(SeatPrice);
                    seat_C3_flag = true;
                } else {
                    view.setBackgroundResource(R.drawable.ic_seat_available);
                    removeData(seat_C3);
                    priceSub(SeatPrice);
                    seat_C3_flag = false;
                }
                break;
        }
    }
}
