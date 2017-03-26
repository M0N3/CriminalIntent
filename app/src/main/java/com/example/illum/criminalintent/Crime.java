package com.example.illum.criminalintent;

import java.util.UUID;

/**
 * Created by illum on 3/23/2017.
 */

public class Crime {
    private UUID mId;
    private String mTittle;

    public UUID getmId() {
        return mId;
    }

    public UUID getId() {
        return mId;
    }

    public String getTittle() {
        return mTittle;
    }

    public void setTittle(String tittle) {
        mTittle = tittle;
    }
}
