package com.vaibhav.assignment102;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {
    private String[] mDataset;


    CardViewDataAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);


        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.tvtinfo_text.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvtinfo_text;

        ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvtinfo_text = (TextView) itemLayoutView
                    .findViewById(R.id.info_text);

        }
    }
}