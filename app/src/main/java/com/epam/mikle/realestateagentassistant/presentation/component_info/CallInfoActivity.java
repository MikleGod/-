package com.epam.mikle.realestateagentassistant.presentation.component_info;

import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.contract.CallInfoContract;

public class CallInfoActivity extends AppCompatActivity implements CallInfoContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_info);
        final TextInputLayout layout = findViewById(R.id.durability_tip);
        layout.setVisibility(View.INVISIBLE);
        final LinearLayout layout2 = findViewById(R.id.results_ll);
        layout2.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout.getVisibility() == View.INVISIBLE) {
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.INVISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
