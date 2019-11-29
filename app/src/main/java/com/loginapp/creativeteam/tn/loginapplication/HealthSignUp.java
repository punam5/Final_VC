package com.loginapp.creativeteam.tn.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parse.ParseUser;

public class HealthSignUp extends AppCompatActivity {

    Button btn1,btn2;
    private FirebaseAuth mAuth;
    private DatabaseReference mUsersReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_sign_up);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        final ParseUser parseUser = new ParseUser().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("type1", "doctor");
                mUsersReference = FirebaseDatabase.getInstance().getReference("doctor");
                mUsersReference.child(mAuth.getCurrentUser().getUid()).child("name").setValue(parseUser.getString("name"));
                mUsersReference.child(mAuth.getCurrentUser().getUid()).child("objectid").setValue(parseUser.getObjectId());

                Intent intent = new Intent(HealthSignUp.this,DoctorSignUp.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("type1", "patient");
                mUsersReference = FirebaseDatabase.getInstance().getReference("patient");
                mUsersReference.child(mAuth.getCurrentUser().getUid()).child("name").setValue(parseUser.getString("name"));
                mUsersReference.child(mAuth.getCurrentUser().getUid()).child("objectid").setValue(parseUser.getObjectId());
                Intent intent = new Intent(HealthSignUp.this,PatientSignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
