package com.epam.mikle.realestateagentassistant.model.dao.impl;


import android.content.ContentValues;
import android.database.Cursor;

import com.epam.mikle.realestateagentassistant.model.dao.PlannedCallDao;
import com.epam.mikle.realestateagentassistant.model.entity.BaseEntity;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedCall;
import com.epam.mikle.realestateagentassistant.model.sqlite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_CLIENT_NAME;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_DATE_CALL;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_ID;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_NOTES;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.COLUMN_NAME_PHONE_NUMBER;
import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.TABLE_NAME_PLANNED_CALLS;

public class PlannedCallDaoImpl implements PlannedCallDao {
    @Override
    public List<PlannedCall> findAll() {
        Cursor c = SQLiteHelper.getHelper()
                .getReadableDatabase()
                .query(
                        TABLE_NAME_PLANNED_CALLS,
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
                                TABLE_NAME_PLANNED_CALLS,
                                null,
                                initCV((PlannedCall) entity)
                        );
        return result != -1;
    }

    @Override
    public boolean update(BaseEntity entity) {
        long result =
                SQLiteHelper.getHelper()
                        .getWritableDatabase()
                        .update(
                                TABLE_NAME_PLANNED_CALLS,
                                initCV((PlannedCall) entity),
                                null,
                                null
                        );
        return result != -1;
    }

    private List<PlannedCall> initCallList(Cursor c) {
        ArrayList<PlannedCall> calls = new ArrayList<>();
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex(COLUMN_NAME_ID);
            int dateColIndex = c.getColumnIndex(COLUMN_NAME_DATE_CALL);
            int nameColIndex = c.getColumnIndex(COLUMN_NAME_CLIENT_NAME);
            int phoneNumberColIndex = c.getColumnIndex(COLUMN_NAME_PHONE_NUMBER);
            int notesColIndex = c.getColumnIndex(COLUMN_NAME_NOTES);

            do {
                PlannedCall call = new PlannedCall();
                call.setId(c.getInt(idColIndex));
                call.setDate(c.getString(dateColIndex));
                call.setClientName(c.getString(nameColIndex));
                call.setClientPhoneNumber(c.getString(phoneNumberColIndex));
                call.setNotes(c.getString(notesColIndex));
                calls.add(call);
            } while (c.moveToNext());
        }
        return calls;
    }

    private ContentValues initCV(PlannedCall call) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_DATE_CALL, call.getDate());
        cv.put(COLUMN_NAME_CLIENT_NAME, call.getClientName());
        cv.put(COLUMN_NAME_PHONE_NUMBER, call.getClientPhoneNumber());
        cv.put(COLUMN_NAME_NOTES, call.getNotes());
        return cv;
    }
}
