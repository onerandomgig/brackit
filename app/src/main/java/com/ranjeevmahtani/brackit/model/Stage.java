package com.ranjeevmahtani.brackit.model;

import com.ranjeevmahtani.brackit.constants.AppConstants;

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

    public Stage(String aName) {
        name = aName;
        state = AppConstants.STAGE_STATE_NOT_STARTED;
    }

    public void addMatch(Match aMatch) {
        if (matches == null) {
            matches = new ArrayList<>();
        }

        aMatch.setStage(this);
        matches.add(aMatch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        return name.equals(stage.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
