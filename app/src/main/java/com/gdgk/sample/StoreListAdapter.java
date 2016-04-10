package com.gdgk.sample;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdgk.sample.model.StoreItem;

import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ItemViewHolder>{
    private Context c;
    private List<StoreItem> mItems;

    public StoreListAdapter(Context c, List<StoreItem> mItems) {
        this.c = c;
        this.mItems = mItems;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(c).inflate(R.layout.item_store, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.name.setText(mItems.get(position).getName());
        holder.price.setText("$"+ mItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView name, price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.view_item_name);
            this.price = (TextView) itemView.findViewById(R.id.view_item_price);
        }
    }
}
