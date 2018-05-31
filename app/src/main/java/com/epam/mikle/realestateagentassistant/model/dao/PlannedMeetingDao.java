package com.epam.mikle.realestateagentassistant.model.dao;

import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;

import java.util.List;


public interface PlannedMeetingDao  extends BaseDao {
    List<PlannedMeeting> findAll();
}
