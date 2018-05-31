package com.epam.mikle.realestateagentassistant.presentation.component_main.presenter;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.CallsHistoryFrPr;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.CallsPlansFrPr;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.MeetingsHistoryFrPr;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.impl.MeetingsPlansFrPr;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private List<FragmentPresenter> presenters;{
        presenters = new ArrayList<>();
        presenters.add(new CallsHistoryFrPr(null));
        presenters.add(new CallsPlansFrPr(null));
        presenters.add(new MeetingsHistoryFrPr(null));
        presenters.add(new MeetingsPlansFrPr(null));
    }

    public static PresenterManager getInstance() {
        return ourInstance;
    }

    private PresenterManager() {
    }

    public FragmentPresenter getPresenter(int position){
        FragmentPresenter answer = null;
        switch (MainActivity.getPresenter().getActiveBottomNavigationItem()){
            case R.id.navigation_dashboard:
                answer = getMeetingsPresenter(position);
                break;
            case R.id.navigation_home:
                answer = getCallsPresenter(position);
                break;
        }
        return answer;
    }

    private FragmentPresenter getCallsPresenter(int position) {
        FragmentPresenter answer = null;
        switch (position){
            case 0:
                answer = presenters.get(0);
                break;
            case 1:
                answer = presenters.get(1);
                break;
        }
        return answer;
    }

    private FragmentPresenter getMeetingsPresenter(int position) {
        FragmentPresenter answer = null;
        switch (position){
            case 0:
                answer = presenters.get(2);
                break;
            case 1:
                answer = presenters.get(3);
                break;
        }
        return answer;
    }
}
