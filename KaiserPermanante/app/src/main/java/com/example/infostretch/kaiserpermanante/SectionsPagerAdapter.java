package com.example.infostretch.kaiserpermanante;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by infostretch on 12/23/17.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TabCycleCount tab1 = new TabCycleCount();
                return tab1;
            case 1:
                TabPhysicalInventory tab2 = new TabPhysicalInventory();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
