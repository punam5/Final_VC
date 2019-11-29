package com.loginapp.creativeteam.tn.loginapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.appcompat.app.AppCompatActivity;

public class QueryActivity extends Activity {

    Button business;
    Button button4;
    Button bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        business = findViewById(R.id.button1);
        business.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            ParseUser parseUser = ParseUser.getCurrentUser();
                                            String flag = parseUser.getString("flag");
                                            String type = parseUser.getString("type");

                                             if(flag.equals("l") && type.equals("client")){
                                                Intent intent = new Intent(QueryActivity.this,UserHome.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else if(flag.equals("l") && type.equals("server")){
                                                Intent intent = new Intent(QueryActivity.this, ServerHome.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else
                                                {

                                                Intent intent = new Intent(QueryActivity.this, prev_query.class);
                                                startActivity(intent);
                                                finish();

                                                 }
                                        }


                                    });

        bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueryActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bt3 = findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseUser parseUser = ParseUser.getCurrentUser();
                String flag = parseUser.getString("flag");
                String type1 = parseUser.getString("type1");

                /* if(  type1.equals("doctor"))
                 {
                    Intent intent = new Intent(QueryActivity.this,DoctorProfile.class);
                    startActivity(intent);
                    finish();
                }
                else if(  type1.equals("patient")){
                    Intent intent = new Intent(QueryActivity.this, PatientSignUp.class);
                    startActivity(intent);
                    finish();
                }*/
               // else
                    //{
                    Intent intent = new Intent(QueryActivity.this, HealthSignUp.class);
                    startActivity(intent);
                    finish();
               // }
               /* Intent intent = new Intent(QueryActivity.this, HealthSignUp.class);
                startActivity(intent);
                finish();*/
            }
        });


        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueryActivity.this,Sentiment_home.class);
                startActivity(intent);
                finish();
            }
        });





    }


}
