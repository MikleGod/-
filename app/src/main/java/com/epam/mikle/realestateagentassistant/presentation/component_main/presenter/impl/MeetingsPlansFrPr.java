package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.BaseFragmentPresenter;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.MeetingPlansAdapter;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;


public class MeetingsPlansFrPr extends BaseFragmentPresenter {
    public MeetingsPlansFrPr(PageFragment fragment) {
        super(fragment);
        adapter = new MeetingPlansAdapter(DaoManager.getInstance().getPlannedMeetingDao().findAll());
    }


    @Override
    public String getTitle() {
        return "Plans";
    }


    @Override
    protected int getScreenIdToOpen() {
        return InfoContract.PLANS_MEETING;
    }

    @Override
    protected void updateAdapter() {
        ((MeetingPlansAdapter) adapter).setMeetings(DaoManager.getInstance().getPlannedMeetingDao().findAll());
    }

}