package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.presentation.component_info.view.InfoActivity;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.CallsHistoryAdapter;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;


public class CallsHistoryFrPr extends BaseFragmentPresenter {

    public CallsHistoryFrPr(PageFragment fragment) {
        super(fragment);
        adapter = new CallsHistoryAdapter(DaoManager.getInstance().getCompletedCallDao().findAll());
    }

    @Override
    protected int getScreenIdToOpen() {
        return InfoContract.HISTORY_CALL;
    }

    @Override
    protected void updateAdapter() {

    }


    @Override
    public String getTitle() {
        return "History";
    }

}
