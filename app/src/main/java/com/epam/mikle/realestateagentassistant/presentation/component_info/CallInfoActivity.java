package com.epam.mikle.realestateagentassistant.presentation.component_info;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.contract.CallInfoContract;

public class CallInfoActivity extends AppCompatActivity implements CallInfoContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewGroup parent = (ViewGroup)findViewById(R.id.info_parent);
        inflater.inflate(R.layout.view_completed_meeting_info, parent);
        ((Button) findViewById(R.id.save_change_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.removeAllViews();
                inflater.inflate(R.layout.view_planned_meeting_info, parent);
            }
        });
    }
}
