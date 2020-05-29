package digiplus.ma.mycovid19report;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private ArrayList<Cdata> mCdatas;

    public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mRegion, mCases, mDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mRegion = itemView.findViewById(R.id.RegionID);
            mCases = itemView.findViewById(R.id.CaseID);
            mDate = itemView.findViewById(R.id.DateID);
        }
    }

    public MyAdapter(ArrayList<Cdata> Cdatas){
         mCdatas = Cdatas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        MyViewHolder MyVH = new MyViewHolder(v);
        return MyVH;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Cdata currentData = mCdatas.get(position);
        holder.mRegion.setText(currentData.getmRegion());
        holder.mCases.setText(currentData.getmCases());
        holder.mDate.setText(currentData.getmTimeInMilliseconds());
    }

    @Override
    public int getItemCount() {
        return mCdatas.size();
    }
}