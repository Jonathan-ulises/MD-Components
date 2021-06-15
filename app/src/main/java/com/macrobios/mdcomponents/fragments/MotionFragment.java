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
import com.google.android.material.transition.MaterialSharedAxis;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentMotionBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class MotionFragment extends Fragment {

    public static final String TAG = "Motion";
    private static Component ourInstance;
    private FragmentMotionBinding binding;
    MaterialContainerTransform transform = new MaterialContainerTransform();
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


        binding.buttonLayout.btnCustom.setText(R.string.motion_button_next);


        //---------------------CONTENT TRANSFORM PATTERN-------------------------------
        //Vista inicial Floating Action Buttom --->  Vista final ConstrainLayout(viewEnd)
        binding.viewStart.setOnClickListener(v -> {
            transform = new MaterialContainerTransform();
            transform.setScrimColor(Color.TRANSPARENT);
            transform.setDuration(500L);


            transform.setPathMotion(new MaterialArcMotion());
            transform.setStartView(binding.viewStart);
            transform.setEndView(binding.viewEnd);
            transform.addTarget(binding.viewEnd);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);

            transform = null;
        });

        //Vista final ConstrainLayout(viewEnd) --->  Vista inicial Floating Action Buttom
        binding.btnCancel.setOnClickListener(v -> {
            transform = new MaterialContainerTransform();
            transform.setScrimColor(Color.TRANSPARENT);
            transform.setDuration(500L);

            transform.setStartView(binding.viewEnd);
            transform.setEndView(binding.viewStart);
            transform.addTarget(binding.viewStart);

            binding.viewEnd.setVisibility(View.GONE);
            binding.viewStart.setVisibility(View.VISIBLE);
            TransitionManager.beginDelayedTransition(binding.containerMain, transform);

            transform = null;

        });
        //---------------------CONTENT TRANSFORM PATTERN-------------------------------


        //-------------------------SHARE AXIS PATTERN----------------------------------
        binding.buttonLayout.btnCustom.setOnClickListener(v -> {
            //Pareamtros: X el eje de la transition, forware true si se desplaza hacia adelante
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            sharedAxis.setDuration(1500L);

            //Parametros: viewEnd es el contenedor
            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);
            binding.viewOut.setVisibility(View.GONE);
            binding.viewIn.setVisibility(View.VISIBLE);
        });

        binding.btnBack.setOnClickListener(v -> {
            //Pareamtros: X el eje de la transition, forware true si se desplaza hacia adelante
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, false);
            sharedAxis.setDuration(1500L);
            
            //Parametros: viewEnd es el contenedor
            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);
            binding.viewIn.setVisibility(View.GONE);
            binding.viewOut.setVisibility(View.VISIBLE);
        });
        //-------------------------SHARE AXIS PATTERN----------------------------------
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


}