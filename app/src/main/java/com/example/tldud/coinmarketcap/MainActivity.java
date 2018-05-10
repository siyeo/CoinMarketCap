package com.example.tldud.coinmarketcap;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        listView = findViewById(R.id.re)
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        //url로 값 넣어주기

        //interface만들기
        //연결하는 인트로핏 만들기
        //연결해주기



        //adapter() 안에도 값 넣어주기
        MyCoinAdapter myCoinAdapter = new MyCoinAdapter(coinArrayList);
        mRecyclerView.setAdapter(myCoinAdapter);

    }

    //coin의 정보를 api 요청으로 받아오고 리사이클러 뷰를 통해 보여준다
    private void getCoinData() {

        try{

            //클라이언트 인스턴스 생성 ( 기본 셋팅 된 retrofit 객체)
            Client client = new Client();
            RetrofitService service = client.getRetrofit().create(RetrofitService.class);

            //작성한 인터페이스에 있는 getcoininfo메서드를 이용해 api요청
            Call<CoinResponse> coinResponseCall = service.getcoininfo();
            //callback 메서드 작성
            coinResponseCall.enqueue(new Callback<CoinResponse>() {

                //요청 성공
                @Override
                public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {

                    //resonse.body()는 coinResponse모델 객체를 반환
                    if(response.body() != null) {
                        ArrayList<Coin> coinArrayList = response.body().getCoinArrayList();

                        //recyclerView와 어댑터 클래스 셋업
                        MyCoinAdapter myCoinAdapter = new MyCoinAdapter(Coin.class,coinArrayList);
                        recycler_list_view.setLayoutManager(new LinearLayoutManager(mRecyclerView.this));

                    }
                }

                @Override
                public void onFailure(Call<CoinResponse> call, Throwable t) {

                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

