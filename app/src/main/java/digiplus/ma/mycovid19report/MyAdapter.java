package digiplus.ma.mycovid19report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String Region_data[];
    int Image[];
    Context context;
    public MyAdapter(Context ct, String region[], int Img[]){
    context = ct;
    Region_data = region;
    Image = Img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =   LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_items, parent, false);
    return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.mytxt.setText(Region_data[position]);
    //holder.myImg.setImageResource(Img[position]);
    }

    @Override
    public int getItemCount() {
        return Region_data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mytxt;
        ImageView myImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytxt = itemView.findViewById(R.id.RegionID);

            //myImg = itemView.findViewById(R.id.ImageID);
        }
    }
}
