package com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epam.mikle.realestateagentassistant.R;


public class CallsHistoryViewHolder extends RecyclerView.ViewHolder {

    private CardView cv;
    private TextView callDate;
    private TextView clientName;
    private TextView results;

    public CallsHistoryViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cv);
        callDate = itemView.findViewById(R.id.call_date);
        clientName = itemView.findViewById(R.id.client_name);
        results = itemView.findViewById(R.id.result);
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

    public TextView getResults() {
        return results;
    }
}
