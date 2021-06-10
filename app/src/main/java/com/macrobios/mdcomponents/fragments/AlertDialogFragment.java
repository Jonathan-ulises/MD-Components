package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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

        //Dialog Chooser
        binding.btnDialogChooser.setOnClickListener(v -> {
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.select_dialog_item);

            adapter.add("Opcion_1");
            adapter.add("Opcion_2");
            adapter.add("Opcion_3");

            new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.dialog_chooser)
                    .setAdapter(adapter, (dialog, which) ->
                            Toast.makeText(getActivity(), adapter.getItem(which), Toast.LENGTH_SHORT).show() )
                    .show();
        });

        //Dialog Confirm
        binding.btnDialogConfirm.setOnClickListener(v -> {

            //new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.dialog_confirm_title)
            //new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_Dialog).setTitle(R.string.dialog_confirm_title)
            new MaterialAlertDialogBuilder(getActivity(), R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                    .setTitle(R.string.dialog_confirm_title)
                    .setMessage(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_confirm, (dialog, which)
                            -> Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show() )
                    .setNegativeButton(R.string.dialog_cancel, null)
                    .show();
        });


        // Inflate the layout for this fragment
        return view;
    }
}