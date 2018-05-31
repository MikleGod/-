package com.epam.mikle.realestateagentassistant.model.sqlite;

public interface DbConstants {

    String DB_NAME = "RealEstateDb";

    int DB_VERSION_ACTUAL = 1;
    int DB_VERSION_FIRST = 1;
    int DB_VERSION_SECOND = 2;
    int DB_VERSION_THIRD = 3;

    String TABLE_NAME_PLANNED_CALLS = "PlannedCalls";
    String TABLE_NAME_PLANNED_MEETINGS = "PlannedMeetings";

    String COLUMN_NAME_ID = "_ID";
    String COLUMN_NAME_DATE_CALL = "DATE_CALL";
    String COLUMN_NAME_CLIENT_NAME = "CLIENT_NAME";
    String COLUMN_NAME_PHONE_NUMBER = "PHONE_NUMBER";
    String COLUMN_NAME_NOTES = "NOTES";
    String COLUMN_NAME_ADDRESS = "ADDRESS";
    String COLUMN_NAME_SQUARE = "SQUARE";
    String COLUMN_NAME_COST = "COST";
    String COLUMN_NAME_SQUARE_METER_COST = "SQUARE_METER_COST";

    String SQL_COLUMNS_BASE_ENTITY =
            COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + COLUMN_NAME_DATE_CALL + " CHAR(10), "
                    + COLUMN_NAME_CLIENT_NAME + " CHAR(55) NOT NULL, "
                    + COLUMN_NAME_PHONE_NUMBER + " CHAR(14) NOT NULL, "
                    + COLUMN_NAME_NOTES + " CHAR(240) NOT NULL";

    String SQL_COLUMNS_PLANNED_MEETING_ADD =
            ", " + COLUMN_NAME_ADDRESS + " CHAR(55) NOT NULL, "
                    + COLUMN_NAME_SQUARE + " DOUBLE NOT NULL, "
                    + COLUMN_NAME_COST + " DOUBLE NOT NULL, "
                    + COLUMN_NAME_SQUARE_METER_COST + " DOUBLE NOT NULL";

    String SQL_QUERY_CREATE_TABLE_PLANNED_CALLS =
            "CREATE TABLE "
                    + TABLE_NAME_PLANNED_CALLS +
                    " (" + SQL_COLUMNS_BASE_ENTITY + ")";
    String SQL_QUERY_CREATE_TABLE_PLANNED_MEETINGS =
            "CREATE TABLE "
                    + TABLE_NAME_PLANNED_MEETINGS + " ("
                    + SQL_COLUMNS_BASE_ENTITY
                    + SQL_COLUMNS_PLANNED_MEETING_ADD + ")";
}
