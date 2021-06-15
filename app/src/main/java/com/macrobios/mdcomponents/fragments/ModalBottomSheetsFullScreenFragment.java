package com.macrobios.mdcomponents.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.android.material.transition.SlideDistanceProvider;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentModalBottomSheetFragmentBinding;
import com.macrobios.mdcomponents.databinding.FragmentModalBottomSheetsFullScreenBinding;

public class ModalBottomSheetsFullScreenFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Modal BottomSheets FullScreen";

    private BottomSheetBehavior mBottomSheetBehavior;
    private FragmentModalBottomSheetsFullScreenBinding binding;

    public ModalBottomSheetsFullScreenFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        //View view = View.inflate(getContext(), R.layout.fragment_modal_bottom_sheets_full_screen, null);
        binding = FragmentModalBottomSheetsFullScreenBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding.getRoot());


        binding.vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4);


        mBottomSheetBehavior = BottomSheetBehavior.from((View) binding.getRoot().getParent());
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull  View bottomSheet, int newState) {

                MaterialFadeThrough fadeThrough = new MaterialFadeThrough();
                fadeThrough.setSecondaryAnimatorProvider(new SlideDistanceProvider(Gravity.TOP));
                fadeThrough.setDuration(250L);

                TransitionManager.beginDelayedTransition(binding.containerBar, fadeThrough);


                int statusBarColor = ContextCompat.getColor(getActivity(), R.color.primaryVariant_color);

                if (BottomSheetBehavior.STATE_EXPANDED == newState){
                    //binding.llBar.setVisibility(View.GONE);
                    binding.tvBar.setVisibility(View.GONE);
                    binding.appbar.setVisibility(View.VISIBLE);
                    statusBarColor = ContextCompat.getColor(getActivity(), R.color.secundaryVariant_color);

                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState){
                    //binding.llBar.setVisibility(View.VISIBLE);
                    binding.appbar.setVisibility(View.GONE);
                    binding.tvBar.setVisibility(View.VISIBLE);

                }

                getActivity().getWindow().setStatusBarColor(statusBarColor);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        binding.btnCancel.setOnClickListener(v -> {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        });

        return bottomSheetDialog;
    }

}