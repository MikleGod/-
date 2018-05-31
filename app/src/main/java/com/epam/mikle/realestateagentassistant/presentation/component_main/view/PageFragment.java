package com.epam.mikle.realestateagentassistant.presentation.component_main.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.epam.mikle.realestateagentassistant.R;
import com.epam.mikle.realestateagentassistant.presentation.component_main.presenter.FragmentPresenter;


public class PageFragment extends Fragment {

    private RecyclerView rv;
    private FragmentPresenter presenter;
    private RecyclerItemClickListener listener;

    public void setPresenter(FragmentPresenter presenter) {
        this.presenter = presenter;
        presenter.setFragment(this);
        presenter.onSet();
    }


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
        setAdapter(presenter.getAdapter());
        return view;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (rv != null) {
            rv.setAdapter(adapter);
            rv.removeOnItemTouchListener(listener);
            rv.addOnItemTouchListener(listener = new RecyclerItemClickListener(getContext(), presenter.getOnItemTouchListener()));
            rv.invalidate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    public String getTitle() {
        return presenter.getTitle();
    }

    public void updateRV() {
        rv.invalidate();
    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        private GestureDetector mGestureDetector;

        RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
