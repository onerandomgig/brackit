package com.ranjeevmahtani.brackit.api;

public class APIManager {

    private static APIManager mSingletonInstance;
    private NetworkAccessor mNetworkAccessor;

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
}