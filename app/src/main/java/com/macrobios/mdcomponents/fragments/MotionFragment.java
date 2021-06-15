package com.macrobios.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentMotionBinding;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMotionBinding.inflate(inflater, container, false);

        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setScrimColor(Color.TRANSPARENT);
        transform.setDuration(2500L);

        //Vista inicial Floating Action Buttom --->  Vista final ConstrainLayout(viewEnd)
        binding.viewStart.setOnClickListener(v -> {
            transform.setPathMotion(new MaterialArcMotion());
            transform.setStartView(binding.viewStart);
            transform.setEndView(binding.viewEnd);
            transform.addTarget(binding.viewEnd);
            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);
        });

        //Vista final ConstrainLayout(viewEnd) --->  Vista inicial Floating Action Buttom
        binding.btnCancel.setOnClickListener(v -> {
            transform.setStartView(binding.viewEnd);
            transform.setEndView(binding.viewStart);
            transform.addTarget(binding.viewStart);
            binding.viewEnd.setVisibility(View.GONE);
            binding.viewStart.setVisibility(View.VISIBLE);
            TransitionManager.beginDelayedTransition(binding.containerMain, transform);

        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }


}