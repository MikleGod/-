package com.epam.mikle.realestateagentassistant.model.dao;


import com.epam.mikle.realestateagentassistant.model.dao.impl.CompletedCallDaoImpl;
import com.epam.mikle.realestateagentassistant.model.dao.impl.CompletedMeetingDaoImpl;
import com.epam.mikle.realestateagentassistant.model.dao.impl.PlannedCallDaoImpl;
import com.epam.mikle.realestateagentassistant.model.dao.impl.PlannedMeetingDaoImpl;

public class DaoManager {
    private static final DaoManager ourInstance = new DaoManager();
    private CompletedCallDao completedCallDao = new CompletedCallDaoImpl();
    private CompletedMeetingDao completedMeetingDao = new CompletedMeetingDaoImpl();
    private PlannedCallDao plannedCallDao = new PlannedCallDaoImpl();
    private PlannedMeetingDao plannedMeetingDao = new PlannedMeetingDaoImpl();

    public static DaoManager getInstance() {
        return ourInstance;
    }

    private DaoManager() {
    }

    public CompletedCallDao getCompletedCallDao() {
        return completedCallDao;
    }

    public CompletedMeetingDao getCompletedMeetingDao() {
        return completedMeetingDao;
    }

    public PlannedCallDao getPlannedCallDao() {
        return plannedCallDao;
    }

    public PlannedMeetingDao getPlannedMeetingDao() {
        return plannedMeetingDao;
    }
}
