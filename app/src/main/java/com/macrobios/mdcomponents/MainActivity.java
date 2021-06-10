package com.macrobios.mdcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.macrobios.mdcomponents.adapters.ComponentAdapter;
import com.macrobios.mdcomponents.databinding.ActivityMainBinding;
import com.macrobios.mdcomponents.fragments.BottomNavigationBarFragment;
import com.macrobios.mdcomponents.fragments.ButtonFragment;
import com.macrobios.mdcomponents.fragments.CardFragment;
import com.macrobios.mdcomponents.fragments.CheckBoxFragment;
import com.macrobios.mdcomponents.fragments.FloatingActionButtonFragment;
import com.macrobios.mdcomponents.fragments.MenuFragment;
import com.macrobios.mdcomponents.fragments.SnackBarFragment;
import com.macrobios.mdcomponents.fragments.TextFieldFragment;
import com.macrobios.mdcomponents.utils.Commons;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ComponentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rclRecycle.setAdapter(adapter);

        configAdapter();
        configRecycleView();

        adapter.setOnClickListener(component -> {
            Intent intent;
            if (component.getType() == Commons.SCROLL){
                intent = new Intent(this, ScrollActivity.class);
            } else {
                intent = new Intent(this, StaticActivity.class);
            }

            intent.putExtra(Commons.ARG_NAME, component.getName());
            startActivity(intent);
        });
    }

    private void configRecycleView() {
        binding.rclRecycle.setAdapter(adapter);
    }

    private void configAdapter() {
        adapter = new ComponentAdapter(new ArrayList<>());
        adapter.add(ButtonFragment.getInstance());
        adapter.add(BottomNavigationBarFragment.getInstance());
        adapter.add(SnackBarFragment.getInstance());
        adapter.add(TextFieldFragment.getInstance());
        adapter.add(FloatingActionButtonFragment.getInstance());
        adapter.add(CheckBoxFragment.getInstance());
        adapter.add(CardFragment.getInstance());
        adapter.add(MenuFragment.getInstance());
        adapter.reverse();
    }


}