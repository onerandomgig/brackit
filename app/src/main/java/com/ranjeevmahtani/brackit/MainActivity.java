package com.ranjeevmahtani.brackit;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ranjeevmahtani.brackit.model.Tournament;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class TourneyListAdapter extends ArrayAdapter<Tournament> {

        private ArrayList<Tournament> tourneytList;

        public TourneyListAdapter(Context context, ArrayList<Tournament> tourneyList){
            super(context,R.layout.tournament_list_item);
            this.tourneytList = tourneyList;
        }

        public void setTourneyList(ArrayList<Tournament> tourneys){
            this.tourneytList = tourneys;
            notifyDataSetChanged();
        }


        @Override
        public Tournament getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Tournament tourney = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.tournament_list_item, parent, false);
            }
            // Lookup view for data population
            TextView tourneyName = (TextView) convertView.findViewById(R.id.tourney_name);
            TextView tourneySport = (TextView) convertView.findViewById(R.id.tourney_sport);
            TextView tourneyLocation = (TextView) convertView.findViewById(R.id.tourney_location);

            // Populate the data into the template view using the data object
            tourneyName.setText(tourney.getName());
            tourneySport.setText(tourney.getSport());
            tourneyLocation.setText(tourney.getLocation());
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
