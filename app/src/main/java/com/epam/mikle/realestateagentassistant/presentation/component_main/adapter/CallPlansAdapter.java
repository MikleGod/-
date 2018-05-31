package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.model.entity.PlannedCall;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.CallPlansViewHolder;

import java.util.List;


public class CallPlansAdapter extends RecyclerView.Adapter<CallPlansViewHolder> implements RVAdapterHelper{

    private List<PlannedCall> calls;

    public CallPlansAdapter(List<PlannedCall> calls) {
        this.calls = calls;
    }

    @Override
    public CallPlansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_calls_plans, parent, false);
        return new CallPlansViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CallPlansViewHolder holder, int position) {
        holder.getCallDate().setText(calls.get(position).getDate());
        holder.getClientName().setText(calls.get(position).getClientName());
    }


    @Override
    public int getItemCount() {
        return calls.size();
    }

    public PlannedCall getEntityOn(int position){
        return calls.get(position);
    }

    public void setCalls(List<PlannedCall> calls) {
        this.calls = calls;
    }
}
