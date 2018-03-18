package com.example.apurva.servetohuman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Notification_success extends AppCompatActivity {

    TextView Location, Contact, Message;
    String msg, cntct, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_success);

        Location = (TextView) findViewById(R.id.Location);
        Contact = (TextView) findViewById(R.id.Contact);
        Message = (TextView) findViewById(R.id.Message);




        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query lastQuery = databaseReference.child("user").orderByKey().limitToLast(1);
        lastQuery.addValueEventListener(new ValueEventListener() {

                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                 msg = dataSnapshot.child("message").getValue().toString();
                                                 cntct = dataSnapshot.child("contact").getValue().toString();
                                                 location = dataSnapshot.child("location").getValue().toString();

                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        }
        );
        Log.d("Debugging", msg);
        Log.d("Debugging", cntct);
        Log.d("Debugging", location);

     Location.setText(location);
     Contact.setText(cntct);
     Message.setText(msg);

    }
}
