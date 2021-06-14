package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.shape.MaterialShapeDrawable;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentBottomNavigationBarBinding;
import com.macrobios.mdcomponents.databinding.FragmentBottomNavigationDrawerBinding;
import com.macrobios.mdcomponents.utils.BottomAppBarCutCornersTopEdge;

public class BottomNavigationDrawerFragment extends DialogFragment {

    public static final String TAG = "Bottom Navigation Drawer";
    private FragmentBottomNavigationDrawerBinding binding;


    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomNavigationDrawerBinding.inflate(inflater, container, false);

        binding.include.bottomAppBar.setNavigationOnClickListener(v -> {
            ModalBottomSheetFragmentFragment fragment = new ModalBottomSheetFragmentFragment();
            fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFragmentFragment.TAG);
        });

        BottomAppBarCutCornersTopEdge topEdge
                = new BottomAppBarCutCornersTopEdge(
                binding.include.bottomAppBar.getFabCradleMargin(),
                binding.include.bottomAppBar.getFabCradleRoundedCornerRadius(),
                binding.include.bottomAppBar.getCradleVerticalOffset());

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable) binding.include.bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                        .toBuilder().setTopEdge(topEdge).build());


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}