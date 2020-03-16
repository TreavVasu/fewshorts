package com.learning.fewshorts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.learning.fewshorts.MainActivity;
import com.learning.fewshorts.Model.ApiClient;
import com.learning.fewshorts.R;
import com.learning.fewshorts.RecievedData.Article;
import com.learning.fewshorts.RecievedData.Headlines;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildFragment extends Fragment {
    ImageView imageView;
    TextView tvTitle, tvSource, tvDate,tvDesc;
    CardView card;


    public ChildFragment() {
        //Docs Says Default Empty :(
    }

    Context context;
    //List<Article> articles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_child, container, false);
        imageView = (ImageView) view .findViewById(R.id.imageHere);
        tvTitle = (TextView) view.findViewById(R.id.titleHere);
        tvSource = (TextView) view.findViewById(R.id.sourceHere);
        tvDate = (TextView) view.findViewById(R.id.dateHere);
        tvDesc =(TextView)view.findViewById(R.id.descHere);

        SingleObject temp = SingleObject.getInstance();
        List<String>lekhak = temp.getWriter();

        List<String>title = temp.getTitle();
        List<String>date = temp.getPublishedAt();
        List<String>url = temp.getUrlToImage();
        List<String>desc = temp.getDescription();

        int pos = temp.getPosi();
        int siz = temp.getNumber();
        Article articles = Article.getInstance();
        //Beauties Of Project :)
        //Log.d("NULL:",String.valueOf(lekhak));
        //Log.d("Position: ",String.valueOf(pos)+"X"+String.valueOf(siz));
        //Log.d("Main: ",String.valueOf(lekhak.get(pos)));
        //Log.d("Size",String.valueOf(lekhak.size()));

        //Image Loading
        try {
            tvSource.setText(String.valueOf(lekhak.get(pos)));
            tvTitle.setText(String.valueOf(title.get(pos)));
            tvDate.setText(String.valueOf(date.get(pos)));
            tvDesc.setText(String.valueOf(desc.get(pos)));

            Picasso.with(getContext()).load(url.get(pos)).into(imageView);

        }catch (Exception e){

            //Failed then back to Same Image

            Log.d("Picasssso: ",e.getMessage());
        }

        return view;




    }


}
/*
*           Wasted Effort
        Bundle bundle0 =getArguments();
        String k =bundle0.getString("msg");

* */