package com.learning.fewshorts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.gson.Gson;
import com.learning.fewshorts.MainActivity;
import com.learning.fewshorts.Model.ApiClient;
import com.learning.fewshorts.RecievedData.Article;
import com.learning.fewshorts.RecievedData.Headlines;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.PendingIntent.getActivity;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    final String API_KEY ="597a94d33b3f4beb96d7f437f3c36510";
    final String CATEGORY = "general";
    List<Article> articles =new ArrayList<>();

    ImageView imageView;
    TextView tvTitle, tvSource, tvDate;
    CardView card;

    Intent intent = new Intent();
    Article article = (Article) intent.getSerializableExtra("article");

    public ViewPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }//Behaviour parameter b dal sakta h idhar

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ChildFragment child = new ChildFragment();

        Bundle bundle = new Bundle();
  /*      bundle.putSerializable("Source",article.getSource().getName());
        //bundle.putSerializable("ImageUrl",article.getUrlToImage());
        //bundle.putString("Source",article.getSource().getName());
        bundle.putSerializable("Title",article.getTitle());
        bundle.putSerializable("Date",article.getPublishedAt());
*/
        bundle.putString("parent",String.valueOf(position));


        child.setArguments(bundle);

        return child;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
