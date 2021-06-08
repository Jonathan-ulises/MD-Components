package com.macrobios.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentBottomNavigationBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentButtonBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;


public class BottomNavigationBarFragment extends Fragment {

    public static final String TAG = "Bottom Navigation";
    private static Component ourInstance;
    private FragmentBottomNavigationBarBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_bottomnav_mobile_portrait);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomNavigationBarBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //---BADGE--
        binding.bottomNavigation.getOrCreateBadge(R.id.action_start);
        //binding.bottomNavigation.removeBadge(R.id.action_start);
        BadgeDrawable favoriteBadge = binding.bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);


        BadgeDrawable profileBadge = binding.bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(999);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);
        //---------


        return view;
    }
}