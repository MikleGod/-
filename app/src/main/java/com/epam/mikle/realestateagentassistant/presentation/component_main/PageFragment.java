package com.epam.mikle.realestateagentassistant.presentation.component_main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.adapter.RVAdapter;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.FragmentPresenter;


public class PageFragment extends Fragment{

    RecyclerView rv;

    public void setPresenter(FragmentPresenter presenter) {
        this.presenter = presenter;
        presenter.setFragment(this);
        presenter.onSet();
    }

    private FragmentPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(presenter.getAdapter());
        return view;
    }

    void setAdapter(RVAdapter adapter){
        rv.setAdapter(adapter);
        rv.invalidate();
    }

    public String getTitle(){
        return presenter.getTitle();
    }

}
