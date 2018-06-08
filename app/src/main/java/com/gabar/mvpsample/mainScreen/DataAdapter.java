package com.gabar.mvpsample.mainScreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gabar.mvpsample.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sanjeev on 7/8/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    Context context;
    List<Data> dataList;
    MainPresenter mainPresenter;


    DataAdapter(Context context, List<Data> dataList,MainPresenter mainPresenter){
        this.dataList=dataList;
        this.context=context;
        this.mainPresenter=mainPresenter;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inflater_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.name.setText(dataList.get(position).getLogin().toUpperCase());
            holder.id.setText(dataList.get(position).getId().toString());
            holder.url.setText(dataList.get(position).getUrl());
            Glide.with(context).load(dataList.get(position).getAvatarUrl())
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.avtar);




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,id,url;
        CircleImageView avtar;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.id);
            url=itemView.findViewById(R.id.url);
            avtar=itemView.findViewById(R.id.avtar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mainPresenter.onItemClick(getAdapterPosition(),dataList);

                }
            });




        }
    }

    public void addList(ArrayList<Data> arrayList)
    {
        this.dataList=arrayList;
        notifyDataSetChanged();

    }






}
