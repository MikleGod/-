package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;

import com.epam.mikle.realestateagentassistant.presentation.component_main.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.RVAdapter;

/**
 * Created by Сергей on 01.05.2018.
 */

public abstract class BaseFragmentPresenter implements FragmentPresenter {
    protected PageFragment pageFragment;
    protected RVAdapter adapter;
    protected BaseFragmentPresenter(PageFragment fragment){
        this.pageFragment = fragment;
    }

    @Override
    public void setFragment(PageFragment pageFragment) {
        this.pageFragment = pageFragment;
    }

    @Override
    public RVAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onSet() {

    }
}
