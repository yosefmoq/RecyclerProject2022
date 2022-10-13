package com.yosefmoq.recyclerproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yosefmoq.recyclerproject.R;
import com.yosefmoq.recyclerproject.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {
    FragmentThirdBinding fragmentThirdBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmet
        fragmentThirdBinding = FragmentThirdBinding.inflate(inflater,container,false);

        return fragmentThirdBinding.getRoot();
    }
}