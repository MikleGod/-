package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl;


import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.CallPlansAdapter;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;


public class CallsPlansFrPr extends BaseFragmentPresenter  {
    public CallsPlansFrPr(PageFragment fragment) {
        super(fragment);
        adapter = new CallPlansAdapter(DaoManager.getInstance().getPlannedCallDao().findAll());
    }

    @Override
    public String getTitle() {
        return "Plans";
    }

    @Override
    protected int getScreenIdToOpen() {
        return InfoContract.PLANS_CALL;
    }

    @Override
    protected void updateAdapter() {
        ((CallPlansAdapter) adapter).setCalls(DaoManager.getInstance().getPlannedCallDao().findAll());
    }

}
