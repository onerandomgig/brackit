package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Match implements Serializable {

    private Stage stage;

    private Team teamOne;
    private Team teamTwo;

    private String teamOneScore;
    private String teamTwoScore;
    private String location;

    private Date matchTime;

    // As defined in <code>AppConstants.WINNER_TEAM_1 and AppConstants.WINNER_TEAM_2</code>
    private int winner;

    public Match() {
    }

    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (!stage.equals(match.stage)) return false;
        if (!teamOne.equals(match.teamOne)) return false;
        return teamTwo.equals(match.teamTwo);

    }

    @Override
    public int hashCode() {
        int result = stage.hashCode();
        result = 31 * result + teamOne.hashCode();
        result = 31 * result + teamTwo.hashCode();
        return result;
    }
}
