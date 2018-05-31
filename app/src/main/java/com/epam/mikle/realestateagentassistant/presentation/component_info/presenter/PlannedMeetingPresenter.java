package com.epam.mikle.realestateagentassistant.presentation.component_info.presenter;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.dao.CompletedMeetingDao;
import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.model.dao.PlannedMeetingDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedMeeting;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

import java.util.ArrayList;
import java.util.List;

public class PlannedMeetingPresenter extends BaseInfoPresenter {

    EditText addressET;
    EditText squareET;
    EditText costET;
    EditText sqMCostET;
    Spinner clientAimSpinner;
    Button goButton;

    public PlannedMeetingPresenter(InfoContract.View view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        addressET = view.findViewById(R.id.address_edit_text);
        squareET = view.findViewById(R.id.square_edit_text);
        costET = view.findViewById(R.id.cost_edit_text);
        sqMCostET = view.findViewById(R.id.smc_edit_text);
        clientAimSpinner = view.findViewById(R.id.client_aim_sp);
        goButton = view.findViewById(R.id.complete_button);
        initViews();
        setListeners();
    }

    @Override
    protected void setViewInfo(BaseEntity entity) {
        PlannedMeeting meeting = (PlannedMeeting) entity;

        dateET.setText(meeting.getDate());
        nameET.setText(meeting.getClientName());
        phoneNumberET.setText(meeting.getClientPhoneNumber());
        addressET.setText(meeting.getAddress());
        notesET.setText(meeting.getNotes());
        costET.setText(meeting.getCost() + "");
        squareET.setText(meeting.getSquare() + "");
        sqMCostET.setText(meeting.getSquareMCost() + "");
    }

    @Override
    protected void setViewsEnabled(boolean isEnabled) {
        super.setViewsEnabled(isEnabled);
        addressET.setEnabled(isEnabled);
        costET.setEnabled(isEnabled);
        squareET.setEnabled(isEnabled);
        sqMCostET.setEnabled(isEnabled);
        clientAimSpinner.setEnabled(isEnabled);
        actionButton.requestFocus();
    }

    @Override
    protected boolean saveChangesInDb() {
        PlannedMeeting meeting = (PlannedMeeting) view.getIntent().getSerializableExtra(InfoContract.COMING_ENTITY);
        boolean answer = false;
        PlannedMeetingDao dao = DaoManager.getInstance().getPlannedMeetingDao();
        if (meeting != null){
            meeting = updateEntityFromETs(meeting);
            answer = dao.update(meeting);
        } else {
            meeting = updateEntityFromETs(new PlannedMeeting());
            answer = dao.insert(meeting);
        }
        return answer;
    }

    @Override
    protected List<String> getFieldsData() {
        List<String> list = new ArrayList<>();
        list.add(dateET.getText().toString());
        list.add(notesET.getText().toString());
        list.add(phoneNumberET.getText().toString());
        list.add(nameET.getText().toString());
        list.add(addressET.getText().toString());
        list.add(squareET.getText().toString());
        list.add(costET.getText().toString());
        list.add(squareET.getText().toString());
        return list;
    }

    private PlannedMeeting updateEntityFromETs(PlannedMeeting meeting) {
        meeting.setDate(dateET.getText().toString());
        meeting.setNotes(notesET.getText().toString());
        meeting.setClientPhoneNumber(phoneNumberET.getText().toString());
        meeting.setClientName(nameET.getText().toString());
        meeting.setAddress(addressET.getText().toString());
        meeting.setSquareMCost(Double.parseDouble(squareET.getText().toString()));
        meeting.setCost(Double.parseDouble(costET.getText().toString()));
        meeting.setSquare(Double.parseDouble(squareET.getText().toString()));
        return meeting;
    }

    @Override
    public int getViewId() {
        return R.layout.view_planned_meeting_info;
    }

    @Override
    public void setListeners() {
        setButtonListener();
        setCompleteButtonListener();
    }

    private void setCompleteButtonListener() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "Делаем завершенную встречу", Toast.LENGTH_LONG).show();
            }
        });
    }


}
