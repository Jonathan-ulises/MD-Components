package com.macrobios.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.macrobios.mdcomponents.fragments.ButtonFragment;
import com.macrobios.mdcomponents.fragments.BottomNavigationBarFragment;
import com.macrobios.mdcomponents.fragments.SnackBarFragment;

public class Commons {
    //Paso de parametros en la MainActivity y Scroll/static Activity
    public static final String ARG_NAME = "name";

    //Type de nuestro objeto component
    public static final int SCROLL = 0;
    public static final int STATIC = 1;

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRest) {
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .add(contentRest, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment) {
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
        }

        return fragment;
    }
}
