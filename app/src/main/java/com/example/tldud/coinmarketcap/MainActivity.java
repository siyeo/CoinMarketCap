package com.example.tldud.coinmarketcap;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    String rootURL = "https://api.coinmarketcap.com/v2/ticker/?limit=10";
    ArrayList<Coin> coinArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        //url로 값 넣어주기




        Quotes quotes = new Quotes(new USD());

        //adapter() 안에도 값 넣어주기
        MyCoinAdapter myCoinAdapter = new MyCoinAdapter(coinArrayList);
        mRecyclerView.setAdapter(myCoinAdapter);

    }
}
