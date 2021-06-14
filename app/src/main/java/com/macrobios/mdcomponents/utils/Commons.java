package com.macrobios.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.macrobios.mdcomponents.fragments.*;

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
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CheckBoxFragment.TAG:
                fragment = new CheckBoxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
            case AlertDialogFragment.TAG:
                fragment = new AlertDialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
            case PickerFragment.TAG:
                fragment = new PickerFragment();
                break;
            case NavigationDrawerFragment.TAG:
                fragment = new NavigationDrawerFragment();
                break;
            case SheetsBottomFragment.TAG:
                fragment = new SheetsBottomFragment();
                break;
        }

        return fragment;
    }
}
