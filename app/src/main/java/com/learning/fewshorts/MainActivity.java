package com.learning.fewshorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    Adapter adapter;

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
                for (Article article:articles){
                    String x ="";int i = 0;


                    x+=article.getAuthor()+"\n\n";

                    Log.d("myTag", "################Resp:"+x);
                    lekhak.add(article.getAuthor());
                    Log.d("Author", String.valueOf(lekhak));
                    i++;
                }


                Bundle bundle = new Bundle();

                //Intent intent = new Intent(MainActivity.this,ChildFragment.class);
                //intent.putStringArrayListExtra("authors", (ArrayList<String>) lekhak);


                bundle.putStringArrayList("one", (ArrayList<String>) lekhak);



            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
/*
        Article a = (Article) articles;
        SingleObject temp = SingleObject.getInstance();
        temp.setAuthor(a.getAuthor());
        temp.setTitle(a.getTitle());
        temp.setPublishedAt(a.getPublishedAt());
*/

    }

}
