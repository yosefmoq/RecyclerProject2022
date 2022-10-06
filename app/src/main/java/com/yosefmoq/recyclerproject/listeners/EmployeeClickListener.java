package com.yosefmoq.recyclerproject.listeners;

import com.yosefmoq.recyclerproject.data.Employee;

public interface EmployeeClickListener {
    void onItemClickListener(int position, Employee employee);
    void onImageClickListener(int position , Employee employee);
}
