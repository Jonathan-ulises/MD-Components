package com.macrobios.mdcomponents.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
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


        binding.vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 2);


        mBottomSheetBehavior = BottomSheetBehavior.from((View) binding.getRoot().getParent());
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        return bottomSheetDialog;
    }

}