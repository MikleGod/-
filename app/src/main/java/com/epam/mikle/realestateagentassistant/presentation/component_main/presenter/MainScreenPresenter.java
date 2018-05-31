package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.MyFragmentPagerAdapter;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.MainActivity;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.contract.MainScreenContract;

public class MainScreenPresenter implements MainScreenContract.Presenter {

    private int activeBottomNavigationItem = R.id.navigation_home;
    private int position = 0;
    private MainScreenContract.View view;
    private MyFragmentPagerAdapter pagerAdapter;



    public MainScreenPresenter(MainScreenContract.View view) {
        this.view = view;
    }

    public int getActiveBottomNavigationItem() {
        return activeBottomNavigationItem;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public View.OnClickListener getFabListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PresenterManager.getInstance().getPresenter(position).onFabClicked();
            }
        };
    }

    @Override
    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MainActivity.getPresenter().setPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    @Override
    public BottomNavigationView.OnNavigationItemSelectedListener getOnNavigationItemSelectedListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_dashboard:
                        activeBottomNavigationItem = R.id.navigation_dashboard;
                        break;
                    case R.id.navigation_home:
                        activeBottomNavigationItem = R.id.navigation_home;
                        break;
                }
                int counter = 0;
                for (PageFragment pageFragment : pagerAdapter.getFragments()) {
                    pageFragment.setPresenter(PresenterManager.getInstance().getPresenter(counter++));
                }
                return true;
            }
        };
    }

    @Override
    public MyFragmentPagerAdapter getPagerAdapter() {
        this.pagerAdapter = new MyFragmentPagerAdapter(view.getFM());
        return pagerAdapter;
    }
}
