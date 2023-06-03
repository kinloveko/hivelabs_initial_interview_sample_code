package com.example.kenneth_dela_cruz_android_developer.Navigations;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.kenneth_dela_cruz_android_developer.R;
import com.example.kenneth_dela_cruz_android_developer.made_for_you_class;
import com.example.kenneth_dela_cruz_android_developer.recycler_adapter;

import java.util.ArrayList;
import java.util.List;

public class nav_home_fragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_home, container, false);
    }

    RecyclerView recyclerView;
    recycler_adapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.first_pic, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.second_pic, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.third_pic, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new recycler_adapter(getContext());
        List<made_for_you_class> addList = new ArrayList<>();
        made_for_you_class first = new made_for_you_class(R.drawable.hive_one,"We Are Trusted By Major Brands In The Philippines","✅ 100% Success Rate Delivery Is Our Pride..\n" +
                "✅  Guaranteed Service Success..  \n✅  Proven Methodologies");
        addList.add(first);
        made_for_you_class second = new made_for_you_class(R.drawable.hive_two,"Hivelabs Technologies has been empowering enterprises", "✅ Well-Seasoned IT Management\n" +
                "✅ Reliable Skilled IT Professionals");
        addList.add(second);
        made_for_you_class third = new made_for_you_class(R.drawable.hive_three,"Offering The Most Reliable Software Development And IT Solutions","Start your business' digital transformation journey the right way with us. Improve your business process efficiency, provide better experiences for your customers, and grow your business with well-engineered applications.");
        addList.add(third);
        made_for_you_class fourth = new made_for_you_class(R.drawable.hive_three,"HiveLabs Technologies provides Full-Stack Software Application Development Service.","✅ 100% Success Rate Delivery Is Our Pride..\n" +
                "✅  Guaranteed Service Success..  \n✅  Proven Methodologies");
        addList.add(fourth);

        adapter.addImage(addList);
        recyclerView.setAdapter(adapter);

    }

}