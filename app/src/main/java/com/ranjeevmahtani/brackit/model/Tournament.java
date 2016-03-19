package com.ranjeevmahtani.brackit.model;

import com.ranjeevmahtani.brackit.constants.AppConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Tournament implements Serializable {

    private String name;
    private String icon;
    private String sport;
    private String location;

    private Date startDate;
    private Date endDate;

    private int numOfTeams;

    private List<Stage> stages;
    private List<Team> teams;

    private int totalMatches;

    public void addTeam(Team aTeam) {
        if (teams == null) {
            teams = new ArrayList<>();
        }

        teams.add(aTeam);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void organize() {

        _initializeStages();

        List<Team> lGroupA = new ArrayList<>();
        List<Team> lGroupB = new ArrayList<>();

        Collections.sort(teams);

        for(int lIdx = 0; lIdx < teams.size(); lIdx++) {
            if (lIdx % 2 == 0) {
                lGroupA.add(teams.get(lIdx));
            } else {
                lGroupB.add(teams.get(lIdx));
            }
        }
        Collections.reverse(lGroupB);

        int lIdx = 0;
        for (Match lMatch : stages.get(0).getMatches()) {
            lMatch.setTeamOne(lGroupA.get(lIdx));
            lMatch.setTeamTwo(lGroupA.get(lIdx));

            lIdx++;
        }

        stages.get(0).setState(AppConstants.STAGE_STATE_STARTED);
    }

    private void _initializeStages() {

        stages = new ArrayList<>();

        int lNumStages = 0;

        int lNumTeams = numOfTeams;
        while (lNumTeams / 2 != 0) {
            lNumTeams = lNumTeams / 2;
            lNumStages++;
        }

        Stage lStage;
        for (int lIdx = 1; lIdx <= (lNumStages - 2); lIdx++) {
            lStage = new Stage("Round of " + numOfTeams / (2 * lIdx));
            stages.add(lStage);

            _setupMatches(lStage, numOfTeams / 2);
        }

        lStage = new Stage("Semi-Finals");
        stages.add(lStage);
        _setupMatches(lStage, 2);

        lStage = new Stage("Finals");
        stages.add(lStage);
        _setupMatches(lStage, 1);
    }

    private void _setupMatches(Stage aStage, int aNumOfMatches) {

        Match lMatch;
        for (int lIdx = 0; lIdx < aNumOfMatches; lIdx++) {
            lMatch = new Match(new Team('A' + totalMatches + ""), new Team('B' + totalMatches + ""));
            totalMatches += 2;

            aStage.addMatch(lMatch);
        }
    }
}