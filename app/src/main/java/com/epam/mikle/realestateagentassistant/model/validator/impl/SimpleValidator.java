package com.epam.mikle.realestateagentassistant.model.validator.impl;

import com.epam.mikle.realestateagentassistant.model.validator.BaseInfoViewValidator;

import java.util.List;


public class SimpleValidator implements BaseInfoViewValidator {
    private static final String FIELD_IS_EMPTY_MESSAGE = "All fields must be filled";

    @Override
    public String validate(List<String> values) {
        String validatorMessage = "";
        if (hasEmptyValue(values)){
            validatorMessage = FIELD_IS_EMPTY_MESSAGE;
        }
        return validatorMessage;
    }
    
    private boolean hasEmptyValue(List<String> values){
        boolean hasEmptyValue = false;
        for (String value : values) {
            if (value.isEmpty()){
                hasEmptyValue = true;
                break;
            }
        }
        return hasEmptyValue;
    }
}
