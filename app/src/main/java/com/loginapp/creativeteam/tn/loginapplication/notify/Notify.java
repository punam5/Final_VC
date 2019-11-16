package com.loginapp.creativeteam.tn.loginapplication.notify;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.loginapp.creativeteam.tn.loginapplication.BloqueryActivity;
import com.loginapp.creativeteam.tn.loginapplication.Profile_user_click;
import com.parse.ParseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Notify extends AppCompatActivity {
    String edtTitle;
    String edtMessage;
    final private String FCM_API = "https://fcm.googleapis.com/fcm/send";
    final private String serverKey = "key=" + "AAAAhmJS1UA:APA91bGKrV9N92oQjVnskWHT2HjUbGSN3SqvvuQqrodoTLQDpUyxBunVUW7NLCX-BHGYorevOj4HdLbySbNmiWxmngBeD1TbVTyN73DgN1eTZ64HRxBX3Lo4C_GQGdcy59EY3ToaC7g3";
    final private String contentType = "application/json";
    final String TAG = "NOTIFICATION TAG";
    
    String NOTIFICATION_TITLE;
    String NOTIFICATION_MESSAGE;
    String TOPIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");

        edtTitle =ParseUser.getCurrentUser().getUsername()+" sends Query from "+ ParseUser.getCurrentUser().getEmail()+" to";
        edtMessage = name+" at "+ email;



                TOPIC = "/topics/userABC"; //topic has to match what the receiver subscribed to
                NOTIFICATION_TITLE = edtTitle;
                NOTIFICATION_MESSAGE = edtMessage;

                JSONObject notification = new JSONObject();
                JSONObject notifcationBody = new JSONObject();
                try {
                    notifcationBody.put("title", NOTIFICATION_TITLE);
                    notifcationBody.put("message", NOTIFICATION_MESSAGE);

                    notification.put("to", TOPIC);
                    notification.put("data", notifcationBody);
                    intent = new Intent(Notify.this, BloqueryActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                   Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
                sendNotification(notification);
            }




    private void sendNotification(JSONObject notification) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(FCM_API, notification,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse: " + response.toString());
                        edtTitle="";
                        edtMessage="";
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notify.this, "Request error", Toast.LENGTH_LONG).show();
                        Log.i(TAG, "onErrorResponse: Didn't work");
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", serverKey);
                params.put("Content-Type", contentType);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }
}
