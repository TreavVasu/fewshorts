package com.learning.fewshorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Toast;

import com.learning.fewshorts.VerticalViewPager;
import com.learning.fewshorts.ViewPagerAdapter;
import com.learning.fewshorts.Model.ApiClient;
import com.learning.fewshorts.RecievedData.Article;
import com.learning.fewshorts.RecievedData.Headlines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    final String API_KEY ="597a94d33b3f4beb96d7f437f3c36510";
    final String CATEGORY = "general";
    List<Article> articles =new ArrayList<>();
    Adapter adapter;

    public VerticalViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);





        //Experiments


        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines("in", CATEGORY, API_KEY);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Intent Here Failed Ok ", Toast.LENGTH_LONG).show();

                    return;
                }
                List<Article> articles = response.body().getArticles();
                List<String> lekhak =new ArrayList<String>();

                List<String> title =new ArrayList<String>();
                List<String> descr =new ArrayList<String>();
                List<String> url =new ArrayList<String>();
                List<String> date =new ArrayList<String>();

                //String x ="";
                for (Article article:articles){
                    //  x+=article.getAuthor();
                    //Log.d("myTag", "#Resp:"+x);

                    if (article.getAuthor()==null){
                        Log.d("Author", String.valueOf(lekhak));

                    }else {
                        lekhak.add(article.getAuthor());
                        title.add(article.getTitle());
                        descr.add(article.getDescription());
                        url.add(article.getUrlToImage());
                        date.add(article.getPublishedAt());
                    }

                }
                Log.d("Author", String.valueOf(lekhak));
                Log.d("Title", String.valueOf(title));
                Log.d("Desc", String.valueOf(descr));
                Log.d("Url", String.valueOf(url));
                Log.d("Date", String.valueOf(date));
                Log.d("Siz:",String.valueOf(title.size()));


                Toast. makeText(getApplicationContext(),"Please Wait",Toast. LENGTH_LONG);

                SingleObject temp = SingleObject.getInstance();
                temp.setWriter(lekhak);
                temp.setNumber(lekhak.size());

                temp.setTitle(title);
                temp.setDescription(descr);
                temp.setPublishedAt(date);
                temp.setUrlToImage(url);


            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });



        viewPager = (VerticalViewPager) findViewById(R.id.ViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

}

/*
        Article a = (Article) articles;
        SingleObject temp = SingleObject.getInstance();
        temp.setAuthor(a.getAuthor());
        temp.setTitle(a.getTitle());
        temp.setPublishedAt(a.getPublishedAt());


                Bundle bundle = new Bundle();

                //Intent intent = new Intent(MainActivity.this,ChildFragment.class);
                //intent.putStringArrayListExtra("authors", (ArrayList<String>) lekhak);


                bundle.putStringArrayList("one", (ArrayList<String>) lekhak);




*/
