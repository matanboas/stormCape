package com.matanboas.stormcape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardAdapter cardAdapter;
    List<Card> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RecyclerView by its id
        recyclerView = findViewById(R.id.recycler_view);

        // create a list of towns to display
        List<String> townList = new ArrayList<>();
        townList.add("jerusalem");
        townList.add("Cape Town");
        townList.add("Johannesburg");
        townList.add("Durban");
        townList.add("Pretoria");
        townList.add("Port Elizabeth");
        townList.add("Bloemfontein");
        townList.add("London");

        // create a list of cards to display
        cardList = new ArrayList<>();

        // add a new card with the current weather data for Jerusalem
        OpenWeather openWeather = new OpenWeather();
        for (String town : townList) {
            Card card = new Card();
            openWeather.getCurrentWeather(town, new WeatherDataCallback() {
                @Override
                public void onSuccess(WeatherData data) {
                    card.SetCard(data);
                    cardAdapter.notifyDataSetChanged();
                    Log.d("MainActivity", "Weather data received");
                }

                @Override
                public void onFailure(Throwable error) {
                    Log.e("MainActivity", "Error getting weather data", error);
                }
            });

            cardList.add(card);
        }

        // Find the RecyclerView by its id
        recyclerView = findViewById(R.id.recycler_view);

        // Create a new adapter with the list of cards
        cardAdapter = new CardAdapter(cardList);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(cardAdapter);

        // update the ui
        cardAdapter.notifyDataSetChanged();
    }
}