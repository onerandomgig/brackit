package com.ranjeevmahtani.brackit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ranjeevmahtani.brackit.api.APIManager;
import com.ranjeevmahtani.brackit.constants.AppConstants;
import com.ranjeevmahtani.brackit.model.Team;
import com.ranjeevmahtani.brackit.model.Tournament;

import java.util.ArrayList;

public class TournamentSetupStep2Activity extends AppCompatActivity {

    private final String LOG_TAG = TournamentSetupStep2Activity.class.getSimpleName();

    private Tournament mTourney;
    private ArrayList<EditText> mTeamEntryViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup_step2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        mTourney = (Tournament) intent.getExtras().get(AppConstants.Extras.TOURNAMENT);

        final ArrayList<EditText> mTeamEntryViews = new ArrayList<>(mTourney.getTeams().size());
        LinearLayout teamEntryViewsContainer = (LinearLayout) findViewById(R.id.team_name_input_container);
        teamEntryViewsContainer.removeAllViews();
        for (int i = 0; i < mTourney.getTeams().size(); i++) {
            View teamEntryViewLayout =  getLayoutInflater().inflate(R.layout.tourney_team_entry_view, null, false);
            EditText teamEntryEditText = (EditText) teamEntryViewLayout.findViewById(R.id.teamEntryEditText);
            teamEntryEditText.setHint("Rank " + i + " Team Name");
            mTeamEntryViews.add(teamEntryEditText);
            teamEntryViewsContainer.addView(teamEntryEditText);
        }

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i< mTeamEntryViews.size(); i++) {
                    Team team = new Team();
                    team.setName(mTeamEntryViews.get(i).getText().toString());
                    team.setRank(i);
                    mTourney.addTeam(team);
                }
                APIManager.getInstance().addTournament(mTourney);
                Log.e(LOG_TAG, "mTourney added via APIManager");
                startActivity(new Intent(TournamentSetupStep2Activity.this, MainActivity.class));
            }
        });

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
