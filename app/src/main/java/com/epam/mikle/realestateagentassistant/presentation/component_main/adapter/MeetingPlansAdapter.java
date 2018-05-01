package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingPlansViewHolder;


public class MeetingPlansAdapter extends RecyclerView.Adapter<MeetingPlansViewHolder> {
    @Override
    public MeetingPlansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_meetings_plans, parent, false);
        return new MeetingPlansViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeetingPlansViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
