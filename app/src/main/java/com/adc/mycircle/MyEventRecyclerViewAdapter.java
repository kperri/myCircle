package com.adc.mycircle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adc.mycircle.EventFragment.OnListFragmentInteractionListener;
import com.adc.mycircle.items.EventContent;
import com.adc.mycircle.items.EventContent.Event;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Event} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder> {

    private final List<Event> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyEventRecyclerViewAdapter(List<Event> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.event = mValues.get(position);
        holder.eventTitle.setText(mValues.get(position).id);
        holder.eventDescription.setText(mValues.get(position).eventTitle);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.event);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView eventTitle;
        public final TextView eventOrganizer;
        public final TextView eventDescription;
        public Event event;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            eventTitle = (TextView) view.findViewById(R.id.event_title);
            eventOrganizer = (TextView) view.findViewById(R.id.circle_name);
            eventDescription = (TextView) view.findViewById(R.id.event_description);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + eventDescription.getText() + "'";
        }
    }
}
