package com.example.letsdoit;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.letsdoit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private taskDatabase db;
    taskAdapter adapter;
    ArrayList<taskModel> arrayList;

    private ActivityMainBinding binding;
    private taskDatabase taskDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.rcView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new taskAdapter(arrayList);





        recyclerView.setAdapter(adapter);

        //newTask activity'den gelen new task'i alıyoruz.
        Intent intent = getIntent();
        String newTask = intent.getStringExtra("newTask");

        arrayList.add(new taskModel(1,true,newTask));
        SaveData(arrayList);
        //arrayList.addAll(taskDao.taskDao().getAll());





       binding.addButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               //NewTask Activity'e geçiş.
               Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);

               startActivity(intent);

           }
       });




    }

    private void SaveData(ArrayList<taskModel> taskModels){
        taskDatabase.getDatabase(this);

    }
    private void GetData(){
        //verileri çekiyoruz.
        //taskDao= db.taskDao();

    }

}