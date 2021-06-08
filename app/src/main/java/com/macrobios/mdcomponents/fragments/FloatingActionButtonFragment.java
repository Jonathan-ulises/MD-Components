package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentButtonBinding;
import com.macrobios.mdcomponents.databinding.FragmentFloatingActionButtonBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class FloatingActionButtonFragment extends Fragment {
    public static final String TAG = "Floating Action Button";
    private static Component ourInstance;
    private FragmentFloatingActionButtonBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_fab_default);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFloatingActionButtonBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.fabDefult.setOnClickListener(v -> {
            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();
        });

        binding.fabLegacy.setOnClickListener(v -> {
            binding.fabLegacy.setVisibility(View.GONE);
            binding.tvLegacy.setVisibility(View.GONE);
        });
        // Inflate the layout for this fragment
        return view;
    }
}