package com.epam.mikle.realestateagentassistant.presentation.component_main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.PresenterManager;

import java.util.ArrayList;
import java.util.List;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
    List<PageFragment> fragments = new ArrayList<>();{
        fragments.add(new PageFragment());
        fragments.add(new PageFragment());
        fragments.get(0).setPresenter(PresenterManager.getInstance().getPresenter(0));
        fragments.get(1).setPresenter(PresenterManager.getInstance().getPresenter(1));
    }


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public List<PageFragment> getFragments() {
        return fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
