package com.epam.mikle.realestateagentassistant.presentation.component_info.presenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.dao.CompletedCallDao;
import com.epam.mikle.realestateagentassistant.model.dao.DaoManager;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

import java.util.ArrayList;
import java.util.List;


public class CompletedCallPresenter extends BaseInfoPresenter {

    private Spinner results;
    private EditText callDurationET;
    private EditText callNotesET;
    private String[] data;
    private ArrayAdapter<String> adapter;


    public CompletedCallPresenter(InfoContract.View view) {
        super(view);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        callDurationET = view.findViewById(R.id.durability_edit_text);
        callNotesET = view.findViewById(R.id.notes_edit_text);
        callNotesET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        initSpinner();
        initViews();
        setListeners();
    }

    public void setListeners() {
        setSpinnerListener();
        setButtonListener();
    }

    @Override
    public int getViewId() {
        return R.layout.view_completed_call_info;
    }

    protected void setViewsEnabled(boolean focusable) {
            dateET.setEnabled(focusable);
            nameET.setEnabled(focusable);
            results.setEnabled(focusable);
            phoneNumberET.setEnabled(focusable);
            callDurationET.setEnabled(focusable);
            callNotesET.setEnabled(focusable);
    }

    private void initSpinner() {
        results = view.findViewById(R.id.resultSP);
        getResultsItems();
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        results.setAdapter(adapter);
        results.setSelected(false);
    }

    protected void setViewInfo(BaseEntity entity) {
        CompletedCall call = (CompletedCall) entity;
        dateET.setText(call.getDate());
        nameET.setText(call.getClientName());
        try {
            results.setSelection(setResults(call.getResults()));
        } catch (Exception e) {
            results.setSelected(false);
        }
        phoneNumberET.setText(call.getClientPhoneNumber());
        callDurationET.setText(call.getCallDuration());
        callNotesET.setText(call.getNotes());
    }

    @Override
    protected boolean saveChangesInDb() {
        CompletedCall call = (CompletedCall) view.getIntent().getSerializableExtra(InfoContract.COMING_ENTITY);
        boolean answer = false;
        CompletedCallDao dao = DaoManager.getInstance().getCompletedCallDao();
        if (call != null){
            call = updateEntityFromETs(call);
            answer = dao.update(call);
        } else {
            call = updateEntityFromETs(new CompletedCall());
            answer = dao.insert(call);
        }
        return answer;
    }

    private CompletedCall updateEntityFromETs(CompletedCall call) {
        call.setDate(dateET.getText().toString());
        call.setNotes(notesET.getText().toString());
        call.setClientPhoneNumber(phoneNumberET.getText().toString());
        call.setClientName(nameET.getText().toString());
        call.setCallDuration(callDurationET.getText().toString());
        return call;
    }

    @Override
    protected List<String> getFieldsData() {
        List<String> list = new ArrayList<>();
        list.add(dateET.getText().toString());
        list.add(nameET.getText().toString());
        list.add(phoneNumberET.getText().toString());
        list.add(callDurationET.getText().toString());
        list.add(callNotesET.getText().toString());
        return list;
    }

    private int setResults(String result) throws Exception {
        if (result.equals(data[0]))
            return 0;
        if (result.equals(data[0]))
            return 1;
        if (result.equals(data[0]))
            return 2;
        throw new Exception();
    }

    private void setSpinnerListener() {
        results.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getResultsItems() {
        data = new String[]{"Call", "None", "Meeting"};
    }
}
