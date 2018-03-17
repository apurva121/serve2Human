package com.example.apurva.servetohuman;

/**
 * Created by Apurva on 3/17/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<country> arrayList=new ArrayList<>();
    Context context;

    MyAdapter(ArrayList<country> arrayList, Context context)
    {
        this.arrayList=arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        return new MyViewHolder((view));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int  position) {

        holder.c_name.setText(arrayList.get(position).getName());
        holder.c_name.setText(arrayList.get(position).getName());


        holder.c_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                if (arrayList.get(position).getName() == "GET INSTANT HELP"){
                    intent =  new Intent(context, OneActivity.class);
                } else if (arrayList.get(position).getName() == "JOIN AN INTIATIVE"){
                    intent =  new Intent(context, OneActivity.class);
                } else {
                    intent =  new Intent(context, OneActivity.class);
                }
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public  static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView c_name;

        public MyViewHolder(View itemView) {

            super(itemView);
            c_name=(TextView) itemView.findViewById(R.id.tpo_name);

        }
    }

    public void setFilter(ArrayList<country> newList)
    {
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }

}