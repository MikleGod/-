package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.presentation.component_info.view.InfoActivity;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.RVAdapterHelper;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.FragmentPresenter;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

public abstract class BaseFragmentPresenter implements FragmentPresenter {
    protected PageFragment pageFragment;
    protected RVAdapterHelper adapter;

    protected BaseFragmentPresenter(PageFragment fragment){
        this.pageFragment = fragment;
    }

    @Override
    public void setFragment(PageFragment pageFragment) {
        this.pageFragment = pageFragment;
    }

    @Override
    public void onSet() {
        pageFragment.setAdapter(getAdapter());
    }

    @Override
    public PageFragment.RecyclerItemClickListener.OnItemClickListener getOnItemTouchListener() {
        return new PageFragment.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                BaseEntity entity = adapter.getEntityOn(position);
                Intent intent = new Intent(pageFragment.getContext(), InfoActivity.class);
                intent.putExtra(InfoContract.COMING_ENTITY, entity);
                intent.putExtra(InfoContract.SCREEN_TO_OPEN, getScreenIdToOpen());
                pageFragment.startActivity(intent);
            }
        };
    }

    protected abstract int getScreenIdToOpen();

    @Override
    public void onResume() {
        updateAdapter();
        updateRV();
    }

    protected abstract void updateAdapter();

    protected void updateRV(){
        pageFragment.updateRV();
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return (RecyclerView.Adapter)adapter;
    }

    @Override
    public void onFabClicked() {
        pageFragment.startActivity(
                new Intent(
                        pageFragment.getContext(),
                        InfoActivity.class
                ).putExtra(InfoContract.SCREEN_TO_OPEN, getScreenIdToOpen())
        );
    }
}
