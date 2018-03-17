package com.practice.mnnit.recycler;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OneActivity extends AppCompatActivity {
EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        e1 = (EditText)findViewById(R.id.user1);
        b1=(Button)findViewById(R.id.);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            } SQLiteDatabase data = openOrCreateDatabase("wiissn",MODE_PRIVATE,null);
            data.execSQL("create table if not exists userinfo (name varchar, password varchar, email varchar, city varchar, phone varchar)");
            String check1 = "select * from userinfo where name='"+s1+"'";
            Cursor cursor1 = data.rawQuery(check1,null);
            if(cursor1.getCount()>0)
            {
                Toast.makeText(sign.this,"Username Registered",Toast.LENGTH_SHORT).show();
                flag = 0;
            }
        });

    }
}
