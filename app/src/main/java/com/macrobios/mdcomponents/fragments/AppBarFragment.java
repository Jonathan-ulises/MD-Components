package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentAppBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentDialogBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class AppBarFragment extends Fragment {

    public static final String TAG = "App Bar";
    private static Component ourInstance;
    private FragmentAppBarBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_top_appbar);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppBarBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        binding.btnTop.setOnClickListener(v -> {
            AppBarTopFragment topFragment = new AppBarTopFragment();
            topFragment.show(transaction, FullScreenDialogFragment.TAG);
        });

        binding.btnBottom.setOnClickListener(v -> {
            AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
            bottomFragment.show(transaction, FullScreenDialogFragment.TAG);
        });

        // Inflate the layout for this fragment
        return view;
    }
}