package com.applaudostudio.weektwochallenge2;

import android.os.Parcel;
import android.os.Parcelable;

/***
 * This class is for both teams, implementing Parcealbe to set a bundle on the main.
 */
public class Team implements Parcelable{

    private int mYellowCards;
    private int mRedCards;
    private int mGoals;
    private int mPenaltiesGoals;
    private int mRedCardsByYellows;
    private int mFouls;

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };



    Team() {
        this.mYellowCards=0;
        this.mRedCards=0;
        this.mGoals=0;
        this.mPenaltiesGoals=0;
        this.mRedCardsByYellows=0;
        this.mFouls=0;
    }


    private Team(Parcel in) {
        mYellowCards = in.readInt();
        mRedCards = in.readInt();
        mGoals = in.readInt();
        mPenaltiesGoals = in.readInt();
        mRedCardsByYellows = in.readInt();
        mFouls = in.readInt();
    }


    public int getYellowCards() {
        return mYellowCards;
    }

    public int getRedCards() {
        return mRedCards;
    }

    public int getGoals() {
        return mGoals;
    }

    public int getPenaltiesGoals() {
        return mPenaltiesGoals;
    }

    public int getRedCardsByYellows() {
        return mRedCardsByYellows;
    }

    public int getFouls() {
        return mFouls;
    }


    public void addGoal() {
        this.mGoals++;
    }

    public void addGoalByPenalti() {
        this.mPenaltiesGoals++;
        this.mGoals++;
        this.addFoul();

    }

    public void addYellowCard(){
        this.mYellowCards++;
        this.addFoul();
        if(this.mYellowCards %2==0){
            this.addRedCard();
            mRedCardsByYellows++;
        }
    }

    public void addRedCard(){
        this.mRedCards++;
        this.addFoul();
    }

    public void addFoul(){
        this.mFouls++;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mGoals);
        parcel.writeInt(this.mPenaltiesGoals);
        parcel.writeInt(this.mFouls);
        parcel.writeInt(this.mRedCardsByYellows);
        parcel.writeInt(this.mRedCards);
        parcel.writeInt(this.mYellowCards);
    }
}
