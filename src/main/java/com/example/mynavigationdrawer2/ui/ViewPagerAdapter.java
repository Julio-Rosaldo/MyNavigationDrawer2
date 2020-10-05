package com.example.mynavigationdrawer2.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mynavigationdrawer2.SubFragment1;
import com.example.mynavigationdrawer2.SubFragment2;
import com.example.mynavigationdrawer2.SubFragment3;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    String TABS[] = {"SubFrament1afdsa5f46s54dfg", "SubFragment2sg4s6546vfsd514b", "SubFragment3"};

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new SubFragment1();
                break;
            case 1:
                fragment = new SubFragment2();
                break;
            case 2:
                fragment = new SubFragment3();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return TABS.length;
    }

    public String returnItem(int i){
        return TABS[i];
    }
}
