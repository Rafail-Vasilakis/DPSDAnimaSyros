package com.example.dpsdanimasyros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Slider_Adapter extends RecyclerView.Adapter<Slider_Adapter.OnBoardingViewHolder>{


    private List<OnBoardingItems> onBoardingItems;

    public Slider_Adapter(List<OnBoardingItems> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }


    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                       R.layout.activity_direction_layout, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
            holder.setSlider_Adapter_Data(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingViewHolder  extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView text1;
        private TextView text2;
        private TextView text3;

        private ImageView image;
        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.information);
            text1 = itemView.findViewById(R.id.first_info1);
            text2 = itemView.findViewById(R.id.first_info2);
            text3 = itemView.findViewById(R.id.first_info3);
            image = itemView.findViewById(R.id.position_dots);
        }

        void setSlider_Adapter_Data(OnBoardingItems onBoardingItems) {
            textTitle.setText(onBoardingItems.getTitle());
            text1.setText(onBoardingItems.getText1());
            text2.setText(onBoardingItems.getText2());
            text3.setText(onBoardingItems.getText3());
            image.setImageResource(onBoardingItems.getImage());
        }
    }

}
