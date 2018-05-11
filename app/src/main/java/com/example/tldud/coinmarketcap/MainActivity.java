package com.example.tldud.coinmarketcap;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    List<Coin> coinList ;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        //클라이언트 인스턴스 생성 ( 기본 셋팅 된 retrofit 객체)
        Client client = new Client();
         service = client.getRetrofit().create(RetrofitService.class);

        getCoinData();


        //url로 값 넣어주기

        //interface만들기
        //연결하는 인트로핏 만들기
        //연결해주기

    }

    //coin의 정보를 api 요청으로 받아오고 리사이클러 뷰를 통해 보여준다
    private void getCoinData() {

        try{


            //작성한 인터페이스에 있는 getcoininfo메서드를 이용해 api요청
            Call<CoinResponse> coinResponseCall = service.getCoinInfo(10);
            //callback 메서드 작성
            coinResponseCall.enqueue(new Callback<CoinResponse>() {

                //요청 성공
                @Override
                public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {

                    //resonse.body()는 coinResponse모델 객체를 반환
                    if(response.body() != null) {
                        coinList = response.body().getCoinList();
                        MyCoinAdapter myCoinAdapter = new MyCoinAdapter(coinList);
                        Log.d("dev","response is : "+response.body());
                        mRecyclerView.setAdapter(myCoinAdapter);



                    }else {
                        Toast.makeText(MainActivity.this, "정보를 가져오지 못했습니다.",Toast.LENGTH_SHORT).show();

                    }
                }
                //요청 실패
                @Override
                public void onFailure(Call<CoinResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "데이터를 가져오지 못했습니다.",Toast.LENGTH_SHORT).show();
                }
            });

        }catch(Exception e){
            e.printStackTrace();
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

