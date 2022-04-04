package com.example.swipe.example;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class RecycledPagerAdapter<VH extends RecycledPagerAdapter.ViewHolder> extends PagerAdapterNew {

    public static abstract class ViewHolder {
        final View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }

        public abstract void onDestroy();
    }

    Queue<VH> destroyedItems = new LinkedList<>();
    ArrayList<VH> existingItems = new ArrayList<>();

    @Override
    public final Object instantiateItem(ViewGroup container, int position) {
//        VH viewHolder = destroyedItems.poll();
        VH viewHolder = onCreateViewHolder(container);
        onBindViewHolder(viewHolder, position);
        container.addView(viewHolder.itemView);
//        if (viewHolder != null) {
//             Re-add existing view before rendering so that we can make change inside getView()
//            container.addView(viewHolder.itemView);
//            onBindViewHolder(viewHolder, position);
//        } else {
//            viewHolder = onCreateViewHolder(container);
//            onBindViewHolder(viewHolder, position);
//            container.addView(viewHolder.itemView);
//        }
        existingItems.add(viewHolder);

        return viewHolder;
    }

    @Override
    public final void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((VH) object).itemView);
        ((VH) object).onDestroy();
        destroyedItems.add((VH) object);
        existingItems.remove((VH) object);
    }

    @Override
    public final boolean isViewFromObject(View view, Object object) {
        return ((VH) object).itemView == view;
    }

    /**
     * Create a new view holder
     * @param parent
     * @return view holder
     */
    public abstract VH onCreateViewHolder(ViewGroup parent);

    /**
     * Bind data at position into viewHolder
     * @param viewHolder
     * @param position
     */
    public abstract void onBindViewHolder(VH viewHolder, int position);

}