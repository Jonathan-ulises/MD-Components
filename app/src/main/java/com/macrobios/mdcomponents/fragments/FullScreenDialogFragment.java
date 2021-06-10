package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentFullScreenDialogBinding;

public class FullScreenDialogFragment extends DialogFragment {

    public static final String TAG = "full_screen_dialog_fragment";

    private FragmentFullScreenDialogBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(DialogFragment.STYLE_NORMAL, R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.toolbar.setNavigationIcon(R.drawable.ic_close);
        binding.toolbar.setNavigationOnClickListener(v -> dismiss());
        binding.toolbar.setTitle(R.string.dialog_full_screen);

        binding.btnSave.setOnClickListener(v -> {
            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();
            dismiss();
        });

        // Inflate the layout for this fragment
        return view;
    }
}