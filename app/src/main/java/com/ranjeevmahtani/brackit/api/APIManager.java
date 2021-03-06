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

        if (tournamentsList == null) {
            tournamentsList = new ArrayList<>();
        }
        return tournamentsList;
    }
}