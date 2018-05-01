package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;

import com.epam.mikle.realestateagentassistant.presentation.component_main.PageFragment;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.RVAdapter;

/**
 * Created by Сергей on 01.05.2018.
 */

public interface FragmentPresenter {
    RVAdapter getAdapter();
    String getTitle();
    void onSet();
    void setFragment(PageFragment pageFragment);
}
