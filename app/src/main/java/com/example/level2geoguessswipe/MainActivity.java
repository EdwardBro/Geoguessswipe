package com.example.level2geoguessswipe;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

        List<GeoObject> mGeoObjects;
        private GestureDetector mGestureDetector;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mGeoObjects = new ArrayList<>();

            for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {
                mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i], GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], GeoObject.PRE_DEFINED_GEO_OBJECT_ANSWER[i]));
            }

            final RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
            mGeoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            mGeoRecyclerView.setHasFixedSize(true);
            final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
            mGeoRecyclerView.setAdapter(mAdapter);
            mGeoRecyclerView.addOnItemTouchListener(this);

            mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                    new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                        @Override
                        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                            return false;
                        }

                        //Called when a user swipes left or right on a ViewHolder
                        @Override
                        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                            int position = viewHolder.getAdapterPosition();
                            final GeoObject child = mGeoObjects.get(position);
                            if((swipeDir == 4 && child.getmyAnswer()) || (swipeDir == 8 && !child.getmyAnswer())) {
                                mGeoObjects.remove(position);
                                mAdapter.notifyItemRemoved(position);
                                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                            } else {
                                mAdapter.notifyItemChanged(position);
                                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    };

            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            int mAdapterPosition = rv.getChildAdapterPosition(child);
            if (child != null && mGestureDetector.onTouchEvent(e)) {
                Toast.makeText(this, mGeoObjects.get(mAdapterPosition).getmGeoName(), Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean allowIntercept) {
        }

    }
