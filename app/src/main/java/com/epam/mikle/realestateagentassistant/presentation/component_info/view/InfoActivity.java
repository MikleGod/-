package com.epam.mikle.realestateagentassistant.presentation.component_info.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_info.presenter.InfoPresenterManager;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

public class InfoActivity extends AppCompatActivity implements InfoContract.View {


    InfoContract.Presenter presenter;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        layout = findViewById(R.id.info_parent);
        presenter = InfoPresenterManager.getPresenter(getIntent(), this);
        setView(presenter.getViewId());
        presenter.onCreate();
    }

    private void setView(int viewId) {
        View view = getLayoutInflater().inflate(viewId, null);
        layout.removeAllViews();
        layout.addView(view);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
