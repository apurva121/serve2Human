package com.example.apurva.servetohuman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
