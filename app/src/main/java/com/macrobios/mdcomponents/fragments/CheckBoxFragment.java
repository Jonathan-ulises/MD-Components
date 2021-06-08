package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentButtonBinding;
import com.macrobios.mdcomponents.databinding.FragmentCheckBoxBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class CheckBoxFragment extends Fragment {

    public static final String TAG = "Checkbox";
    private static Component ourInstance;
    private FragmentCheckBoxBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_checkboxes);
        ourInstance.setType(Commons.SCROLL);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCheckBoxBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.cbEnable.setOnClickListener(V -> {
            String status = binding.cbEnable.isChecked() ? "Activo" : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
        });
        // Inflate the layout for this fragment
        return view;
    }
}