package com.yosefmoq.recyclerproject.repositry;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.yosefmoq.recyclerproject.dao.EmployeeDao;
import com.yosefmoq.recyclerproject.data.Employee;
import com.yosefmoq.recyclerproject.database.MyRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositiry {

    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> employees;

    public EmployeeRepositiry(Application application){
        MyRoomDatabase myRoomDatabase = MyRoomDatabase.getDatabase(application);
        employeeDao = myRoomDatabase.employeeDao();
        employees = employeeDao.getAllEmployees();
    }

    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }

    public void insertEmployee(Employee employee){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.insertEmployee(employee);

            }
        });
    }
    public void deleteAllEmployees(){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.deleteAll();
            }
        });
    }
}
