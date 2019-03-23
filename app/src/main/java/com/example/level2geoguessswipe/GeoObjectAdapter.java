package com.example.level2geoguessswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 Created by EdwardBro on 17.02.2019.
 */

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder>  {

    private Context context;
    private List<GeoObject> listGeoObject;

    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {
        this.context = context;
        this.listGeoObject = listGeoObject;
    }

    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new GeoObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position) {
        final GeoObject geoObject = listGeoObject.get(position);
        holder.geoImage.setImageResource(geoObject.getmGeoImageName());
    }

    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }
}
