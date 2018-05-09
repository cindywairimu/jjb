package com.developergmail.jjb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Ref;
import java.util.ArrayList;

class RefAdapter extends RecyclerView.Adapter {
    
    ArrayList<Ref>Reflist;
    
    public RefAdapter(ArrayList<Ref> reflist, Referees_List referees_list) {
        this.Reflist=Reflist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.ref_list_row,parent,));

        return new ViewHolder(myview); 
        
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int i;
        i=0;
        holder.textView1.setText(Reflist.get(i).getFirstname());
        holder.textView2.setText(Reflist.get(i).getLastname());
        

    }

    @Override
    public int getItemCount() {
        return Reflist.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;

        public Viewholder(View itemView) {
            
            
            super(itemView);
            textView1=(TextView)itemView.findViewById(R.id.firstname);
            textView2=(TextView)itemView.findViewById(R.id.lastname);
        }
    }}
       
