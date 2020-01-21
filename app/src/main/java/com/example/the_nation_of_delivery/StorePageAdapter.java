package com.example.the_nation_of_delivery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.the_nation_of_delivery.StoreFragments.*;


public class StorePageAdapter extends FragmentPagerAdapter {

    public StorePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return page1Fragment.newInstance();
            case 1:
                return page2Fragment.newInstance();
            case 2:
                return page3Fragment.newInstance();
            default:
                return null;
        }
    }

     private static  int PAGE_NUMBER = 3;

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "메뉴";
            case 1:
                return "정보";
            case 2:
                return "리뷰";
            default:
                return null;
        }
    }
}
