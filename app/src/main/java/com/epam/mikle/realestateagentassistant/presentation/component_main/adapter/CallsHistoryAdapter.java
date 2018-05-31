package com.epam.mikle.realestateagentassistant.presentation.component_main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.model.entity.CompletedCall;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.CallsHistoryViewHolder;
import com.epam.mikle.realestateagentassistant.presentation.component_main.view_holder.MeetingsHistoryViewHolder;

import java.util.List;


public class CallsHistoryAdapter extends RecyclerView.Adapter<CallsHistoryViewHolder>  implements RVAdapterHelper{

    private List<CompletedCall> calls;

    public CallsHistoryAdapter(List<CompletedCall> calls) {
        this.calls = calls;
    }

    @Override
    public CallsHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_calls_history, parent, false);
        return new CallsHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CallsHistoryViewHolder holder, int position) {
        holder.getCallDate().setText(calls.get(position).getDate());
        holder.getClientName().setText(calls.get(position).getClientName());
        holder.getResults().setText(calls.get(position).getResults());
    }

    @Override
    public int getItemCount() {
        return calls.size();
    }

    public CompletedCall getEntityOn(int position){
        return calls.get(position);
    }
}
