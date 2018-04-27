package com.epam.mikle.realestateagentassistant.presentation.component_info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.contract.MeetingInfoContract;

public class MeetingInfoActivity extends AppCompatActivity implements MeetingInfoContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_info);
    }
}
