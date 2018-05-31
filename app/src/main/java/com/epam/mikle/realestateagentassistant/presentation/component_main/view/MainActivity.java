package com.epam.mikle.realestateagentassistant.presentation.component_main.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.MainScreenPresenter;
import com.epam.mikle.realestateagentassistant.presentation.contract.MainScreenContract;


public class MainActivity extends AppCompatActivity implements MainScreenContract.View{

    static final String TAG = "myLogs";

    static MainScreenContract.Presenter presenter;

    ViewPager pager;
    FloatingActionButton fab;
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initViews();
        setListeners();
    }

    public static MainScreenContract.Presenter getPresenter() {
        return presenter;
    }

    private void initPresenter(){
        presenter = new MainScreenPresenter(this);
    }

    private void initViews(){
        pager = findViewById(R.id.pager);
        fab = findViewById(R.id.fab);
        bnv = findViewById(R.id.bottom_navigation);
        pager.setAdapter(presenter.getPagerAdapter());
    }

    private void setListeners(){
        fab.setOnClickListener(presenter.getFabListener());
        pager.addOnPageChangeListener(presenter.getOnPageChangeListener());
        bnv.setOnNavigationItemSelectedListener(presenter.getOnNavigationItemSelectedListener());
    }


    @Override
    public FragmentManager getFM() {
        return getSupportFragmentManager();
    }
}
