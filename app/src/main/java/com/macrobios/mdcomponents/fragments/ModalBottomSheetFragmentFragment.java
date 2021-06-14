package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentModalBottomSheetFragmentBinding;


public class ModalBottomSheetFragmentFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Modal Bottom Sheet";
    private FragmentModalBottomSheetFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalBottomSheetFragmentBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}