package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingPlansViewHolder;

import java.util.List;


public class MeetingPlansAdapter extends RecyclerView.Adapter<MeetingPlansViewHolder>  implements RVAdapterHelper{

    private List<PlannedMeeting> meetings;

    public MeetingPlansAdapter(List<PlannedMeeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public MeetingPlansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_meetings_plans, parent, false);
        return new MeetingPlansViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeetingPlansViewHolder holder, int position) {
        holder.getAddress().setText(meetings.get(position).getAddress());
        holder.getClientName().setText(meetings.get(position).getClientName());
        holder.getMeetingDate().setText(meetings.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    public PlannedMeeting getEntityOn(int position){
        return meetings.get(position);
    }

    public void setMeetings(List<PlannedMeeting> meetings) {
        this.meetings = meetings;
    }
}
