package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentAppBarBottomBinding;
import com.macrobios.mdcomponents.databinding.FragmentAppBarTopBinding;


public class AppBarBottomFragment extends DialogFragment {

    private FragmentAppBarBottomBinding binding;
    public static final String TAG = "AppBarBottomFragment";

    //Para el animation scale
    private boolean isCentered;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(DialogFragment.STYLE_NORMAL, R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppBarBottomBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //Para el animation scale
        binding.fab.setOnClickListener(v -> {
            if (isCentered){
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            } else {
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }

            isCentered = !isCentered;
        });

        binding.bottomAppBar.setOnMenuItemClickListener(item -> {
            int resMessage;
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;
            }

            Snackbar.make(binding.containerMain, resMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.fab).show();

            return true;
        });

        binding.bottomAppBar.setNavigationOnClickListener(v -> {
            Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.fab).show();
        });

        // Inflate the layout for this fragment
        return view;
    }
}