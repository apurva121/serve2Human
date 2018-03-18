package com.example.apurva.servetohuman;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OneActivity extends AppCompatActivity {

    private String message ;
    private String contact;
    private String location = " Teliyarganj, Allahabad";

    private EditText msg, cntct;
    private Button submit;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        //LocationFinder locate;

        ref = FirebaseDatabase.getInstance().getReference("user");

        msg = (EditText) findViewById(R.id.msg);
        cntct = (EditText) findViewById(R.id.contact);
        submit = (Button)findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Notification();
              //  location = locate.getlocation();

            }
        });


    }

    public void addUser(){
        message = msg.getText().toString();
        contact = cntct.getText().toString();

        if (!TextUtils.isEmpty(contact)) {
            String id = ref.push().getKey();
            User user = new User(id,message,contact,location);
            ref.child(id).setValue(user);
            Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Enter your contact", Toast.LENGTH_SHORT).show();
        }


        }

    public void Notification() {
        // Set Notification Title
        String strtitle = "Notification Arrival";
        // Set Notification Text
        String strtext = "PLease help";

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(this, Instant_help.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Create Notification using NotificationCompat.Builder
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                // Set Icon
                .setSmallIcon(R.drawable.notif_icon)
                // Set Ticker Message
                .setTicker("Notification")
                // Set Title
                .setContentTitle("Arrival")
                // Set Text
                .setContentText("Help")
                // Add an Action Button below Notification
                .addAction(R.drawable.ic_launcher_background, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        int m =(int) System.currentTimeMillis();
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(m , builder.build());

    }
}
