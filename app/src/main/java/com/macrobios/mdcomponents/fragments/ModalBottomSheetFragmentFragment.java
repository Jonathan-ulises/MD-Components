package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentModalBottomSheetFragmentBinding;


public class ModalBottomSheetFragmentFragment extends BottomSheetDialogFragment
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "Modal Bottom Sheet";
    private FragmentModalBottomSheetFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalBottomSheetFragmentBinding.inflate(inflater, container, false);

        binding.nmdBottom.setNavigationItemSelectedListener(this);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel:
                break;
            case R.id.action_full_screen_dialog:
                FullScreenDialogFragment fragment = new FullScreenDialogFragment();
                fragment.show(getFragmentManager().beginTransaction(), FullScreenDialogFragment.TAG);
                break;
            default:
                String msg = item.getTitle().toString();
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                break;
        }

        dismiss();

        return true;
    }
}