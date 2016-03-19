package com.ranjeevmahtani.brackit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Stage implements Serializable {

    private String name;

    // As defined in <code>AppConstants</code>
    // STAGE_STATE_NOT_STARTED, STAGE_STATE_STARTED, STAGE_STATE_COMPLETED
    private int state;

    private List<Match> matches;

    public void addMatch(Match aMatch) {
        if (matches == null) {
            matches = new ArrayList<>();
        }

        matches.add(aMatch);
    }
}
