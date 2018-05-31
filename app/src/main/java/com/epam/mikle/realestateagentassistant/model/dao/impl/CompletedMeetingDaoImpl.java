package com.epam.mikle.realestateagentassistant.model.dao.impl;


import com.epam.mikle.realestateagentassistant.model.dao.CompletedMeetingDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedMeeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CompletedMeetingDaoImpl implements CompletedMeetingDao{
    @Override
    public List<CompletedMeeting> findAll() {
        ArrayList<CompletedMeeting> calls = new ArrayList<>();
        for (int i=0; i<10; i++){
            Random random = new Random();
            CompletedMeeting call = new CompletedMeeting();
            call.setDate(random.nextInt()+"Date");
            call.setResults(random.nextInt()+"Result");
            call.setClientName(random.nextInt()+"Name");
            call.setAddress(random.nextInt()+"Address");
            call.setClientPhoneNumber(random.nextInt()+"Number");
            call.setCost(Double.parseDouble( random.nextInt(1000000)+""));
            call.setSquare(Double.parseDouble( random.nextInt(100)+""));
            call.setSquareMCost(Double.parseDouble( random.nextInt(10000)+""));
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
