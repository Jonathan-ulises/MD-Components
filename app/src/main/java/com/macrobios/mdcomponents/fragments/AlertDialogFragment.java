package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentDialogBinding;
import com.macrobios.mdcomponents.databinding.FragmentFloatingActionButtonBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class AlertDialogFragment extends Fragment {

    public static final String TAG = "Dialog";
    private static Component ourInstance;
    private FragmentDialogBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_dialog_mobile_alert);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //DialogInfo
        binding.btnDialogInfo.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show();
        });

        // Inflate the layout for this fragment
        return view;
    }
}