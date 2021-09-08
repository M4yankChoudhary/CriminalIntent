package me.mayankchoudhary.criminalintent;

import android.text.format.DateFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Crime implements Serializable {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        this.mID = UUID.randomUUID();
        this.mDate = new Date();
//        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
