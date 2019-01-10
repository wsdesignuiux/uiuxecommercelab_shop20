package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.vaibhav.screen20.R;

import java.util.ArrayList;

import model.Jeans_Model;

public class Jeans_Adapter extends RecyclerView.Adapter<Jeans_Adapter.ViewHolder> {

    Context context;
    ArrayList<Jeans_Model>jeans_models;

    public Jeans_Adapter(Context context, ArrayList<Jeans_Model> jeans_models) {
        this.context = context;
        this.jeans_models = jeans_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jeans,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.pant.setImageResource(jeans_models.get(position).getPant());
        holder.tv1.setText(jeans_models.get(position).getTv1());
        holder.tv2.setText(jeans_models.get(position).getTv2());
        holder.tv3.setText(jeans_models.get(position).getTv3());
    }

    @Override
    public int getItemCount() {
        return jeans_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pant;
        TextView tv1,tv2,tv3;

        public ViewHolder(View itemView) {
            super(itemView);

            pant = itemView.findViewById(R.id.pant);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
