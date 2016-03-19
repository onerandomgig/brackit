package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Match implements Serializable {

    private Team teamOne;
    private Team teamTwo;

    private String teamOneScore;
    private String teamTwoScore;
    private String location;

    private Date matchTime;

    // As defined in <code>AppConstants.WINNER_TEAM_1 and AppConstants.WINNER_TEAM_2</code>
    private int winner;
}
