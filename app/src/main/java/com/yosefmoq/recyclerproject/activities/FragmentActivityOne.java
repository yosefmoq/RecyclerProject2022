package com.yosefmoq.recyclerproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yosefmoq.recyclerproject.R;
import com.yosefmoq.recyclerproject.databinding.ActivityFragmentOneBinding;
import com.yosefmoq.recyclerproject.fragments.FirstFragment;
import com.yosefmoq.recyclerproject.fragments.SecondFragment;
import com.yosefmoq.recyclerproject.fragments.ThirdFragment;

public class FragmentActivityOne extends AppCompatActivity {

    ActivityFragmentOneBinding activityFragmentOneBinding;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFragmentOneBinding = ActivityFragmentOneBinding.inflate(getLayoutInflater(),null,false);
        setContentView(activityFragmentOneBinding.getRoot());
        fragmentManager = getSupportFragmentManager();



        activityFragmentOneBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,new FirstFragment()).commit();
            }
        });
        activityFragmentOneBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,new SecondFragment()).commit();

            }
        });
        activityFragmentOneBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,new ThirdFragment()).commit();

            }
        });
    }
}