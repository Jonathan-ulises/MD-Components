package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentCardBinding;
import com.macrobios.mdcomponents.databinding.FragmentCheckBoxBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class CardFragment extends Fragment {

    public static final String TAG = "Card";
    private static Component ourInstance;
    private FragmentCardBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_cards_template);
        ourInstance.setType(Commons.SCROLL);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop();

        Glide.with(this)
                .load("https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2020/04/ramen-pollo1920-960x540.jpg")
                .apply(options)
                .into(binding.imgCardLarge);

        //CHIP EVENTS
        binding.chpFirst.setOnClickListener(V -> {
            Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
        });

        binding.chpSecond.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.chpThird.setOnCloseIconClickListener(v -> {
            binding.chpThird.setVisibility(View.GONE);
        });

        // Inflate the layout for this fragment
        return view;
    }
}