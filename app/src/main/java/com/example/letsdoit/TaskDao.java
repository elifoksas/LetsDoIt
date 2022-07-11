package com.example.letsdoit;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM taskModel")
    List<taskModel> getAll();

    @Insert
    void insertAll(List<taskModel> task);

    @Query("DELETE FROM taskModel")
    void deleteALlTask();



}
