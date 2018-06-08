package com.gabar.mvpsample.mainScreen;

import android.util.Log;

import com.gabar.mvpsample.RetrofitClient.ApiUrls;
import com.gabar.mvpsample.RetrofitClient.RetrofitClient;
import com.gabar.mvpsample.RetrofitClient.WebServices;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sanjeev on 7/8/17.
 */


public class MainInteractor implements MainInteractorInterface {

    String TAG = getClass().getName();
    MainPresenter mainPresenter;
    MainView mainView;

    MainInteractor(MainPresenter mainPresenter, MainView mainView)
    {
        this.mainPresenter = mainPresenter;
        this.mainView = mainView;
    }


    @Override
    public void hitApi() {

        WebServices webServices = RetrofitClient.getClient(ApiUrls.BASE_URL).create(WebServices.class);
        Call<JsonArray> call = webServices.getData();
        mainView.showProgress();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                mainView.hideProgress();
                Log.d(TAG, response.toString());
                ArrayList<Data> dataArrayList = new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++) {

                    Gson gson = new Gson();
                    Data data = gson.fromJson(response.body().get(i), Data.class);
                    Log.d(TAG, response.toString());

                    dataArrayList.add(data);

                }

                mainPresenter.success(dataArrayList);

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                mainView.hideProgress();
            }
        });


    }

}
