package com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epam.mikle.realestateagentassistant.R;

/**
 * Created by Сергей on 01.05.2018.
 */

public class CallPlansViewHolder extends RecyclerView.ViewHolder {
    private CardView cv;
    private TextView callDate;
    private TextView clientName;

    public CallPlansViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cv);
        callDate = itemView.findViewById(R.id.call_date);
        clientName = itemView.findViewById(R.id.client_name);
    }

    public CardView getCv() {
        return cv;
    }

    public TextView getCallDate() {
        return callDate;
    }

    public TextView getClientName() {
        return clientName;
    }
}
