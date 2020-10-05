package com.example.mynavigationdrawer2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mynavigationdrawer2.ui.ViewPagerAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyTabbedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyTabbedFragment extends Fragment {

    // Agregar al framelayout del fragment un ViewPager2 y ponerle como id "pager"
    // Generar la clase ViewPagerAdapter
    // Generar la funcion "onViewCreated" para establecer el adaptador dentro del pager del fragmento
    // Generar la funcion TabLayoutMediator para enlazar el tab_layout con los fragments

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyTabbedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyTabbedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyTabbedFragment newInstance(String param1, String param2) {
        MyTabbedFragment fragment = new MyTabbedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_tabbed, container, false);
    }

    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(viewPagerAdapter.returnItem(position));
                        tab.setIcon(R.drawable.ic_menu_camera);
                        // Crea una notificacion o viso en el boton
                        /*
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(Color.GREEN);
                        badgeDrawable.setNumber(10);
                        badgeDrawable.setVisible(true);
                        */
                    }
                }
        ).attach();
    }
}