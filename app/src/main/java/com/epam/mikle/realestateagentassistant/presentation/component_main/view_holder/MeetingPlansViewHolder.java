package com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epam.mikle.realestateagentassistant.R;


public class MeetingPlansViewHolder extends RecyclerView.ViewHolder {

    private CardView cv;
    private TextView meetingDate;
    private TextView clientName;
    private TextView address;

    public MeetingPlansViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cv);
        meetingDate = itemView.findViewById(R.id.meeting_date);
        clientName = itemView.findViewById(R.id.client_name);
        address = itemView.findViewById(R.id.address);
    }

    public CardView getCv() {
        return cv;
    }

    public TextView getMeetingDate() {
        return meetingDate;
    }

    public TextView getClientName() {
        return clientName;
    }

    public TextView getAddress() {
        return address;
    }
}
