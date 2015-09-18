package com.architjn.epic.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.architjn.epic.R;
import com.architjn.epic.utils.items.Image;

import java.util.List;

public class ImgsAdapter extends RecyclerView.Adapter<ImgsAdapter.SimpleItemViewHolder> {

    private final List<Image> items;
    private Context context;
    private LinearLayout.LayoutParams layoutParams;

    public final static class SimpleItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView gridImage;

        public SimpleItemViewHolder(View view) {
            super(view);

            gridImage = (ImageView) view.findViewById(R.id.item_imageview);
        }
    }

    public ImgsAdapter(Context context, List<Image> items, LinearLayout.LayoutParams layoutParams) {
        this.context = context;
        this.items = items;
        this.layoutParams = layoutParams;
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.image_item, parent, false);


        return new SimpleItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SimpleItemViewHolder holder, final int position) {
//        Picasso.with(context).load(items.get(position).getPath()).into(holder.gridImage);
        holder.gridImage.setLayoutParams(layoutParams);
        holder.gridImage.setImageURI(Uri.parse(items.get(position).getPath()));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}

