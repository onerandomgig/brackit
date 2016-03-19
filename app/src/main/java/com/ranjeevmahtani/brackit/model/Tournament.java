package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;
import java.util.ArrayList;
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

    }
}
