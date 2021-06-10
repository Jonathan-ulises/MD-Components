package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentAppBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentAppBarTopBinding;


public class AppBarTopFragment extends DialogFragment {

    private FragmentAppBarTopBinding binding;
    public static final String TAG = "full_screen_dialog_fragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(DialogFragment.STYLE_NORMAL, R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppBarTopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.toolbar.setNavigationOnClickListener(v -> dismiss());
        // Inflate the layout for this fragment
        return view;
    }
}