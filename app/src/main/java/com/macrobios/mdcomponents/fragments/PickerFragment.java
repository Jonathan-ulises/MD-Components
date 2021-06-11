package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentAppBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentPickerBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

import java.sql.Date;

public class PickerFragment extends Fragment {
    public static final String TAG = "Picker";
    private static Component ourInstance;
    private FragmentPickerBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_picker);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPickerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());

        binding.btnDialog.setOnClickListener(v -> {
            //Constructor de pickers
            builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
            MaterialDatePicker<?> picker = builder.build();

            picker.addOnPositiveButtonClickListener(selection -> {
                //Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG).show();
                Snackbar.make(binding.containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();
            });
            picker.addOnNegativeButtonClickListener(dialog -> {
                Snackbar.make(binding.containerMain, R.string.dialog_negative, Snackbar.LENGTH_LONG).show();
            });
            picker.addOnCancelListener(dialogInterface -> {
                Snackbar.make(binding.containerMain, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show();
            });

            picker.show(getFragmentManager(), picker.toString());
        });

        binding.btnullScreen.setOnClickListener(v -> {
            //builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
            builder.setTheme(R.style.FullScreenPicker);
            MaterialDatePicker<?> picker = builder.build();

            picker.addOnPositiveButtonClickListener(selection -> {
                Snackbar.make(binding.containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();
            });
            picker.addOnNegativeButtonClickListener(dialog -> {
                Snackbar.make(binding.containerMain, R.string.dialog_negative, Snackbar.LENGTH_LONG).show();
            });
            picker.addOnCancelListener(dialogInterface -> {
                Snackbar.make(binding.containerMain, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show();
            });

            picker.show(getFragmentManager(), picker.toString());
        });

        // Inflate the layout for this fragment
        return view;
    }
}