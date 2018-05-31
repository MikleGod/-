package com.epam.mikle.realestateagentassistant.presentation.contract;


import android.content.Context;
import android.content.Intent;
import android.view.View;

public interface InfoContract {
    String SCREEN_TO_OPEN = "SCREEN_TO_OPEN";
    String COMING_ENTITY = "COMING_ENTITY";
    int DEFAULT_SCREEN_TO_OPEN = 0;
    int HISTORY_CALL = 1;
    int HISTORY_MEETING = 2;
    int PLANS_CALL = 3;
    int PLANS_MEETING = 4;

    interface View{
        <T extends android.view.View> T findViewById(int id);
        Context getContext();

        Intent getIntent();
    }
    interface Presenter{
        void onCreate();
        int getViewId();
        void setListeners();
    }
}
