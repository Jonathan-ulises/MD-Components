package com.macrobios.mdcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.macrobios.mdcomponents.adapters.ComponentAdapter;
import com.macrobios.mdcomponents.databinding.ActivityMainBinding;
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
                intent = new Intent(this, StaticActivity2.class);
            }

            intent.putExtra(Commons.ARG_NAME, component.getName());
            startActivity(intent);
        });
    }

    private void configRecycleView() {
        adapter = new ComponentAdapter(new ArrayList<>());
    }

    private void configAdapter() {
        binding.rclRecycle.setAdapter(adapter);
    }


}