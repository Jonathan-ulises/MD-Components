package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentButtonBinding;
import com.macrobios.mdcomponents.databinding.FragmentSnackBarBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class SnackBarFragment extends Fragment {

    public static final String TAG = "Snackbar";
    private static Component ourInstance;
    private FragmentSnackBarBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_singleline_action);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSnackBarBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Snackbar.make(view, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", v -> getActivity().finish())
                .show();

        // Inflate the layout for this fragment
        return view;
    }
}