package com.epam.mikle.realestateagentassistant.model.dao.impl;

import com.epam.mikle.realestateagentassistant.model.dao.CompletedCallDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CompletedCallDaoImpl implements CompletedCallDao {
    @Override
    public List<CompletedCall> findAll() {
        ArrayList<CompletedCall> calls = new ArrayList<>();
        for (int i=0; i<10; i++){
            Random random = new Random();
            CompletedCall call = new CompletedCall();
            call.setDate(random.nextInt()+"Date");
            call.setResults(random.nextInt()+"Result");
            call.setClientName(random.nextInt()+"Name");
            call.setCallDuration(random.nextInt()+"Duration");
            call.setClientPhoneNumber(random.nextInt()+"Number");
            call.setNotes(random.nextInt()+"Notes");
            calls.add(call);
        }
        return calls;
    }

    @Override
    public boolean insert(BaseEntity entity) {
        return true;
    }

    @Override
    public boolean update(BaseEntity entity) {
        return true;
    }
}
