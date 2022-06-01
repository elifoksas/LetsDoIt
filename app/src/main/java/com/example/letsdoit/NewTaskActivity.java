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

    SQLiteDatabase database;


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

                intent.putExtra("newTask",newTask);
                startActivity(intent);

            }
        });






    }

    public void save(View view){

        String task = binding.editText.getText().toString();

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Tasks",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS tasks(task VARCHAR, status VARCHAR, id INTEGER PRIMARY KEY)");

            ContentValues values = new ContentValues();

            //values.put(task,);


            /*String sqlString = "INSERT INTO tasks(task, status) VALUES(?, ?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlString);
            sqLiteStatement.bindString(1,task);
            sqLiteStatement.bindString(2,stat);



            sqLiteStatement.execute();*/

        } catch (Exception e){

            e.printStackTrace();
        }

        //MainActivity'e dönüş.
        Intent intent = new Intent(NewTaskActivity.this,MainActivity.class);

        intent.putExtra("newTask",newTask);
        startActivity(intent);





    }

}










