package com.ranjeevmahtani.brackit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ranjeevmahtani.brackit.constants.AppConstants;
import com.ranjeevmahtani.brackit.model.Team;
import com.ranjeevmahtani.brackit.model.Tournament;

import java.util.ArrayList;

public class TournamentSetupStep1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup_step_1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.tourney_name_input)).getText().toString();
                EditText teamCountInput = (EditText) findViewById(R.id.tourney_team_count_input);
                int teamCount;
                if (teamCountInput.getText() != null && !teamCountInput.getText().toString().isEmpty()) {
                    teamCount = (Integer.valueOf(teamCountInput.getText().toString()));
                } else {
                    Toast.makeText(TournamentSetupStep1Activity.this, "You need at least 2 teams", Toast.LENGTH_SHORT).show();
                    return;
                }


                String sport = ((EditText) findViewById(R.id.tourney_sport_input)).getText().toString();
                String start = ((EditText) findViewById(R.id.tourney_start_time_input)).getText().toString();
                String end = ((EditText) findViewById(R.id.tourney_end_time_input)).getText().toString();

                Tournament tourney = new Tournament();
                tourney.setName(name);
                tourney.setTeams(new ArrayList<Team>(teamCount));
                tourney.setSport(sport);
                tourney.setStartDate(start);
                tourney.setEndDate(end);

                Intent intent = new Intent(TournamentSetupStep1Activity.this, TournamentSetupStep2Activity.class);
                Bundle args = new Bundle();
                args.putSerializable(AppConstants.Extras.TOURNAMENT, tourney);
                startActivity(intent);
            }
        });

        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
