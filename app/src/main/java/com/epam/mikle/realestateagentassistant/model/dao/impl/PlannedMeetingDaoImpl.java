package com.epam.mikle.realestateagentassistant.model.dao.impl;


import android.content.ContentValues;
import android.database.Cursor;

import com.epam.mikle.realestateagentassistant.model.dao.PlannedMeetingDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;
import com.epam.mikle.realestateagentassistant.model.sqlite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_ADDRESS;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_CLIENT_NAME;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_COST;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_DATE_CALL;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_ID;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_NOTES;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_PHONE_NUMBER;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_SQUARE;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_SQUARE_METER_COST;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.TABLE_NAME_PLANNED_MEETINGS;

public class PlannedMeetingDaoImpl implements PlannedMeetingDao {
    @Override
    public List<PlannedMeeting> findAll() {
        Cursor c = SQLiteHelper.getHelper()
                .getReadableDatabase()
                .query(
                        TABLE_NAME_PLANNED_MEETINGS,
                        null,
                        null,
                        null,
                        null,
                        null,
                        COLUMN_NAME_ID + " DESC",
                        null
                );

        return initCallList(c);
    }

    @Override
    public boolean insert(BaseEntity entity) {
        long result =
                SQLiteHelper.getHelper()
                        .getWritableDatabase()
                        .insert(
                                TABLE_NAME_PLANNED_MEETINGS,
                                null,
                                initCV((PlannedMeeting) entity)
                        );
        return result != -1;
    }

    @Override
    public boolean update(BaseEntity entity) {

        long result =
                SQLiteHelper.getHelper()
                        .getWritableDatabase()
                        .update(
                                TABLE_NAME_PLANNED_MEETINGS,
                                initCV((PlannedMeeting) entity),
                                null,
                                null
                        );
        return result != -1;
    }


    private List<PlannedMeeting> initCallList(Cursor c) {
        ArrayList<PlannedMeeting> meetings = new ArrayList<>();
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex(COLUMN_NAME_ID);
            int dateColIndex = c.getColumnIndex(COLUMN_NAME_DATE_CALL);
            int nameColIndex = c.getColumnIndex(COLUMN_NAME_CLIENT_NAME);
            int phoneNumberColIndex = c.getColumnIndex(COLUMN_NAME_PHONE_NUMBER);
            int notesColIndex = c.getColumnIndex(COLUMN_NAME_NOTES);
            int addressColIndex = c.getColumnIndex(COLUMN_NAME_ADDRESS);
            int squareColIndex = c.getColumnIndex(COLUMN_NAME_SQUARE);
            int costColIndex = c.getColumnIndex(COLUMN_NAME_COST);
            int squareMCostColIndex = c.getColumnIndex(COLUMN_NAME_SQUARE_METER_COST);

            do {
                PlannedMeeting meeting = new PlannedMeeting();
                meeting.setId(c.getInt(idColIndex));
                meeting.setDate(c.getString(dateColIndex));
                meeting.setClientName(c.getString(nameColIndex));
                meeting.setClientPhoneNumber(c.getString(phoneNumberColIndex));
                meeting.setNotes(c.getString(notesColIndex));
                meeting.setAddress(c.getString(addressColIndex));
                meeting.setSquare(c.getDouble(squareColIndex));
                meeting.setCost(c.getDouble(costColIndex));
                meeting.setSquareMCost(c.getDouble(squareMCostColIndex));
                meetings.add(meeting);
            } while (c.moveToNext());
        }
        return meetings;
    }

    private ContentValues initCV(PlannedMeeting meeting) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_DATE_CALL, meeting.getDate());
        cv.put(COLUMN_NAME_CLIENT_NAME, meeting.getClientName());
        cv.put(COLUMN_NAME_PHONE_NUMBER, meeting.getClientPhoneNumber());
        cv.put(COLUMN_NAME_NOTES, meeting.getNotes());
        cv.put(COLUMN_NAME_ADDRESS, meeting.getAddress());
        cv.put(COLUMN_NAME_SQUARE, meeting.getSquare());
        cv.put(COLUMN_NAME_COST, meeting.getCost());
        cv.put(COLUMN_NAME_SQUARE_METER_COST, meeting.getSquareMCost());
        return cv;
    }
}
