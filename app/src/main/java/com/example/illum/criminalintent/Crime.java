package com.example.illum.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by illum on 3/23/2017.
 */

public class Crime {
    private UUID mId;
    private String mTittle;
    private Date mDate;
    private boolean mSolved;

    public Crime (){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
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
