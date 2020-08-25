package com.yourcard.activities_fragments.activity_home.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.yourcard.R;
import com.yourcard.activities_fragments.activity_home.HomeActivity;
import com.yourcard.adapters.SiteAdapter;
import com.yourcard.databinding.FragmentDiscountCopounBinding;
import com.yourcard.models.SingleRestaurantModel;
import com.yourcard.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class FragmentDiscountCoupons extends Fragment {
    private HomeActivity activity;
    private FragmentDiscountCopounBinding binding;
    private Preferences preferences;
    private String lang;
    private List<SingleRestaurantModel.MenuImages> menuImagesList;
    private SiteAdapter adapter;

    public static FragmentDiscountCoupons newInstance() {
        return new FragmentDiscountCoupons();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discount_copoun, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();


    }


    private void initView() {
        menuImagesList = new ArrayList<>();
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        Paper.init(activity);
        adapter = new SiteAdapter(menuImagesList, activity);
        binding.discreteScrollView.setAdapter(adapter);
        binding.discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(0.1f)
                .setMinScale(0.1f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.BOTTOM)
                .build());
        updateUI();
    }

    private void updateUI() {
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        menuImagesList.add(new SingleRestaurantModel.MenuImages());
        adapter.notifyDataSetChanged();

    }

}
