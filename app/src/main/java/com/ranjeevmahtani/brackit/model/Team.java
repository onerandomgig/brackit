package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Team implements Serializable {

    private String name;
    private String icon;

    private int rank;

    private String teamInfo;
}
