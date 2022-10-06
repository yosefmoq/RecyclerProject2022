package com.yosefmoq.recyclerproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yosefmoq.recyclerproject.dao.EmployeeDao;
import com.yosefmoq.recyclerproject.data.Employee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class},version = 1,exportSchema = true)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();


    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MyRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyRoomDatabase.class, "employee_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
