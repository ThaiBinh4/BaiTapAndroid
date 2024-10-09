package com.example.apptaplayoutandbottomnavigation.homeTabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {
    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tap1Fragment();
            case 1: return new Tap2Fragment();
            case 2: return new Tap3Fragment();
            default: return new Tap3Fragment();
        }

    }

    public HomeViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Giới thiệu";
            case 1: return "Điểm";
            case 2: return "Ngành";
            default: return "Giới thiệu";

        }
    }
}
