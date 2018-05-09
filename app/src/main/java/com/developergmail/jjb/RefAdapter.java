package com.developergmail.jjb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import java.sql.Ref;
import java.util.ArrayList;

class RefAdapter extends RecyclerView.Adapter<RefAdapter.Viewholder> {
    
    ArrayList<Ref>Reflist;
    
    public RefAdapter(ArrayList<Ref> reflist) {
        this.Reflist=reflist;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.ref_list_row,parent);

        return new Viewholder(myview); 
        
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.textView1.setText(Reflist.get(position).getFirstname());
        holder.textView2.setText(Reflist.get(position).getLastname());

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
       
