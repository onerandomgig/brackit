package com.ranjeevmahtani.brackit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ranjeevmahtani.brackit.constants.AppConstants;
import com.ranjeevmahtani.brackit.model.Tournament;

public class BracketActivity extends AppCompatActivity {

    private Tournament mTourney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);
        Intent intent = getIntent();
        mTourney = (Tournament) intent.getExtras().get(AppConstants.Extras.TOURNAMENT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mTourney.getName());
        setSupportActionBar(toolbar);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(new StageAdapter(getSupportFragmentManager()));
    }

    public class StageAdapter extends FragmentStatePagerAdapter{

        public StageAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TourneyStageFragment.newInstance(mTourney.getStages().get(position));

        }

        @Override
        public int getCount() {
            return mTourney.getStages().size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTourney.getStages().get(position).getName();
        }
    }

}
