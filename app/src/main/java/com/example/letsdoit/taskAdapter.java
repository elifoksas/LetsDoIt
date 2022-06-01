package com.example.letsdoit;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class taskAdapter extends RecyclerView.Adapter<taskAdapter.taskViewHolder> {



    ArrayList<taskModel> arrayList;

    public taskAdapter(ArrayList<taskModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public taskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new taskViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item , parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull taskViewHolder holder, int position) {

        taskModel item = arrayList.get(position);
        holder.task.setChecked(item.isStatus());
        holder.task.setText(item.getTask());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class taskViewHolder extends RecyclerView.ViewHolder{

        CheckBox task;

        taskViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }

    }
}
