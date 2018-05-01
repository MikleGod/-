package com.epam.mikle.realestateagentassistant.presentation.component_main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.PresenterManager;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "myLogs";


    ViewPager pager;
    MyFragmentPagerAdapter pagerAdapter;

    public static int getActiveBottomNavigationItem() {
        return activeBottomNavigationItem;
    }

    static int activeBottomNavigationItem = R.id.navigation_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                return false;
            }
        });
    }






}
