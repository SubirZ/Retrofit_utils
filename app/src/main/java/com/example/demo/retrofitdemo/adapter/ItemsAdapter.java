package com.example.demo.retrofitdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.retrofitdemo.R;
import com.example.demo.retrofitdemo.databinding.RowMoviesBinding;
import com.example.demo.retrofitdemo.model.MovieModel;
import com.example.demo.retrofitdemo.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Recycler view adapter for items list
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemHolder> {

    private Context context;
    private List<MovieModel> itemsList = new ArrayList<>();
    private OnItemClickListener itemClickListener;

    private long lastClickedTime;

    public ItemsAdapter(final Context context, final List<MovieModel> itemsList, final OnItemClickListener itemClickListener) {
        this.context = context;
        this.itemsList = itemsList;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowMoviesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_movies, parent, false);
        return new ItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        final MovieModel model = itemsList.get(position);
        holder.itemView.setTag(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RowMoviesBinding binding;

        ItemHolder(RowMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final MovieModel model) {
            binding.rowMoviesTvTitle.setText(model.getTitle());
            binding.rowMoviesTvSubtitle.setText(model.getReleaseDate());
            binding.rowMoviesTvDescription.setText(model.getOverview());
            binding.rowMoviesTvRating.setText(String.valueOf(model.getVoteAverage()));
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            /*
            * Logic to Prevent the Launch of the Fragment Twice if User makes
            * the Tap(Click) very Fast.
            */
            if (SystemClock.elapsedRealtime() - lastClickedTime < Constants.MAX_CLICK_INTERVAL) {
                return;
            }
            lastClickedTime = SystemClock.elapsedRealtime();

            if (itemClickListener != null) {
                itemClickListener.onItemClick(position);
            }
        }
    }
}
