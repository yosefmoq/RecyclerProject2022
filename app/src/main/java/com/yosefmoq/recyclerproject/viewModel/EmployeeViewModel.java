package com.yosefmoq.recyclerproject.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yosefmoq.recyclerproject.data.Employee;
import com.yosefmoq.recyclerproject.repositry.EmployeeRepositiry;

import java.util.ArrayList;
import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    EmployeeRepositiry employeeRepositiry;
    private LiveData<List<Employee>> employees;


    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepositiry = new EmployeeRepositiry(application);
        employees = employeeRepositiry.getEmployees();
    }

    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }

    public void insertEmployee(Employee employee){
        employeeRepositiry.insertEmployee(employee);
    }
    public void deleteAllEmployees(){
        employeeRepositiry.deleteAllEmployees();
    }
}
