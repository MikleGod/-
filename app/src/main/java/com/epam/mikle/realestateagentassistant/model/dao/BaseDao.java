package com.epam.mikle.realestateagentassistant.model.dao;


import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;

public interface BaseDao {
    boolean insert(BaseEntity entity);
    boolean update(BaseEntity entity);
}
