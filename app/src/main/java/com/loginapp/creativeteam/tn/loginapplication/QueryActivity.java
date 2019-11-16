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
    Button bt2;
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
                                            if (flag.equals("r")) {
                                                Intent intent = new Intent(QueryActivity.this, prev_query.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else if(flag.equals("l") && type.equals("client")){
                                                Intent intent = new Intent(QueryActivity.this,UserHome.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else if(flag.equals("l") && type.equals("server")){
                                                Intent intent = new Intent(QueryActivity.this, ServerHome.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }


                                    });

        bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueryActivity.this, Map2Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}
