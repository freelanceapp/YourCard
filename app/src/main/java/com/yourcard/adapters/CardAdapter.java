package com.yourcard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yourcard.R;
import com.yourcard.activities_fragments.activity_home.HomeActivity;
import com.yourcard.activities_fragments.activity_login.LoginActivity;
import com.yourcard.activities_fragments.activtitycards.CardsActivity;
import com.yourcard.databinding.CardRowBinding;
import com.yourcard.databinding.CountriesRowBinding;
import com.yourcard.models.CountryModel;
import com.yourcard.models.SingleRestaurantModel;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SingleRestaurantModel.MenuImages> list;
    private Context context;
    private LayoutInflater inflater;
    private int lastPosition = -1;

    public CardAdapter(List<SingleRestaurantModel.MenuImages> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CardRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context instanceof  HomeActivity){
                HomeActivity activity = (HomeActivity) context;
                activity.showite();}
                else {
                    CardsActivity activity = (CardsActivity) context;
                    activity.showite();
                }
            }

        });
//        Runnable startAnimation = new Runnable() {
//            @Override
//            public void run() {
//                setAnimation(myHolder.itemView, position);
//
//            }
//        };
//        myHolder.itemView.postDelayed(startAnimation, 200);
    }

    private void setAnimation(View viewToAnimate, int position) {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition) {
//            Animation animation = AnimationUtils.loadAnimation(context, R.anim.top_down_anim);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public CardRowBinding binding;

        public MyHolder(@NonNull CardRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
