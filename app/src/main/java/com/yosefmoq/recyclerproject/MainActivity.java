package com.yosefmoq.recyclerproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yosefmoq.recyclerproject.adapters.EmployeeAdapter;
import com.yosefmoq.recyclerproject.data.Employee;
import com.yosefmoq.recyclerproject.databinding.ActivityMainBinding;
import com.yosefmoq.recyclerproject.listeners.EmployeeClickListener;
import com.yosefmoq.recyclerproject.viewModel.EmployeeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmployeeClickListener {

    EmployeeAdapter employeeAdapter;
    ActivityMainBinding activityMainBinding;

    EmployeeViewModel employeeViewModel;
    ArrayList<Employee> employees = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater(),null,false);

        setContentView(activityMainBinding.getRoot());

        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
/*
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("yosef","yos.ail@outlook.com",R.drawable.employee));
        employees.add(new Employee("mohammed","mohammed@outlook.com",R.drawable.employee));
        employees.add(new Employee("Ali","Ali@outlook.com",R.drawable.employee));
        employees.add(new Employee("Ahmad","Ahmad@outlook.com",R.drawable.employee));
        employees.add(new Employee("AA","AA@outlook.com",R.drawable.employee));
*/

        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                MainActivity.this.employees.clear();
                MainActivity.this.employees.addAll(employees);
                employeeAdapter.notifyDataSetChanged();
            }
        });
        employeeAdapter = new EmployeeAdapter(MainActivity.this, employees,this);
        activityMainBinding.rvEmployees.setAdapter(employeeAdapter);


        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InsertEmployeeActivity.class));
            }
        });

    }

    @Override
    public void onItemClickListener(int position, Employee employee) {
        Log.v("ttt",employee.getName());
    }

    @Override
    public void onImageClickListener(int position, Employee employee) {
        Log.v("ttt","position:: "+position + " Employee Email "+employee.getEmail());
    }
}