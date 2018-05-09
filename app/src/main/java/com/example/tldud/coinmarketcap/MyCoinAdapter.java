package com.example.tldud.coinmarketcap;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyCoinAdapter extends RecyclerView.Adapter<MyCoinAdapter.ViewHolder>{


    public static class MyViewHolder extends  RecyclerView.ViewHolder {
       //안에 들어가는 값  객체 생성
    }

    //최초 생성되는 뷰 지정

    @Override
    public MyCoinAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder( MyCoinAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
