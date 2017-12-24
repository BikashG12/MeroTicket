package com.infobrain.meroticket.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.infobrain.meroticket.R;

public class BookingDetails extends AppCompatActivity {
    Button bookbtn;
    EditText passenger_name, passeneger_contactno, passenger_email, passenger_address;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        bookbtn = (Button) findViewById(R.id.book_btn);
        passenger_name = (EditText) findViewById(R.id.passenger_name);
        passeneger_contactno = (EditText) findViewById(R.id.passenger_contactno);
        passenger_email = (EditText) findViewById(R.id.passenger_email);
        passenger_address = (EditText) findViewById(R.id.passenger_address);
        bookbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (!checkValidation()) {

                } else
                    //success();
                    customAlert();

            }
        });
    }


    public void success() {


        /*final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Booking Conformation")
                .setView(R.layout.custom_book_confirm)
                .create();

        dialog.show();
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        Button btn_confirm = (Button) dialog.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
                dialog.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });*/


        /*final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.custom_book_confirm);
        dialog.setTitle("Booking ");
        Button btn_cancel=(Button)dialog.findViewById(R.id.btn_cancel);
        Button btn_confirm=(Button)dialog.findViewById(R.id.btn_confirm);
        dialog.show();
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
                dialog.dismiss();
                *//*Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*//*
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });*/


    }

    public void alertDialog() {
        //Data push to database when success of validation...
//        Toast.makeText(SignUp.this,"Sign Up Successful",Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Successful.");
        builder.setMessage("Have a nice journey");
        AlertDialog alert = builder.create();
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
  public void customAlert(){
      AlertDialog.Builder builder = new AlertDialog.Builder(this);

      LayoutInflater inflater = this.getLayoutInflater();
      View dialogView = inflater.inflate(R.layout.custom_book_confirm, null);
      builder.setTitle("Booking Confirm");
      builder.setView(dialogView);
      final AlertDialog dialog = builder.create();


      Button btn_cancel=(Button)dialogView.findViewById(R.id.btn_cancel);
      btn_cancel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              dialog.dismiss();

          }
      });
      Button btn_confirm=(Button)dialogView.findViewById(R.id.btn_confirm);
      btn_confirm.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              alertDialog();
              dialog.dismiss();
          }
      });

      dialog.show();



  }

}
