package com.yosefmoq.recyclerproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yosefmoq.recyclerproject.R;
import com.yosefmoq.recyclerproject.data.Employee;
import com.yosefmoq.recyclerproject.databinding.ItemEmployeeBinding;
import com.yosefmoq.recyclerproject.listeners.EmployeeClickListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private Context context;
    private ArrayList<Employee> employees;
    private EmployeeClickListener employeeClickListener;

    public EmployeeAdapter(Context context, ArrayList<Employee> employees,EmployeeClickListener employeeClickListener) {
        this.context = context;
        this.employees = employees;
        this.employeeClickListener = employeeClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeViewHolder(ItemEmployeeBinding.inflate(LayoutInflater.from(context),parent,false));
    }



    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.itemEmployeeBinding.civEmployeeImage.setImageResource(employee.getImage());
        holder.itemEmployeeBinding.tvEmployeeName.setText(employee.getName());
        holder.itemEmployeeBinding.tvEmployeeEmail.setText(employee.getEmail());
        holder.itemEmployeeBinding.civEmployeeImage.setOnClickListener(view -> {
            employeeClickListener.onImageClickListener(position,employee);
        });
        holder.itemEmployeeBinding.getRoot().setOnClickListener(view -> {
            employeeClickListener.onItemClickListener(position,employee);
        });
        holder.itemEmployeeBinding.ivDelete.setOnClickListener((view)->{
            employees.remove(holder.getAdapterPosition());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{
        /*CircleImageView civEmployeeImage;
        TextView tvEmployeeName,tvEmployeeEmail;*/
        ItemEmployeeBinding itemEmployeeBinding;

        public EmployeeViewHolder(ItemEmployeeBinding itemEmployeeBinding) {
            super(itemEmployeeBinding.getRoot());
            this.itemEmployeeBinding = itemEmployeeBinding;
         /*   civEmployeeImage = itemView.findViewById(R.id.civEmployeeImage);
            tvEmployeeName   = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeEmail  = itemView.findViewById(R.id.tvEmployeeEmail);*/
        }
    }
}
