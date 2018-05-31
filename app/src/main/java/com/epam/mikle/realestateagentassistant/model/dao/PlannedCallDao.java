package com.epam.mikle.realestateagentassistant.model.dao;

import com.epam.mikle.realestateagentassistant.model.entity.PlannedCall;

import java.util.List;


public interface PlannedCallDao  extends BaseDao {
    List<PlannedCall> findAll();
}
