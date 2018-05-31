package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedMeeting;
import com.epam.mikle.realestateagentassistant.model.entity.Meeting;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedMeeting;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingsHistoryViewHolder;

import java.util.ArrayList;
import java.util.List;


public class MeetingsHistoryAdapter extends RecyclerView.Adapter<MeetingsHistoryViewHolder>  implements RVAdapterHelper{

    private List<CompletedMeeting> meetings = new ArrayList<>();

    public MeetingsHistoryAdapter(List<CompletedMeeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public MeetingsHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_meetings_history, parent, false);
        return new MeetingsHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeetingsHistoryViewHolder holder, int position) {
        holder.getAddress().setText(meetings.get(position).getAddress());
        holder.getClientName().setText(meetings.get(position).getClientName());
        holder.getMeetingDate().setText(meetings.get(position).getDate());
        holder.getResults().setText(meetings.get(position).getResults());
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    public CompletedMeeting getEntityOn(int position){
        return meetings.get(position);
    }
}
