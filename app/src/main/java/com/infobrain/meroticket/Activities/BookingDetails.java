package com.infobrain.meroticket.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.infobrain.meroticket.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BookingDetails extends AppCompatActivity {
    Button bookbtn;
    EditText passenger_name, passeneger_contactno, passenger_email, passenger_address;
    TextView boarding, bus_no, bus_seat, total_price;

    String bus_num, bus_seats, total_prices;
    String boarding_points, route_id, date, com_code, bus_id;

    String pasName, pasContact, passEmail, passAddress, bus_seatss;
    String confirmation_code;
    String cust_username, cust_userPassword, cust_companyCode, cust_fullName, cust_phone, cust_address, cust_email;
    String cust_busId, cust_seatNos, cust_forDate, cust_borPoint, cust_routeId, cust_remarks, cust_payMode, cust_totalAmt;

    String name, password, companyCode, customerName, customerPhone, customerAddress, customerEmail, customerBusId, customerSeatNos;
    String customerForDate, customerBorPoint, customerRouteId, customerRemarks, customerPaymentMode, customerTotalAmt;

    String booking_URL, booking_JSON, main_booking_URL;

    ScrollView print;
    RelativeLayout root_layout_print;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        final Singleton c_code = (Singleton) getApplicationContext();

        root_layout_print = findViewById(R.id.layout_print_view);
        print = findViewById(R.id.print_view);

        bookbtn = (Button) findViewById(R.id.book_btn);
        passenger_name = (EditText) findViewById(R.id.passenger_name);
        passeneger_contactno = (EditText) findViewById(R.id.passenger_contactno);
        passenger_email = (EditText) findViewById(R.id.passenger_email);
        passenger_address = (EditText) findViewById(R.id.passenger_address);
        boarding = findViewById(R.id.Boarding_point);
        bus_no = findViewById(R.id.Bus_no);
        bus_seat = findViewById(R.id.select_seat);
        total_price = findViewById(R.id.total_price);


        Intent intent = getIntent();
        boarding_points = intent.getStringExtra("boarding_point");

        bus_num = c_code.getBus_name();
        bus_seatss = c_code.getSelected_no();
        bus_seats = bus_seatss.replaceAll(" ", "");
        total_prices = c_code.getTotal_price();

        bus_id = c_code.getBus_id();
        route_id = c_code.getRoute_id();
        date = c_code.getDate();

        com_code = c_code.getC_code();

        bus_no.setText(bus_num);
        bus_seat.setText(bus_seats);
        total_price.setText(total_prices);
        boarding.setText(boarding_points);


        bookbtn.setOnClickListener(new View.OnClickListener() {
                                       @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                       @Override
                                       public void onClick(View view) {
                                           if (!checkValidation()) {

                                           } else
                                               customAlert();
                                       }
                                   }
        );
    }

    private void confirm_ticket() {

        cust_username = "dipen";
        cust_userPassword = "b";
        cust_companyCode = com_code;

        cust_fullName = pasName;
        cust_phone = pasContact;
        cust_email = passEmail;
        cust_address = passAddress;

        cust_busId = bus_id;
        cust_seatNos = bus_seats;
        cust_totalAmt = total_prices;
        cust_borPoint = boarding_points;
        cust_routeId = route_id;
        cust_forDate = date;

        cust_remarks = "Seat Booking Confirmed";
        cust_payMode = "Cash";

        name = "\"" + cust_username + "\"";
        password = "\"" + cust_userPassword + "\"";
        companyCode = "\"" + cust_companyCode + "\"";

        customerName = "\"" + cust_fullName + "\"";
        customerPhone = "\"" + cust_phone + "\"";
        customerAddress = "\"" + cust_address + "\"";
        customerEmail = "\"" + cust_email + "\"";
        customerBusId = "\"" + cust_busId + "\"";
        customerSeatNos = "\"" + cust_seatNos + "\"";
        customerForDate = "\"" + cust_forDate + "\"";
        customerBorPoint = "\"" + cust_borPoint + "\"";
        customerRouteId = "\"" + cust_routeId + "\"";
        customerRemarks = "\"" + cust_remarks + "\"";
        customerPaymentMode = "\"" + cust_payMode + "\"";
        customerTotalAmt = "\"" + cust_totalAmt + "\"";

        booking_JSON =

                "jsonData=" +

                        "{" +

                        "\"Table1\"" +

                        ":[{" +

                        "\"Username\"" +

                        ":" +

                        name +

                        "," +

                        "\"Password\"" +

                        ":" +

                        password +

                        "," +

                        "\"C_Code\"" +

                        ":" +

                        companyCode +

                        "}]" +

                        "," +

                        "\"Table\"" +

                        ":[{" +

                        "\"P_Name\"" +

                        ":" +

                        customerName +

                        "," +

                        "\"Mobile_No\"" +

                        ":" +

                        customerPhone +

                        "," +

                        "\"Address\"" +

                        ":" +

                        customerAddress +

                        "," +

                        "\"Email\"" +

                        ":" +

                        customerEmail +

                        "," +

                        "\"Bus_Id\"" +

                        ":" +

                        customerBusId +

                        "," +

                        "\"Seat_No\"" +

                        ":" +

                        customerSeatNos +

                        "," +

                        "\"For_Date\"" +

                        ":" +

                        customerForDate +

                        "," +

                        "\"Boarding_Point\"" +

                        ":" +

                        customerBorPoint +

                        "," +

                        "\"Route_Id\"" +

                        ":" +

                        customerRouteId +

                        "," +

                        "\"Remarks\"" +

                        ":" +

                        customerRemarks +

                        "," +

                        "\"Payment_Mode\"" +

                        ":" +

                        customerPaymentMode +

                        "," +

                        "\"Total_Amt\"" +

                        ":" +

                        customerTotalAmt +

                        "}]" +

                        "}";

        booking_URL = "https://laxmicapital.com.np/abc/services/webservice.asmx/Confirm_Bus_Booking?" + booking_JSON;
        main_booking_URL = booking_URL.replaceAll(" ", "+" + "%20" + "+");

        Log.e("Booking_URL", booking_JSON);
        Log.e("Booking_URL", booking_URL);
        Log.e("Booking_URL", main_booking_URL);

        final StringRequest stringRequest = new StringRequest(Request.Method.GET, main_booking_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("Table1");

                    JSONObject contain = array.getJSONObject(0);
                    String code = contain.getString("Response_Code");
                    confirmation_code = contain.getString("Message_Detail");

                    if (code.equals("100")) {
                        Log.e("Confirmation Code", confirmation_code);
                        alertDialog();
                        createPdf();
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                        finish();
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

    private void createPdf() {
//        root_layout_print.setDrawingCacheEnabled(true);
//        root_layout_print.buildDrawingCache();
//        Bitmap bm = root_layout_print.getDrawingCache();
        createBitmapFromLayoutWithText();
        saveToCacheFile(bitmap);
    }



    public void alertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Successful.");
        builder.setMessage("Have a nice journey");
        final AlertDialog alert = builder.create();
        alert.show();
    }


    public boolean checkValidation() {
        boolean validation_flag = true;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String pass_name = String.valueOf(passenger_name.getText());
        String pass_contactno = String.valueOf(passeneger_contactno.getText());
        String pass_email = String.valueOf(passenger_email.getText());
        String pass_address = String.valueOf(passenger_address.getText());

        if (pass_name.isEmpty()) {
            passenger_name.setError("Please enter your name.");
            validation_flag = false;
        } else if (pass_contactno.isEmpty() || pass_contactno.length() > 10 || pass_contactno.length() < 10) {
            passeneger_contactno.setError("Please enter your valid mobile no.");
            validation_flag = false;
        } else if (pass_email.isEmpty()) {
            passenger_email.setError("Please enter you email address.");
            validation_flag = false;

        } else if (pass_address.isEmpty()) {
            passenger_address.setError("Please enter your address.");
            validation_flag = false;
        } else if (!pass_email.matches(emailPattern)) {
            passenger_email.setError("Please eneter your valid email address.");
            validation_flag = false;


        }
        return validation_flag;

    }

    public void customAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final Singleton c_code = (Singleton) getApplicationContext();

        View dialogView = inflater.inflate(R.layout.custom_book_confirm, null);
        builder.setTitle("Booking Confirm");
        builder.setView(dialogView);
        TextView bus_name = dialogView.findViewById(R.id.alert_bus_no);
        TextView bus_Seat_info = dialogView.findViewById(R.id.alert_bus_seat_info);
        TextView total_price = dialogView.findViewById(R.id.alert_Total_price);
        TextView boarding_point = dialogView.findViewById(R.id.alert_boarding_point);
        TextView pass_email = dialogView.findViewById(R.id.alert_pass_email);
        TextView phone_no = dialogView.findViewById(R.id.alert_pass_phone_number);
        TextView pass_name = dialogView.findViewById(R.id.alert_passenger_name);
        TextView pass_address = dialogView.findViewById(R.id.alert_address);
        bus_name.setText(bus_num);
        bus_Seat_info.setText(bus_seats);
        total_price.setText(total_prices);
        boarding_point.setText(boarding_points);
        pasName = passenger_name.getText().toString();
        Log.e("PASSNAME", pasName);
        pass_name.setText(pasName);
        pasContact = passeneger_contactno.getText().toString();
        phone_no.setText(pasContact);
        passEmail = passenger_email.getText().toString();
        pass_email.setText(passEmail);
        passAddress = passenger_address.getText().toString();
        pass_address.setText(passAddress);


        final AlertDialog dialog = builder.create();

        Button btn_cancel = (Button) dialogView.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });
        Button btn_confirm = (Button) dialogView.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm_ticket();
                createPdf();
//                alertDialog();

            }
        });

        dialog.show();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return false;
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

        Intent intent = new Intent(BookingDetails.this, BordingPoint.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }

    public static File getSavePath() {
        File path;
        if (hasSDCard()) { // SD card
            path = new File(getSDCardPath() + "/MeroTicketBookings/");
            Log.e("Sd card path",getSDCardPath());
            path.mkdir();
        } else {
            path = Environment.getDataDirectory();
        }
        return path;
    }
    public static String getCacheFilename() {
        File f = getSavePath();
        return f.getAbsolutePath() + "/cache.png";
    }
    public static Bitmap loadFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) { return null; }
            Bitmap tmp = BitmapFactory.decodeFile(filename);
            return tmp;
        } catch (Exception e) {
            return null;
        }
    }
    public static Bitmap loadFromCacheFile() {
        return loadFromFile(getCacheFilename());
    }
    public static void saveToCacheFile(Bitmap bmp) {
        saveToFile(getCacheFilename(),bmp);
    }

    public static void saveToFile(String filename,Bitmap bmp) {
        try {
            FileOutputStream out = new FileOutputStream(filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch(Exception e) {}
    }
    public static boolean hasSDCard() { // SD????????
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }
    public static String getSDCardPath() {
        File path = Environment.getExternalStorageDirectory();
        return path.getAbsolutePath();
    }

    public Bitmap createBitmapFromLayoutWithText() {

        LayoutInflater  mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflate the layout into a view and configure it the way you like
        LinearLayout view = new LinearLayout(getBaseContext());
        mInflater.inflate(R.layout.print_ticket, view, true);
        bus_no.setText(bus_num);
        bus_seat.setText(bus_seats);
        total_price.setText(total_prices);
        boarding.setText(boarding_points);


        passenger_name.setText(pasName);
        passeneger_contactno.setText(pasContact);
        passenger_email.setText(passEmail);
        passenger_address.setText(passAddress);

        //Provide it with a layout params. It should necessarily be wrapping the
        //content as we not really going to have a parent for it.
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        //Pre-measure the view so that height and width don't remain null.
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        //Assign a size and position to the view and all of its descendants
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        //Create the bitmap
        bitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        //Create a canvas with the specified bitmap to draw into
        Canvas c = new Canvas(bitmap);

        //Render this view (and all of its children) to the given Canvas
        view.draw(c);
        return bitmap;
    }

}
