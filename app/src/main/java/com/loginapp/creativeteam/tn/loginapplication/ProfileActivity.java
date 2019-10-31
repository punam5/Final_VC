package com.loginapp.creativeteam.tn.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
TextView cname_id,cemail_id,cdate_id,caddress_id,user_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        cname_id=findViewById(R.id.cname_id);
        caddress_id=findViewById(R.id.caddress_id);
        user_profile=findViewById(R.id.user_profile_name);
        cdate_id=findViewById(R.id.cdate_id);
        cemail_id=findViewById(R.id.cemail_id);
        ParseUser parseUser=ParseUser.getCurrentUser();
        String cname=parseUser.getString("cname");
        String cemail=parseUser.getString("cemail");
        String caddress=parseUser.getString("caddress");
        String cdate=parseUser.getString("cdate");
        String name=parseUser.getString("name");
        user_profile.setText(name);
        cname_id.setText(cname);
        cemail_id.setText(cemail);
        caddress_id.setText(caddress);
        cdate_id.setText(cdate);

    }
}
