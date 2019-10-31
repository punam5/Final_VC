package com.loginapp.creativeteam.tn.loginapplication;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import androidx.appcompat.app.AppCompatActivity;

public class Business1Activity extends AppCompatActivity {

    EditText cname,caddress,cemail,cdate;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business1);

        cname = findViewById(R.id.cname);
        caddress = findViewById(R.id.caddress);
        cemail = findViewById(R.id.cemail);
        cdate = findViewById(R.id.cdate);
        next = findViewById(R.id.cnext_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(cname.getText())) {
                    cname.setError("Name is required!");
                } else if (TextUtils.isEmpty(caddress.getText())) {
                    caddress.setError("Address is required!");
                } else if (TextUtils.isEmpty(cemail.getText())) {
                    cemail.setError("Address is required!");
                } else if (TextUtils.isEmpty(cdate.getText())) {
                    cdate.setError("Address is required!");
                } else {

                    ParseUser user = ParseUser.getCurrentUser();
                    user.put("cname", cname.getText().toString().trim());
                    user.put("cemail", cemail.getText().toString());
                    user.put("caddress", caddress.getText().toString().trim());
                    user.put("cdate", cdate.getText().toString());

                    user.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e == null) {
                                Toast.makeText(Business1Activity.this, "Welcome!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Business1Activity.this,ProfileActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                ParseUser.logOut();
                                Toast.makeText(Business1Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }


        });


    }}
