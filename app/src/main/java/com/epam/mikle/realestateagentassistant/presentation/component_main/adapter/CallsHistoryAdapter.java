package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.CallsHistoryViewHolder;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingsHistoryViewHolder;

/**
 * Created by Сергей on 01.05.2018.
 */

public class CallsHistoryAdapter extends RecyclerView.Adapter<CallsHistoryViewHolder> {
    @Override
    public CallsHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_calls_history, parent, false);
        return new CallsHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CallsHistoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
