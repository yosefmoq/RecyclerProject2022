package com.yosefmoq.recyclerproject.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.yosefmoq.recyclerproject.data.Employee;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployee(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();

    @Query("SELECT * FROM employee")
    LiveData<List<Employee>> getAllEmployees();

}
