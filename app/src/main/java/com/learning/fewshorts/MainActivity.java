package com.learning.fewshorts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.learning.fewshorts.VerticalViewPager;
import com.learning.fewshorts.ViewPagerAdapter;
import com.learning.fewshorts.Model.ApiClient;
import com.learning.fewshorts.RecievedData.Article;
import com.learning.fewshorts.RecievedData.Headlines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final String API_KEY ="597a94d33b3f4beb96d7f437f3c36510";
    final String CATEGORY = "general";
    List<Article> articles =new ArrayList<>();

    public VerticalViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (VerticalViewPager) findViewById(R.id.ViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);


        //Experiments
        //Article article = (Article) dataMining();


        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines("in", CATEGORY, API_KEY);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Intent Here Failed Ok ", Toast.LENGTH_LONG).show();

                    return;
                }

                articles = response.body().getArticles();

                Toast.makeText(MainActivity.this, "Intent Here Init Ok ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });


    }

}
