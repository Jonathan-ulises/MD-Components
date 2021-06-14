package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentModalNavigationDrawerBinding;

public class ModalNavigationDrawerFragment extends DialogFragment implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "Modal Navigation Drawer";
    private FragmentModalNavigationDrawerBinding binding;

    public ModalNavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalNavigationDrawerBinding.inflate(inflater, container, false);

        //Hcaer que el navigation drawer se muestre con el navigation icon
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.tolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), binding.drawerLayout, binding.tolbar,
                R.string.dialog_ok, R.string.dialog_cancel);

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.nmd.setNavigationItemSelectedListener(this);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel:
                //binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.action_app_bar_bottom:
                AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
                bottomFragment.show(getFragmentManager().beginTransaction(), AppBarBottomFragment.TAG);
                break;
            default:
                String msg = item.getTitle().toString();
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                break;
        }
        
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}