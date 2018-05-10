package com.example.tldud.coinmarketcap;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);


        //url로 값 넣어주기

        //interface만들기
        //연결하는 인트로핏 만들기
        //연결해주기

    }

    //coin의 정보를 api 요청으로 받아오고 리사이클러 뷰를 통해 보여준다
    private void getCoinData() {

        try{

            //클라이언트 인스턴스 생성 ( 기본 셋팅 된 retrofit 객체)
            Client client = new Client();
            RetrofitService service = client.getRetrofit().create(RetrofitService.class);

            //작성한 인터페이스에 있는 getcoininfo메서드를 이용해 api요청
            Call<CoinResponse> coinResponseCall = service.getcoininfo("Coin");
            //callback 메서드 작성
            coinResponseCall.enqueue(new Callback<CoinResponse>() {

                //요청 성공
                @Override
                public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {

                    //resonse.body()는 coinResponse모델 객체를 반환
                    if(response.body() != null) {
                        ArrayList<Coin> coinArrayList = response.body().getCoinArrayList();

                        //recyclerView와 어댑터 클래스 셋업
                        MyCoinAdapter myCoinAdapter = new MyCoinAdapter(coinArrayList);
                        mRecyclerView.setAdapter(myCoinAdapter);
                        mRecyclerView.setLayoutManager(mLayoutManager);
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
}

