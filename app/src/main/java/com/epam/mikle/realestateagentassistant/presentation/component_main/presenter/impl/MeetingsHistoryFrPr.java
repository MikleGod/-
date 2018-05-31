package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.BaseFragmentPresenter;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.MeetingsHistoryAdapter;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

public class MeetingsHistoryFrPr extends BaseFragmentPresenter {
    public MeetingsHistoryFrPr(PageFragment fragment) {
        super(fragment);
        adapter = new MeetingsHistoryAdapter(DaoManager.getInstance().getCompletedMeetingDao().findAll());
    }


    @Override
    public String getTitle() {
        return "History";
    }



    @Override
    protected int getScreenIdToOpen() {
        return InfoContract.HISTORY_MEETING;
    }

    @Override
    protected void updateAdapter() {

    }
}
