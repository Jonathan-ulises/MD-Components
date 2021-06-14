package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentBottomNavigationBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentBottomNavigationDrawerBinding;

public class BottomNavigationDrawerFragment extends DialogFragment {

    public static final String TAG = "Bottom Navigation Drawer";
    private FragmentBottomNavigationDrawerBinding binding;


    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomNavigationDrawerBinding.inflate(inflater, container, false);

        binding.include.bottomAppBar.setNavigationOnClickListener(v -> {
            ModalBottomSheetFragmentFragment fragment = new ModalBottomSheetFragmentFragment();
            fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFragmentFragment.TAG);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}