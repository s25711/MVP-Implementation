package com.gabar.mvpsample.mainScreen;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.Dimension;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gabar.mvpsample.R;
import com.tuyenmonkey.mkloader.MKLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;
/**
 * Created by sanjeev on 7/8/17.
 */

public class MainActivity extends AppCompatActivity implements MainView {

    MKLoader loader;
    List<Data> dataList=new ArrayList<>();
    RecyclerView recyclerView;
    MainPresenter mainPresenter;
    DataAdapter mAdapter;
    ShimmerLayout shimmerLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setTitle("Collapsing Toolbar test");
        setSupportActionBar(toolbar);
        loader=(MKLoader)findViewById(R.id.loader);
        mainPresenter=new MainPresenter(this);

        setUpViews();


    }

    public void setUpViews(){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        initAdapter();

    }

    @Override
    public void showProgress() {
       // shimmerLayout.startShimmerAnimation();
        loader.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        loader.setVisibility(View.GONE);
       // shimmerLayout.stopShimmerAnimation();

    }

    @Override
    public void addList(ArrayList<Data> dataArrayList) {
        mAdapter.addList(dataArrayList);
    }

    @Override
    public void initAdapter() {

        if (dataList != null || !dataList.isEmpty()) {

            mAdapter = new DataAdapter(this, dataList, mainPresenter);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mainPresenter.checkCredsAndHitApi();

            //  new GetImageTask().execute();


        }
    }




   public class GetImageTask extends AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] objects) {

            URL url;

            String[] urls={"https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg",
                    "https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg"};

            try {

                for (int i = 0; i <urls.length ; i++) {

                    url = new URL(urls[i]);
                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    int width=bmp.getWidth();
                    int height=bmp.getHeight();
                    Log.d("DIMENSIONS :",width+"=="+height);

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
