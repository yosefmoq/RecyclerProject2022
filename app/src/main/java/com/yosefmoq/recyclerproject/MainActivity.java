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
    EmployeeViewModel employeeViewModel;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater(),null,false);

        setContentView(activityMainBinding.getRoot());
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        ArrayList<Employee> emp = new ArrayList<>();

        /*
        employees.add(new Employee(1,"yosef","yos.ail@outlook.com",R.drawable.employee));
        employees.add(new Employee(2,"mohammed","mohammed@outlook.com",R.drawable.employee));
        employees.add(new Employee(3,"Ali","Ali@outlook.com",R.drawable.employee));
        employees.add(new Employee(4,"Ahmad","Ahmad@outlook.com",R.drawable.employee));
        employees.add(new Employee(5,"AA","AA@outlook.com",R.drawable.employee));
*/
        employeeAdapter = new EmployeeAdapter(MainActivity.this, emp,this);
        activityMainBinding.rvEmployees.setAdapter(employeeAdapter);

        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InsertEmployeeActivity.class));
            }
        });
        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
                    @Override
                    public void onChanged(List<Employee> employees) {
                        emp.clear();
                        emp.addAll(employees);
                        employeeAdapter.notifyDataSetChanged();

                    }
                }


        );

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