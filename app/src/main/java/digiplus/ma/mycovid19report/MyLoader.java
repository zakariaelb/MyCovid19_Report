package digiplus.ma.mycovid19report;

import android.content.Context;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

/**
     * Loads a list of earthquakes by using an AsyncTask to perform the
     * network request to the given URL.
     */
    public class MyLoader extends AsyncTaskLoader<List<Cdata>> {

        /** Tag for log messages */
        private static final String LOG_TAG = MyLoader.class.getName();

        /** Query URL */
        private String mUrl;

        /**
         * Constructs a new {@link MyLoader}.
         *
         * @param context of the activity
         * @param url to load data from
         */
        public MyLoader(Context context, String url) {
            super(context);
            mUrl = url;
        }

        @Override
        protected void onStartLoading() {
            Log.i(LOG_TAG, "TEST : onStartLoading() is Called ...");
            forceLoad();
        }

        /**
         * This is on a background thread.
         */
        @Override
        public List<Cdata> loadInBackground() {
            Log.i(LOG_TAG, "TEST : loadInBackground() is Called ...");
            if (mUrl == null) {
                return null;
            }

            // Perform the network request, parse the response, and extract a list of earthquakes.
            List<Cdata> Cdatas = QueryUtils.fetchEarthquakeData(mUrl);
            return Cdatas;
        }
    }