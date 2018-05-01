package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;

import com.epam.mikle.realestateagentassistant.presentation.component_main.PageFragment;

/**
 * Created by Сергей on 01.05.2018.
 */

public class CallsHistoryFrPr extends BaseFragmentPresenter {
    protected CallsHistoryFrPr(PageFragment fragment) {
        super(fragment);
    }

    @Override
    public String getTitle() {
        return "History";
    }
}
