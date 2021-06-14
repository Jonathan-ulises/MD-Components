package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentModalNavigationDrawerBinding;

public class ModalNavigationDrawerFragment extends DialogFragment {

    public static final String TAG = "Modal Navigation Drawer";
    private FragmentModalNavigationDrawerBinding binding;

    public ModalNavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalNavigationDrawerBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}