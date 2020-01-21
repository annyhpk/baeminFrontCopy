package com.example.the_nation_of_delivery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.the_nation_of_delivery.Fragments.*;

public class CategoryPageAdapter extends FragmentPagerAdapter {

    public CategoryPageAdapter(FragmentManager fm) {
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
            case 3:
                return page4Fragment.newInstance();
            case 4:
                return page5Fragment.newInstance();
            case 5:
                return page6Fragment.newInstance();
            case 6:
                return page7Fragment.newInstance();
            case 7:
                return page8Fragment.newInstance();
            case 8:
                return page9Fragment.newInstance();
            case 9:
                return page10Fragment.newInstance();
            case 10:
                return page11Fragment.newInstance();
            case 11:
                return page12Fragment.newInstance();
            case 12:
                return page13Fragment.newInstance();
            default:
                return null;
        }
    }

     private static  int PAGE_NUMBER = 13;

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "한식";
            case 1:
                return "분식";
            case 2:
                return "카페·디저트";
            case 3:
                return "돈가스·회·일식";
            case 4:
                return "치킨";
            case 5:
                return "피자";
            case 6:
                return "중국집";
            case 7:
                return "족발·보쌈";
            case 8:
                return "야식";
            case 9:
                return "찜·탕";
            case 10:
                return "도시락";
            case 11:
                return "패스트푸드";
            case 12:
                return "프랜차이즈";
            default:
                return null;
        }
    }
}
