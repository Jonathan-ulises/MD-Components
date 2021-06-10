package com.macrobios.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import com.macrobios.mdcomponents.R;
import com.macrobios.mdcomponents.databinding.FragmentMenuBinding;
import com.macrobios.mdcomponents.utils.Commons;
import com.macrobios.mdcomponents.utils.Component;

public class MenuFragment extends Fragment {

    public static final String TAG = "Menu";
    private static Component ourInstance;
    private FragmentMenuBinding binding;

    public static Component getInstance(){
        ourInstance = new Component();
        ourInstance.setName(TAG);
        ourInstance.setFotoRes(R.drawable.img_menu_width_min);
        ourInstance.setType(Commons.STATIC);
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //MENU PÓPUP EN BOTON
        binding.btnMenuPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });

        //DROPBOX AUTOCOMPLETE
        String[] course = new String[]{
                "Experto en firebase para android +MVP Curso completo +30Hrs", "" +
                "Material Desing/Theming profesional para android",
                "Android: fundamentos apps de calidad",
                "Kotlin 2020"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_menu_dropdown, course);

        binding.actvCourses.setAdapter(adapter);



        // Inflate the layout for this fragment
        return view;
    }
}