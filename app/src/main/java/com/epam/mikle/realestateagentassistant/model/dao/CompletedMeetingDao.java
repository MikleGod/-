package com.epam.mikle.realestateagentassistant.model.dao;

import com.epam.mikle.realestateagentassistant.model.entity.CompletedMeeting;

import java.util.List;


public interface CompletedMeetingDao  extends BaseDao {
    List<CompletedMeeting> findAll();
}
