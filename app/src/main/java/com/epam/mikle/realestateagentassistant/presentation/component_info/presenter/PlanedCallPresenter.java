package com.epam.mikle.realestateagentassistant.presentation.component_info.presenter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.dao.CompletedCallDao;
import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.model.dao.PlannedCallDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedCall;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

import java.util.ArrayList;
import java.util.List;


public class PlanedCallPresenter extends BaseInfoPresenter{

    private ImageButton imageButton;
    private EditText callNotesET;

    public PlanedCallPresenter(InfoContract.View view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        imageButton = view.findViewById(R.id.phone_but);
        callNotesET = view.findViewById(R.id.notes_edit_text);
        initViews();
        setListeners();
    }

    @Override
    protected void setViewInfo(BaseEntity entity) {
        PlannedCall call = (PlannedCall) entity;
        callNotesET.setText(call.getNotes());
        nameET.setText(call.getClientName());
        phoneNumberET.setText(call.getClientPhoneNumber());
        dateET.setText(call.getDate());
    }

    @Override
    protected void setViewsEnabled(boolean enabled) {
        dateET.setEnabled(enabled);
        nameET.setEnabled(enabled);
        phoneNumberET.setEnabled(enabled);
        callNotesET.setEnabled(enabled);
    }

    @Override
    protected boolean saveChangesInDb() {
        PlannedCall call = (PlannedCall) view.getIntent().getSerializableExtra(InfoContract.COMING_ENTITY);
        boolean answer = false;
        PlannedCallDao dao = DaoManager.getInstance().getPlannedCallDao();
        if (call != null){
            call = updateEntityFromETs(call);
            answer = dao.update(call);
        } else {
            call = updateEntityFromETs(new PlannedCall());
            answer = dao.insert(call);
        }
        return answer;
    }

    @Override
    protected List<String> getFieldsData() {
        List<String> list = new ArrayList<>();
        list.add(dateET.getText().toString());
        list.add(nameET.getText().toString());
        list.add(phoneNumberET.getText().toString());
        list.add(callNotesET.getText().toString());
        return list;
    }

    private PlannedCall updateEntityFromETs(PlannedCall call) {
        call.setDate(dateET.getText().toString());
        call.setNotes(notesET.getText().toString());
        call.setClientPhoneNumber(phoneNumberET.getText().toString());
        call.setClientName(nameET.getText().toString());
        return call;
    }

    @Override
    public void setListeners() {
        setButtonListener();
        setPhoneButtonListener();
    }

    private void setPhoneButtonListener() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "Типа звоним", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getViewId() {
        return R.layout.view_planned_call_info;
    }
}
