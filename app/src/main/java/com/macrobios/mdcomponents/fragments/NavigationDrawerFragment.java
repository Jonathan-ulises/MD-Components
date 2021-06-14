package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentNavigationDrawerBinding;
import com.macrobios.mdcomponents.databinding.FragmentPickerBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class NavigationDrawerFragment extends Fragment {

    public static final String TAG = "Navigation Drawer";
    private static Component ourInstance;
    private FragmentNavigationDrawerBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_navigation_drawer);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNavigationDrawerBinding.inflate(inflater, container, false);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        binding.btnModal.setOnClickListener(v -> {
            ModalNavigationDrawerFragment modalFragment = new ModalNavigationDrawerFragment();
            modalFragment.show(transaction, ModalNavigationDrawerFragment.TAG);
        });

        binding.btnBottom.setOnClickListener(v -> {
            BottomNavigationDrawerFragment bottomFragment = new BottomNavigationDrawerFragment();
            bottomFragment.show(transaction, BottomNavigationDrawerFragment.TAG);
        });

        
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}