package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentButtonBinding;
import com.macrobios.mdcomponents.databinding.FragmentTextFieldBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class TextFieldFragment extends Fragment {
    public static final String TAG = "Textfield";
    private static Component ourInstance;
    private FragmentTextFieldBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_textfields_outlined_active);
        ourInstance.setType(Commons.SCROLL);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTextFieldBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //Eventos de endIcon del textField
        binding.tilCapitalLetter.setEndIconOnClickListener(v -> {
            if(binding.etCapitalLetter.getText() != null){
                String contentSTR = binding.etCapitalLetter.getText().toString();
                binding.etCapitalLetter.setText(contentSTR.toUpperCase());
            }
        });

        binding.etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty() && Integer.valueOf(s.toString()) < 5){
                    binding.etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}