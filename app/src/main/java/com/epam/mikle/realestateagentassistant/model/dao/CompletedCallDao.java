package com.epam.mikle.realestateagentassistant.model.dao;

import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;

import java.util.List;



public interface CompletedCallDao extends BaseDao {
    List<CompletedCall> findAll();
}
