package com.epam.mikle.realestateagentassistant.model.dao;

/**
 * Created by Сергей on 30.04.2018.
 */

class DaoManager {
    private static final DaoManager ourInstance = new DaoManager();

    static DaoManager getInstance() {
        return ourInstance;
    }

    private DaoManager() {
    }
}
