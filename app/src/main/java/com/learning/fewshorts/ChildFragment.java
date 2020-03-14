package com.learning.fewshorts;

import android.content.Context;
import android.os.Bundle;
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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildFragment extends Fragment {
    ImageView imageView;
    TextView tvTitle, tvSource, tvDate;
    CardView card;


    public ChildFragment() {
        //Docs Says Default Empty :(
    }

    Context context;
    List<Article> articles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_child, container, false);
        //imageView = (ImageView) view.findViewById(R.id.imageHere);
        tvTitle = (TextView) view.findViewById(R.id.titleHere);
        tvSource = (TextView) view.findViewById(R.id.sourceHere);
        tvDate = (TextView) view.findViewById(R.id.dateHere);

/*
        Bundle bundle =getArguments();
        tvTitle.setText(bundle.getString("Title"));
        tvSource.setText(bundle.getString("Source"));
        tvDate.setText(bundle.getString("Date"));
*/

        Toast.makeText(getContext(), "Passing Here Ok  ", Toast.LENGTH_SHORT).show();

        Bundle bundle = getArguments();
        tvTitle.setText("Parent"+bundle.getString("parent"));
        tvSource.setText("Child"+bundle.getString("Child"));
        return view;




    }


}

