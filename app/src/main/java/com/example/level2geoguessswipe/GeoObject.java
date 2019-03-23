package com.example.level2geoguessswipe;

/**
 Created by EdwardBro on 20.02.2019.
 */


public class GeoObject {

    private String mGeoName;
    private int mGeoImageName;
    private boolean myAnswer;

    public GeoObject(String mGeoName, int mGeoImageName, boolean myAnswer) {

        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        this.myAnswer = myAnswer;
    }

    public String getmGeoName() {
        return mGeoName;
    }

    public void setmGeoName(String mGeoName) {
        this.mGeoName = mGeoName;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getmyAnswer() {
        return myAnswer;
    }

    public void setmyAnswer(boolean myAnswer) {
        this.myAnswer = myAnswer;
    }

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bandlagesh",
            "Kazakhstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand",
    };


    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {

            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,
    };

    public static final boolean[] PRE_DEFINED_GEO_OBJECT_ANSWER = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };
}