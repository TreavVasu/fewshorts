package com.learning.fewshorts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    Article article= new Article();

    ImageView imageView;
    TextView tvTitle, tvSource, tvDate;
    CardView card;
    public ViewPagerAdapter(@NonNull FragmentManager fm ) {

        super(fm);
    }//Behaviour parameter b dal sakta h idhar

    @NonNull
    @Override
    public Fragment getItem(int position) {

        ChildFragment child = new ChildFragment();

        SingleObject temp = SingleObject.getInstance();
        List<String>lekhak = temp.getWriter();
        temp.setPosi(position);


        Bundle bundle0 = new Bundle();

        bundle0.putString("parent",String.valueOf(position));
        bundle0.putString("msg",String.valueOf(lekhak));
        child.setArguments(bundle0);

        return child;
    }

    @Override
    public int getCount() {
        return 12;
    }
}



/*
    *     Bundle bundle = new Bundle();
        ArrayList<String> title = bundle.getStringArrayList("one");
        //Log.d("BUNDLE##",+String.valueOf(title));
*/