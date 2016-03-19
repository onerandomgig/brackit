package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Team implements Serializable, Comparable {

    private String name;
    private String icon;

    private int rank;

    private String teamInfo;

    public Team() {}

    public Team(String aName) {
        name = aName;
    }

    @Override
    public int compareTo(Object another) {
        return rank - ((Team)another).getRank();
    }
}
