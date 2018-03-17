package com.practice.mnnit.recycler;


import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    String[] c_name={"GET INSTANT HELP","ADD AN INTIATIVE","JOIN AN INTIATIVE","ADD NEED PRONE AREAS","FUND AN INTIATIVE","CONNECT WITH VOLUNTEER"};


    Toolbar toolbar;
    RecyclerView recyclerView;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<country> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView =(RecyclerView)findViewById(R.id.Recycler);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DivideItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);


        for(int i=0;i<5;i++)
        {
            arrayList.add(new country(c_name[i]));


        }
        adapter=new MyAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return  true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<country> newList=new ArrayList<>();
        for(country country1 : arrayList)
        {
            String name=country1.getName().toLowerCase();
            if(name.contains(newText))
            {
newList.add(country1);
            }

        }
        adapter.setFilter(newList);
        return true;
    }
}
