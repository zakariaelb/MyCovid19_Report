package digiplus.ma.mycovid19report;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Cdata>> /**implements MyAdapter.ListItemClickListener*/{

        /** Tag for the log messages */
        private static final String LOG_TAG = MainActivity.class.getSimpleName();

/**
 * Constant value for the earthquake loader ID. We can choose any integer.
 * This really only comes into play if you're using multiple loaders.
 */
private static final int MYLOADER_ID=1;

/**
 * URL for earthquake data from the USGS dataset
 */
private static final String USGS_REQUEST_URL=
        "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
//RecyclerView recyclerView;
//data<Cdata> data;
private Toast mToast;
//private ArrayList<Cdata> Cdatas;
//private MyAdapter mAdapter;
private MyAdapter myAdapter;
private TextView emptyView;
        private TextView mEmptyStateTextView;

/**
 * Adapter for the list of earthquakes
 */


@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "TEST : MainActivity OnCreate() Called");
        //private MyAdapter mAdapter;
        //ArrayList<Cdata> Cdatas = QueryUtils.extractDATA(); // < new ArrayList<>();
        //ArrayList<Cdata> Cdatas = QueryUtils.fetchEarthquakeData();
        //Cdatas.add(new Cdata("Rabat","DATE1", "1"));
        //Cdatas.add(new Cdata("Rabat","DATE1", "2"));
        //Cdatas.add(new Cdata("Rabat","DATE1", "3"));


        RecyclerView recyclerView = findViewById(R.id.RootViewID);
        recyclerView.setHasFixedSize(true);
        //data = new ArrayList<>();
        //extractData();
        //myAdapter = new MyAdapter(new ArrayList<Cdata>(), this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Start the AsyncTask to fetch the earthquake data
        //MyAsyncTask task=new MyAsyncTask();
        //task.execute(USGS_REQUEST_URL);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        android.app.LoaderManager loaderManager = getLoaderManager();
        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        Log.i(LOG_TAG, "TEST : Calling initLoader...");
        loaderManager.initLoader(MYLOADER_ID,null, this);
// Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {

        }
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
/**
 * private RecyclerView recyclerView;
 * private TextView emptyView;
 *
 * // ...
 *
 * recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
 * emptyView = (TextView) rootView.findViewById(R.id.empty_view);
 *
 * // ...
 *
 * if (dataset.isEmpty()) {
 *     recyclerView.setVisibility(View.GONE);
 *     emptyView.setVisibility(View.VISIBLE);
 * }
 * else {
 *     recyclerView.setVisibility(View.VISIBLE);
 *     emptyView.setVisibility(View.GONE);
 * }
 *
 */
        }

@Override
public Loader<List<Cdata>>onCreateLoader(int i,Bundle bundle){
        // Create a new loader for the given URL
        Log.i(LOG_TAG, "TEST : onCreateLoader() is Called ...");
        return new MyLoader(this,USGS_REQUEST_URL);
        }
@Override
public void onLoadFinished(Loader<List<Cdata>> loader, List<Cdata> Cdatas){
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_data_available);

        Log.i(LOG_TAG, "TEST : onLoadFinished() is Called ...");
        // Clear the adapter of previous earthquake data
        myAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if(Cdatas!=null&&!Cdatas.isEmpty()){
        myAdapter.addAll(Cdatas);
        }
        }

@Override
public void onLoaderReset(Loader<List<Cdata>>loader){
        Log.i(LOG_TAG, "TEST : onLoaderReset() is Called ...");
        // Loader reset, so we can clear out our existing data.
        myAdapter.clear();
        }
        /**@Override
public void onListItemClick(int clickedItemIndex){
        if(mToast!=null){
        mToast.cancel();
        }
        String toastMessage="Item #"+clickedItemIndex+" clicked.";
        mToast=Toast.makeText(this,toastMessage,Toast.LENGTH_LONG);
        mToast.show();
        }*/
        }