package com.example.letsdoit;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {taskModel.class}, version = 1)
public abstract class taskDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
    public static taskDatabase td;

    private static volatile taskDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //Singleton
    public static taskDatabase getInstance() {
        if (td == null) {
            td = new taskDatabase() {
                @Override
                public TaskDao taskDao() {
                    return null;
                }

                @NonNull
                @Override
                protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
                    return null;
                }

                @NonNull
                @Override
                protected InvalidationTracker createInvalidationTracker() {
                    return null;
                }

                @Override
                public void clearAllTables() {

                }
            };
        }

        return td;

    }



    static taskDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (taskDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            taskDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TaskDao dao = INSTANCE.taskDao();
                dao.deleteALlTask();


                dao.insertAll(new ArrayList<taskModel>());

            });
        }
    };
    public void createDatabase(Context context){
        taskDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                taskDatabase.class, "database").build();

    }



}
