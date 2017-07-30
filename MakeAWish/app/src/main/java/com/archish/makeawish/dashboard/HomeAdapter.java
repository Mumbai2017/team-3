package com.archish.makeawish.dashboard;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.archish.makeawish.R;
import com.archish.makeawish.data.model.Home;
import com.archish.makeawish.ui.widgets.BaseTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.NewsFeedViewHolder> {

    ArrayList<Home> data;
    private LikeItemUpdateListener commander;

    public HomeAdapter(ArrayList<Home> data, LikeItemUpdateListener commander) {
        this.data = data;
        this.commander = commander;
    }

    public interface LikeItemUpdateListener {
        void onItemStatusChanged(Home home);

        void onItemCardClicked(Home home);
    }

    @Override
    public HomeAdapter.NewsFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);
        NewsFeedViewHolder holder = new NewsFeedViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HomeAdapter.NewsFeedViewHolder holder, final int position) {
        holder.tvTitle.setText(data.get(position).getPtitle());
        holder.tvDescription.setText(data.get(position).getWish());
        if (data.get(position).getStatus() == 1) {
            holder.tvStatus.setText("PENDING");
            holder.tvStatus.setBackgroundColor(Color.RED);
        } else if (data.get(position).getStatus() == 2) {
            holder.tvStatus.setText("IN PROCESS");
            holder.tvStatus.setBackgroundColor(Color.YELLOW);
        } else if (data.get(position).getStatus() == 3) {
            holder.tvStatus.setText("COMPLETED");
            holder.tvStatus.setBackgroundColor(Color.GREEN);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        BaseTextView tvDescription, tvTitle, tvStatus;

        public NewsFeedViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (BaseTextView) itemView.findViewById(R.id.tvName);
            tvDescription = (BaseTextView) itemView.findViewById(R.id.tvDescription);
            tvStatus = (BaseTextView) itemView.findViewById(R.id.tvStatus);
        }

    }


}
