package digiplus.ma.mycovid19report;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.ListItemClickListener{

    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
    //RecyclerView recyclerView;
    //data<Cdata> data;
    private Toast mToast;
    //private ArrayList<Cdata> Cdatas;
    //private MyAdapter mAdapter;
    private MyAdapter myAdapter;


    /** Adapter for the list of earthquakes */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        MyAsyncTask task = new MyAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        mToast.show();
    }

    private static class MyAsyncTask extends AsyncTask<String, Void, List<Cdata>> implements MyAdapter.ListItemClickListener {

        @Override
        protected List<Cdata> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<Cdata> data = QueryUtils.fetchEarthquakeData(urls[0]);
            return data;
        }

        @Override
        protected void onPostExecute(List<Cdata> data) {
            // Clear the adapter of previous data
            MyAdapter myAdapter = new MyAdapter(data,this);
            myAdapter.clear();

            // If there is a valid list of {@link }s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                myAdapter.addAll(data);
            }
        }

        @Override
        public void onListItemClick(int clickedItemIndex) {

        }
    }

  }