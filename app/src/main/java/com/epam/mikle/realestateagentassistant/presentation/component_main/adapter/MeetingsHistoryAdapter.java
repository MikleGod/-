package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingsHistoryViewHolder;



public class MeetingsHistoryAdapter extends RecyclerView.Adapter<MeetingsHistoryViewHolder> {
    @Override
    public MeetingsHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_meetings_history, parent, false);
        return new MeetingsHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeetingsHistoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
