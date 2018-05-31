package com.epam.mikle.realestateagentassistant.presentation.contract;


import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.MyFragmentPagerAdapter;

public interface MainScreenContract {
    interface Presenter{
        void setPosition(int position);
        int getPosition();
        int getActiveBottomNavigationItem();
        android.view.View.OnClickListener getFabListener();
        ViewPager.OnPageChangeListener getOnPageChangeListener();
        BottomNavigationView.OnNavigationItemSelectedListener getOnNavigationItemSelectedListener();
        MyFragmentPagerAdapter getPagerAdapter();
    }
    interface View{
        FragmentManager getFM();
    }
}
