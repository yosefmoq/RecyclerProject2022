package com.yosefmoq.recyclerproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yosefmoq.recyclerproject.R;
import com.yosefmoq.recyclerproject.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    FragmentSecondBinding fragmentSecondBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSecondBinding = FragmentSecondBinding.inflate(inflater,container,false);
        return fragmentSecondBinding.getRoot();
    }
}