package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.CallPlansViewHolder;



public class CallPlansAdapter extends RecyclerView.Adapter<CallPlansViewHolder> {
    @Override
    public CallPlansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_calls_plans, parent, false);
        return new CallPlansViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CallPlansViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
