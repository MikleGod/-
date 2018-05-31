package com.epam.mikle.realestateagentassistant.presentation.component_info.presenter;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.validator.BaseInfoViewValidator;
import com.epam.mikle.realestateagentassistant.model.validator.impl.SimpleValidator;
import com.epam.mikle.realestateagentassistant.presentation.contract.InfoContract;

import java.util.List;

public abstract class BaseInfoPresenter implements InfoContract.Presenter {

    protected InfoContract.View view;

    protected EditText dateET;
    protected EditText nameET;
    protected EditText phoneNumberET;
    protected EditText notesET;
    protected Button actionButton;

    protected boolean isNew;
    protected boolean isEnabled = true;

    public BaseInfoPresenter(InfoContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        dateET = view.findViewById(R.id.date_edit_text);
        nameET = view.findViewById(R.id.clientname_edit_text);
        phoneNumberET = view.findViewById(R.id.phone_edit_text);
        actionButton = view.findViewById(R.id.button);
        notesET = view.findViewById(R.id.notes_edit_text);
    }


    protected void setButtonListener() {
        actionButton.setOnClickListener(new MyBL());
    }

    protected void setViewsEnabled(boolean enabled) {
        dateET.setEnabled(enabled);
        nameET.setEnabled(enabled);
        notesET.setEnabled(enabled);
        phoneNumberET.setEnabled(enabled);
    }


    protected void initViews() {
        if (!view.getIntent().hasExtra(InfoContract.COMING_ENTITY)) {
            isNew = true;
            actionButton.setText(R.string.save_changes);
        } else {
            setViewInfo((BaseEntity) view.getIntent().getSerializableExtra(InfoContract.COMING_ENTITY));
            setViewsEnabled(isEnabled = false);
        }
    }

    protected abstract void setViewInfo(BaseEntity entity);


    class MyBL implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (isEnabled) {
                saveChanges();
            } else {
                changeData(R.string.save_changes);
            }

        }
    }

    private void changeData(int text) {
        actionButton.setText(text);
        isEnabled = !isEnabled;
        setViewsEnabled(isEnabled);
    }

    private void saveChanges() {
        String validatorMessage = getValidator().validate(getFieldsData());
        if (validatorMessage.isEmpty()){
            if (!saveChangesInDb()) {
                Toast.makeText(view.getContext(), "Unknown error!", Toast.LENGTH_LONG).show();
            }
            changeData(R.string.change);
        } else {
            Toast.makeText(view.getContext(), validatorMessage, Toast.LENGTH_LONG).show();
        }
    }

    protected abstract boolean saveChangesInDb();

    protected abstract List<String> getFieldsData();

    private BaseInfoViewValidator getValidator() {
        return new SimpleValidator();
    }
}
