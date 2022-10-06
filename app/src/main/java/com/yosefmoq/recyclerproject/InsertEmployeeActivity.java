package com.yosefmoq.recyclerproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.yosefmoq.recyclerproject.data.Employee;
import com.yosefmoq.recyclerproject.databinding.ActivityInsertEmployeeBinding;
import com.yosefmoq.recyclerproject.viewModel.EmployeeViewModel;

public class InsertEmployeeActivity extends AppCompatActivity {

    ActivityInsertEmployeeBinding activityInsertEmployeeBinding;
    EmployeeViewModel employeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInsertEmployeeBinding = ActivityInsertEmployeeBinding.inflate(getLayoutInflater(),null,false);
        setContentView(activityInsertEmployeeBinding.getRoot());

        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        activityInsertEmployeeBinding.btnInsert.setOnClickListener(v->{
            String name = activityInsertEmployeeBinding.etEmpName.getText().toString();
            String email = activityInsertEmployeeBinding.etEmpEmail.getText().toString();

            Employee employee = new Employee(name,email,R.drawable.employee);
            employeeViewModel.insertEmployee(employee);

            activityInsertEmployeeBinding.etEmpName.setText("");
            activityInsertEmployeeBinding.etEmpEmail.setText("");
        });

    }
}