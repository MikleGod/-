package com.epam.mikle.realestateagentassistant.presentation.component_info.presenter;


import android.content.Intent;

import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

public class InfoPresenterManager {

    public static InfoContract.Presenter getPresenter(Intent intent, InfoContract.View view){
        InfoContract.Presenter answer = null;
        switch (intent.getIntExtra(InfoContract.SCREEN_TO_OPEN, InfoContract.DEFAULT_SCREEN_TO_OPEN)){
            case InfoContract.HISTORY_CALL:
                answer = new CompletedCallPresenter(view);
                break;
            case InfoContract.PLANS_CALL:
                answer = new PlanedCallPresenter(view);
                break;
            case InfoContract.HISTORY_MEETING:
                answer = new CompletedMeetingPresenter(view);
                break;
            case InfoContract.PLANS_MEETING:
                answer = new PlannedMeetingPresenter(view);
                break;
        }
        return answer;
    }


}
