package digiplus.ma.mycovid19report;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //RecyclerView recyclerView;
    //data<Cdata> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Cdata> Cdatas = QueryUtils.extractDATA(); // < new ArrayList<>();
        //Cdatas.add(new Cdata("Rabat","DATE1", "1"));
        //Cdatas.add(new Cdata("Rabat","DATE1", "2"));
        //Cdatas.add(new Cdata("Rabat","DATE1", "3"));

        RecyclerView recyclerView = findViewById(R.id.RootViewID);
        recyclerView.setHasFixedSize(true);
                //data = new ArrayList<>();
    //extractData();
    MyAdapter myAdapter = new MyAdapter(Cdatas);
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
}

/**µprivate void extractData(){
    *RequestQueue queue = Volley.newRequestQueue(this);
    *JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, )
*
 }**/

  }