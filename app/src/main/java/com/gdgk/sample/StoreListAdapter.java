package com.gdgk.sample;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdgk.sample.databinding.StoreItemDataBinding;
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
        StoreItemDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(c), R.layout.item_store, parent, false);
        ItemViewHolder holder = new ItemViewHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.binding.setVariable(com.gdgk.sample.BR.item, mItems.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private StoreItemDataBinding binding;

        public ItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public StoreItemDataBinding getBinding() {
            return binding;
        }

        public void setBinding(StoreItemDataBinding binding) {
            this.binding = binding;
        }
    }
}
