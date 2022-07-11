package com.example.letsdoit;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class taskModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "status")
    private boolean status;

    @ColumnInfo(name = "task")
    private String task;

    public taskModel(int id, boolean status, String task) {
        this.id = id;
        this.status = status;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
