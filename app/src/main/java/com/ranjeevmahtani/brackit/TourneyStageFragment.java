package com.ranjeevmahtani.brackit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ranjeevmahtani.brackit.model.Match;
import com.ranjeevmahtani.brackit.model.Stage;


/**
 * A simple {@link Fragment} subclass.
 */
public class TourneyStageFragment extends Fragment {

    private Stage mStage;

    public TourneyStageFragment() {
        // Required empty public constructor
    }

    public static TourneyStageFragment newInstance(Stage stage) {
        TourneyStageFragment fragment = new TourneyStageFragment();
        fragment.mStage = stage;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_tourney_stage, container, false);

        rootView.removeAllViews();

        for (Match match : mStage.getMatches()) {
            View view = inflater.inflate(R.layout.bracket_match_item, null, false);
            ((TextView)view.findViewById(R.id.team_1_name)).setText(match.getTeamOne().getName());
            ((TextView)view.findViewById(R.id.team_2_name)).setText(match.getTeamTwo().getName());

            ((TextView)view.findViewById(R.id.team_1_score)).setText(match.getTeamOneScore());
            ((TextView)view.findViewById(R.id.team_2_score)).setText(match.getTeamTwoScore());

            rootView.addView(view);

        }

        return rootView;

    }

}
