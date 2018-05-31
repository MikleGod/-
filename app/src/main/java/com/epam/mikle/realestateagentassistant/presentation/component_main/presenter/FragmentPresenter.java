package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;

import android.support.v7.widget.RecyclerView;

import com.epam.mikle.realestateagentassistant.presentation.component_main.view.PageFragment;


public interface FragmentPresenter {
    RecyclerView.Adapter getAdapter();
    String getTitle();
    PageFragment.RecyclerItemClickListener.OnItemClickListener getOnItemTouchListener();
    void onSet();
    void setFragment(PageFragment pageFragment);
    void onFabClicked();

    void onResume();
}
