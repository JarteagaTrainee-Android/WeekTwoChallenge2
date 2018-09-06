package com.applaudostudio.weektwochallenge2;

import android.os.PersistableBundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String KEY_TEAMA="teamA";
    public final static String KEY_TEAMB="teamB";
    Team teamA;
    Team teamB;
    TextView txtGeneralGoalsA;
    TextView txtGoalsA;
    TextView txtPenaltiesA;
    TextView txtFoulsA;
    TextView txtYellowCardsA;
    TextView txtDoubleYellowA;
    TextView txtRedCardsA;

    TextView txtGeneralGoalsB;
    TextView txtGoalsB;
    TextView txtPenaltiesB;
    TextView txtFoulsB;
    TextView txtYellowCardsB;
    TextView txtDoubleYellowB;
    TextView txtRedCardsB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Team A
        teamA = new Team();
        txtGeneralGoalsA = findViewById(R.id.textViewScoreA);
        txtGoalsA = findViewById(R.id.textViewGoalsA);
        txtPenaltiesA = findViewById(R.id.textViewPenaltiesGoalsA);
        txtFoulsA = findViewById(R.id.textViewFoulsA);
        txtYellowCardsA = findViewById(R.id.textViewYellowCardsA);
        txtDoubleYellowA = findViewById(R.id.textViewDoubleYellowCardsA);
        txtRedCardsA = findViewById(R.id.textViewRedCardsA);

        txtGeneralGoalsA.setOnClickListener(this);
        txtGoalsA.setOnClickListener(this);
        txtPenaltiesA.setOnClickListener(this);
        txtFoulsA.setOnClickListener(this);
        txtYellowCardsA.setOnClickListener(this);
        txtDoubleYellowA.setOnClickListener(this);
        txtRedCardsA.setOnClickListener(this);


        //Team B
        teamB = new Team();
        txtGeneralGoalsB = findViewById(R.id.textViewScoreB);
        txtGoalsB = findViewById(R.id.textViewGoalsB);
        txtPenaltiesB = findViewById(R.id.textViewGoalsByPenaltiesB);
        txtFoulsB = findViewById(R.id.textViewFoulsB);
        txtYellowCardsB = findViewById(R.id.textViewYellowCardsB);
        txtDoubleYellowB = findViewById(R.id.textViewDoubleYellowCardsB);
        txtRedCardsB = findViewById(R.id.textViewRedCardsB);

        txtGeneralGoalsB.setOnClickListener(this);
        txtGoalsB.setOnClickListener(this);
        txtPenaltiesB.setOnClickListener(this);
        txtFoulsB.setOnClickListener(this);
        txtYellowCardsB.setOnClickListener(this);
        txtDoubleYellowB.setOnClickListener(this);
        txtRedCardsB.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewGoalsA:
            case R.id.textViewScoreA:
                teamA.addGoal();
                txtGeneralGoalsA.setText(String.valueOf(teamA.getGoals()));
                txtGoalsA.setText(setStringStatisticsA(R.string.goals, teamA.getGoals()));
                break;
            case R.id.textViewPenaltiesGoalsA:
                teamA.addGoalByPenalti();
                txtFoulsA.setText(setStringStatisticsA(R.string.fouls, teamA.getFouls()));
                txtGeneralGoalsA.setText(String.valueOf(teamA.getGoals()));
                txtGoalsA.setText(setStringStatisticsA(R.string.goals, teamA.getGoals()));
                txtPenaltiesA.setText(setStringStatisticsA(R.string.goals_by_penalties, teamA.getPenaltiesGoals()));
                break;
            case R.id.textViewFoulsA:
                teamA.addFoul();
                txtFoulsA.setText(setStringStatisticsA(R.string.fouls, teamA.getFouls()));
                break;
            case R.id.textViewYellowCardsA:
                teamA.addYellowCard();
                txtDoubleYellowA.setText(setStringStatisticsA(R.string.double_yellow_cards, teamA.getRedCardsByYellows()));
                txtYellowCardsA.setText(setStringStatisticsA(R.string.yellow_cards, teamA.getYellowCards()));
                txtRedCardsA.setText(setStringStatisticsA(R.string.red_cars,teamA.getRedCards()));
                break;
            case R.id.textViewRedCardsA:
                teamA.addRedCard();
                txtRedCardsA.setText(setStringStatisticsA(R.string.red_cars,teamA.getRedCards()));
                break;
            case R.id.textViewGoalsB:
            case R.id.textViewScoreB:
                teamB.addGoal();
                txtGeneralGoalsB.setText(String.valueOf(teamB.getGoals()));
                txtGoalsB.setText(setStringStatisticsB(R.string.goals, teamB.getGoals()));
                break;
            case R.id.textViewGoalsByPenaltiesB:
                teamB.addGoalByPenalti();
                txtFoulsB.setText(setStringStatisticsB(R.string.fouls, teamB.getFouls()));
                txtGeneralGoalsB.setText(String.valueOf(teamB.getGoals()));
                txtGoalsB.setText(setStringStatisticsB(R.string.goals, teamB.getGoals()));
                txtPenaltiesB.setText(setStringStatisticsB(R.string.goals_by_penalties, teamB.getPenaltiesGoals()));
                break;
            case R.id.textViewFoulsB:
                teamB.addFoul();
                txtFoulsB.setText(setStringStatisticsB(R.string.fouls, teamB.getFouls()));
                break;
            case R.id.textViewYellowCardsB:
                teamB.addYellowCard();
                txtDoubleYellowB.setText(setStringStatisticsB(R.string.double_yellow_cards, teamB.getRedCardsByYellows()));
                txtYellowCardsB.setText(setStringStatisticsB(R.string.yellow_cards, teamB.getYellowCards()));
                txtRedCardsB.setText(setStringStatisticsB(R.string.red_cars,teamB.getRedCards()));
                break;
            case R.id.textViewRedCardsB:
                teamB.addRedCard();
                txtRedCardsB.setText(setStringStatisticsB(R.string.red_cars,teamB.getRedCards()));
                break;



        }
    }

    public String setStringStatisticsA(@StringRes int idRes, int quantity) {
        String var = getString(idRes);
        return var +
                " : " +
                quantity;
    }

    public String setStringStatisticsB(@StringRes int idRes, int quantity) {
        String var = getString(idRes);
        return String.valueOf(quantity) +
                " : " +
                var;
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_TEAMA,teamA);
        outState.putParcelable(KEY_TEAMB,teamB);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null) {
            teamA = savedInstanceState.getParcelable(KEY_TEAMA);
            teamB = savedInstanceState.getParcelable(KEY_TEAMB);


            txtGeneralGoalsA.setText(String.valueOf(teamA.getGoals()));
            txtGoalsA.setText(setStringStatisticsA(R.string.goals, teamA.getGoals()));
            txtFoulsA.setText(setStringStatisticsA(R.string.fouls, teamA.getFouls()));
            txtPenaltiesA.setText(setStringStatisticsA(R.string.goals_by_penalties, teamA.getPenaltiesGoals()));
            txtDoubleYellowA.setText(setStringStatisticsA(R.string.double_yellow_cards, teamA.getRedCardsByYellows()));
            txtYellowCardsA.setText(setStringStatisticsA(R.string.yellow_cards, teamA.getYellowCards()));
            txtRedCardsA.setText(setStringStatisticsA(R.string.red_cars,teamA.getRedCards()));

            txtGeneralGoalsB.setText(String.valueOf(teamB.getGoals()));
            txtFoulsB.setText(setStringStatisticsB(R.string.fouls, teamB.getFouls()));
            txtGoalsB.setText(setStringStatisticsB(R.string.goals, teamB.getGoals()));
            txtPenaltiesB.setText(setStringStatisticsB(R.string.goals_by_penalties, teamB.getPenaltiesGoals()));
            txtDoubleYellowB.setText(setStringStatisticsB(R.string.double_yellow_cards, teamB.getRedCardsByYellows()));
            txtYellowCardsB.setText(setStringStatisticsB(R.string.yellow_cards, teamB.getYellowCards()));
            txtRedCardsB.setText(setStringStatisticsB(R.string.red_cars,teamB.getRedCards()));




        }
    }


}
