package com.applaudostudio.weektwochallenge2;

public class Team {
    private int mYelowCards;
    private int mRedCards;
    private int mGolas;
    private int mPenaltiesGoals;
    private int mRedCardsByYellows;
    private int mFouls;


    public int getmYelowCards() {
        return mYelowCards;
    }

    public int getmRedCards() {
        return mRedCards;
    }

    public int getmGolas() {
        return mGolas;
    }

    public int getmPenaltiesGoals() {
        return mPenaltiesGoals;
    }

    public int getmRedCardsByYellows() {
        return mRedCardsByYellows;
    }

    public int getmFouls() {
        return mFouls;
    }


    public void addGoal() {
        this.mGolas++;
    }

    public void addGoalByPenalti() {
        this.mPenaltiesGoals++;
        this.mGolas++;

    }

    public void addYellowCard(){
        this.mYelowCards++;
        if(this.mYelowCards%2==0){
            mRedCards++;
            mRedCardsByYellows++;
        }
    }

    public void addRedCard(){
        this.mRedCards++;
    }

    public void addFoul(){
        this.mFouls++;
    }



}
