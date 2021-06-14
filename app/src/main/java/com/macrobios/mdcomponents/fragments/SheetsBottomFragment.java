package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentNavigationDrawerBinding;
import com.macrobios.mdcomponents.databinding.FragmentSheetsBottomBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class SheetsBottomFragment extends Fragment {

    public static final String TAG = "Sheets Bottom";
    private static Component ourInstance;
    private FragmentSheetsBottomBinding binding;

    private BottomSheetBehavior mBottomSheetBehavior;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_sheets_bottom);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    public SheetsBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSheetsBottomBinding.inflate(inflater, container, false);

        mBottomSheetBehavior = BottomSheetBehavior.from(binding.include.bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        binding.btnStandar.setOnLongClickListener(v -> {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            return true;
        });


        binding.btnStandar.setOnClickListener(v -> {
            if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}