package com.example.level2geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 Created by EdwardBro on 20.02.2019.
 */

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView geoImage;
    public View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        geoImage =  itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}
