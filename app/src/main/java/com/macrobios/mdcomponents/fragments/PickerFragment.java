package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentAppBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentPickerBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

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

        binding.btnDialog.setOnClickListener(v -> {
            //Constructor de pickers
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
            builder.setTitleText(R.string.picker_title);
            builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
            MaterialDatePicker<?> picker = builder.build();
            picker.show(getFragmentManager(), picker.toString());
        });

        // Inflate the layout for this fragment
        return view;
    }
}