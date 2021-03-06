package com.example.tldud.coinmarketcap;


import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCoinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //arraylist로 안에 coin,usd 값을 넣기

    private List<Coin> coinList;


    public MyCoinAdapter(List<Coin> coinList){
        this.coinList = coinList;
    }


    //최초 생성되는 뷰 지정

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder)holder;

        viewHolder.c_id.setText(String.valueOf(coinList.get(position).getId()));
        viewHolder.c_name.setText(coinList.get(position).getName());
        viewHolder.c_symbol.setText(coinList.get(position).getSymbol());
        viewHolder.c_web.setText(coinList.get(position).getWebsiteSlug());
        viewHolder.c_rank.setText(String.valueOf(coinList.get(position).getRank()));
        viewHolder.c_cir.setText(String.valueOf(coinList.get(position).getCirculation_supply()));
        viewHolder.c_total.setText(String.valueOf(coinList.get(position).getTotal_supply()));
        viewHolder.c_max.setText(String.valueOf(coinList.get(position).getMax_supply()));
        viewHolder.c_price.setText(String.valueOf( coinList.get(position).getQuotes().getUsd().getPrice()));
        viewHolder.c_vol.setText(String.valueOf( coinList.get(position).getQuotes().getUsd().getVolume_24h()));
        viewHolder.c_market.setText(String.valueOf( coinList.get(position).getQuotes().getUsd().getMarket_cap()));
        viewHolder.c_1h.setText(String.valueOf( coinList.get(position).getQuotes().getUsd().getPercent_change_1h()));
        viewHolder.c_24h.setText(String.valueOf( coinList.get(position).getQuotes().getUsd().getPercent_change_24h()));
        viewHolder.c_7d.setText(String.valueOf(coinList.get(position).getQuotes().getUsd().getPercent_change_7d()));
        viewHolder.c_last.setText(String.valueOf(coinList.get(position).getLast_updated()));

    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {



        TextView c_id;
        TextView c_name;
        TextView c_symbol;
        TextView c_web;
        TextView c_rank;
        TextView c_cir;
        TextView c_total;
        TextView c_max;
        TextView c_price;
        TextView c_vol;
        TextView c_market;
        TextView c_1h;
        TextView c_24h;
        TextView c_7d;
        TextView c_last;

        public ViewHolder(View itemView) {
            super(itemView);

            c_id = itemView.findViewById(R.id.c_id);
            c_name = itemView.findViewById(R.id.c_name);
            c_symbol = itemView.findViewById(R.id.c_symbol);
            c_web = itemView.findViewById(R.id.c_web);
            c_rank = itemView.findViewById(R.id.c_rank);
            c_cir = itemView.findViewById(R.id.c_cir);
            c_total = itemView.findViewById(R.id.c_total);
            c_max = itemView.findViewById(R.id.c_max);
            c_price = itemView.findViewById(R.id.c_price);
            c_vol = itemView.findViewById(R.id.c_vol);
            c_market = itemView.findViewById(R.id.c_market);
            c_1h = itemView.findViewById(R.id.c_1h);
            c_24h = itemView.findViewById(R.id.c_24h);
            c_7d = itemView.findViewById(R.id.c_7d);
            c_last = itemView.findViewById(R.id.c_last);
        }
    }

   /* private class Network extends AsyncTask<Call, Void, String> {


        @Override
        protected String doInBackground(Call... params) {
            try{
                Call<ArrayList<Coin>> call = params[0];
                Response<ArrayList<Coin>> response = call.execute();
                return  response.body().toString();

            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

    }*/
}





