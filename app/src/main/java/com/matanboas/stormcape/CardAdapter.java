package com.matanboas.stormcape;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    // A list of cards to display
    private List<Card> cardList;

    public CardAdapter(List<Card> cardList) {
        this.cardList = cardList;
    }

    // A view holder class that holds the views for each card
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public CardViewHolder(View itemView) {
            super(itemView);
        }
    }

    // This method creates a new view holder for each card
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the card layout from the xml file
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        // Create a new view holder with the view
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    // This method binds the data to the views for each card
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        // Get the card at the given position
        Card card = cardList.get(position);

        // get the weather icon and set it to the ImageView
        ImageView weatherIcon = holder.itemView.findViewById(R.id.weather_icon);
        weatherIcon.setImageResource(card.getWeatherIcon());

        // set the temperature to the TextView
        TextView temperature = holder.itemView.findViewById(R.id.temperature);
        temperature.setText(card.getTemperature());

        // set the location to the TextView
        TextView location = holder.itemView.findViewById(R.id.location);
        location.setText(card.getLocation());
    }

    // This method returns the number of cards in the list
    @Override
    public int getItemCount() {
        return cardList.size();
    }
}