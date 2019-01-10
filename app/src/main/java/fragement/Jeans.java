package fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.vaibhav.screen20.R;

import java.util.ArrayList;

import adapter.Jeans_Adapter;
import model.Jeans_Model;


public class Jeans extends Fragment {

    private RecyclerView recyclerView;
    private Jeans_Adapter jeans_adapter;
    private ArrayList<Jeans_Model> jeans_models;

    Integer pant[] = {R.drawable.pic, R.drawable.pic1, R.drawable.pic2,R.drawable.pic3,R.drawable.pic4
            , R.drawable.pic5, R.drawable.pic,R.drawable.pic1};
    String tv1[] = {"$ 267","$ 345","$ 342","$ 356","$ 356","$ 342","$ 356","$ 356"};
    String tv2[] = {"Fit Jeans", "Good Jeans", "Jeans","Skinny Jeans","Skinny Jeans", "Jeans","Skinny Jeans","Skinny Jeans"};
    String tv3[] = {"NAVY BLUE WASHED MID","NAVY BLUE SOLID SKINNY", "BLUE WASHED LOW RISE SKINNY",
            "LIGHT BLUE ","LIGHT BLUE ", "BLUE WASHED LOW RISE SKINNY",
            "LIGHT BLUE ","LIGHT BLUE "};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jeans, container, false);

        recyclerView = view.findViewById(R.id.jeans);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        jeans_models = new ArrayList<>();

        for (int i = 0; i < pant.length; i++) {
            Jeans_Model ab = new Jeans_Model(pant[i], tv1[i], tv2[i], tv3[i]);
            jeans_models.add(ab);
        }
        jeans_adapter = new Jeans_Adapter(getActivity(), jeans_models);
        recyclerView.setAdapter(jeans_adapter);
        return view;
    }
}
