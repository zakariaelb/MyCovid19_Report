package digiplus.ma.mycovid19report;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Cdata> mCdatas;
    private static final String LOCATION_SEPARATOR = " of ";
    private String nt = null;
    private Context ct = null;
    private GradientDrawable CasesCircle;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mRegion, mCases, mDate, mTime, dateView, OFFS;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mRegion = itemView.findViewById(R.id.RegionID);
            mCases = itemView.findViewById(R.id.CaseID);
            //mDate = itemView.findViewById(R.id.DateID);
            mTime = itemView.findViewById(R.id.timeID);
            dateView = itemView.findViewById(R.id.DateID);
            OFFS = itemView.findViewById(R.id.Region_offsetID);
            nt = itemView.getContext().getString(R.string.near_the);
            CasesCircle = (GradientDrawable) mCases.getBackground();
            ct = itemView.getContext();


        }
    }

    public MyAdapter(ArrayList<Cdata> Cdatas) {
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
        //holder.mRegion.setText(currentData.getmRegion());
        //holder.mDate.setText(currentData.getmTimeInMilliseconds());
        String mformatedCases = Formatcases(currentData.getmCases());
        holder.mCases.setText(mformatedCases);
        Date dateObject = new Date(currentData.getmTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        holder.dateView.setText(formattedDate);
        String formattedTime = formatTime(dateObject);
        holder.mTime.setText(formattedTime);

        //colors

        int CasesColor = getCasesColor(currentData.getmCases());
        CasesCircle.setColor(CasesColor);


        //split
        String originalLocation = currentData.getmRegion();
        String Region;
        String Offset;
        //check logic :
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            Offset = parts[0] + LOCATION_SEPARATOR;
            Region = parts[1];
        } else {
            //Offset = "near off "; //Resources.getSystem().getString(R.string.near_the);
            Offset = nt;
            // getContext().getString(R.string.near_the);
            Region = originalLocation;
        }
        holder.OFFS.setText(Offset);
        holder.mRegion.setText(Region);
    }

    @Override
    public int getItemCount() {
        return mCdatas.size();
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        java.text.SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String Formatcases(double cases) {
        DecimalFormat casesFormat = new DecimalFormat("0.0");
        return casesFormat.format(cases);
    }

    //Helper Colors code :

    private int getCasesColor(double cases) {
        int caseColorResourceId;
        int caseFloor = (int) Math.floor(cases);
        switch (caseFloor) {
            case 0:
            case 1:
                caseColorResourceId = R.color.Level1;
                break;
            case 2:
                caseColorResourceId = R.color.Level2;
                break;
            case 3:
                caseColorResourceId = R.color.Level3;
                break;
            case 4:
                caseColorResourceId = R.color.Level4;
                break;
            case 5:
                caseColorResourceId = R.color.Level5;
                break;
            case 6:
                caseColorResourceId = R.color.Level6;
                break;
            case 7:
                caseColorResourceId = R.color.Level7;
                break;
            case 8:
                caseColorResourceId = R.color.Level8;
                break;
            case 9:
                caseColorResourceId = R.color.Level9;
                break;
            default:
                caseColorResourceId = R.color.Level10;
                break;
        }
        return ContextCompat.getColor(ct, caseColorResourceId);
    }

}