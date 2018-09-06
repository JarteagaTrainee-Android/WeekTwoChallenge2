package com.applaudostudio.weektwochallenge2;

public class Team {

    private int mYellowCards;
    private int mRedCards;
    private int mGoals;
    private int mPenaltiesGoals;
    private int mRedCardsByYellows;
    private int mFouls;
    public Team() {
        this.mYellowCards=0;
        this.mRedCards=0;
        this.mGoals=0;
        this.mPenaltiesGoals=0;
        this.mRedCardsByYellows=0;
        this.mFouls=0;
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



}
