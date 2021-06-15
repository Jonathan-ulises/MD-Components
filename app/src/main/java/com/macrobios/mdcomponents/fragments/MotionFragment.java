package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentMotionBinding;
import com.macrobios.mdcomponents.databinding.FragmentSheetsBottomBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class MotionFragment extends Fragment {

    public static final String TAG = "Motion";
    private static Component ourInstance;
    private FragmentMotionBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_motion);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    public MotionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMotionBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}