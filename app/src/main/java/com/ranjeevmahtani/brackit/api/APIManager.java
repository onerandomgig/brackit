package com.ranjeevmahtani.brackit.api;

import com.ranjeevmahtani.brackit.constants.AppConstants;
import com.ranjeevmahtani.brackit.model.Tournament;
import com.ranjeevmahtani.brackit.model.User;

import java.util.ArrayList;
import java.util.List;

public class APIManager {

    private static APIManager mSingletonInstance;
    private NetworkAccessor mNetworkAccessor;

    private List<Tournament> tournamentsList;

    private APIManager() {
        mNetworkAccessor = NetworkAccessor.getInstance();
    }

    /**
     * Get the singleton instance of the APIManager.
     *
     * @return
     */
    public static synchronized APIManager getInstance() {
        if (mSingletonInstance == null) {
            mSingletonInstance = new APIManager();
        }

        return mSingletonInstance;
    }

    public User login(String aEmail, String aPassword) {
        User lLoggedInUser = new User();
        lLoggedInUser.setName("Brack It");
        lLoggedInUser.setRole(AppConstants.ROLE_ADMIN);

        return lLoggedInUser;
    }

    public void addTournament(Tournament aTournament) {
        if (tournamentsList == null) {
            tournamentsList = new ArrayList<>();
        }

        tournamentsList.add(aTournament);
    }

    public List<Tournament> getTournaments() {

        if (tournamentsList != null) {
            return tournamentsList;
        }

        Tournament lTournament1 = new Tournament();
        lTournament1.setName("Soccer Tournament 1");
        lTournament1.setSport("Soccer");
        lTournament1.setLocation("San Francisco");

        Tournament lTournament2 = new Tournament();
        lTournament2.setName("Soccer Tournament 2");
        lTournament2.setSport("Soccer");
        lTournament2.setLocation("San Francisco");

        Tournament lTournament3 = new Tournament();
        lTournament3.setName("Soccer Tournament 3");
        lTournament3.setSport("Soccer");
        lTournament3.setLocation("San Francisco");

        addTournament(lTournament1);
        addTournament(lTournament2);
        addTournament(lTournament3);

        return tournamentsList;
    }
}