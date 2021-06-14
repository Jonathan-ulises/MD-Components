package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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
    private boolean mIsExpanded;

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
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mIsExpanded = true;
                        binding.include.btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_expand_more));
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mIsExpanded = false;
                        binding.include.btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_expand_less));
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull  View bottomSheet, float slideOffset) {

            }
        });

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


        binding.include.btnResize.setOnClickListener(v -> {
            if(mIsExpanded){
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });


        binding.btnModal.setOnClickListener(v -> {
            ModalBottomSheetsFullScreenFragment fragment = new ModalBottomSheetsFullScreenFragment();
            fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetsFullScreenFragment.TAG);
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}