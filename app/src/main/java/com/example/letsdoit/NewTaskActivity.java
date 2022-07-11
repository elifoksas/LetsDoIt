package com.example.letsdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;

import com.example.letsdoit.databinding.ActivityNewTaskBinding;


public class NewTaskActivity extends AppCompatActivity {

    String newTask;
    private ActivityNewTaskBinding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //editText'e girilen yeni task.
        //newTask = binding.editText.getText().toString();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //MainActivity'e dönüş.
                Intent intent = new Intent(NewTaskActivity.this,MainActivity.class);

                String task = binding.editText.getText().toString();

                intent.putExtra("newTask",task);
                startActivity(intent);

            }
        });






    }



}










