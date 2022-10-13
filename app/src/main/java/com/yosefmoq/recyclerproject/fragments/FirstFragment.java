package com.yosefmoq.recyclerproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yosefmoq.recyclerproject.R;
import com.yosefmoq.recyclerproject.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {
    FragmentFirstBinding fragmentFirstBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFirstBinding = FragmentFirstBinding.inflate(inflater,container,false);
        return fragmentFirstBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}