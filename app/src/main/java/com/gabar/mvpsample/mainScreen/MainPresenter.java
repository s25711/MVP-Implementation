package com.gabar.mvpsample.mainScreen;

import android.widget.Toast;

import com.gabar.mvpsample.MyCustomApplciation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjeev on 7/8/17.
 */

public class MainPresenter implements MainPresenterInterface {

    MainView mainView;
    MainInteractor mainInteractor;

    MainPresenter(MainView mainView) {

        this.mainView=mainView;
        this.mainInteractor=new MainInteractor(this,mainView);
    }
    @Override
    public void checkCredsAndHitApi() {
        mainInteractor.hitApi();
    }

    @Override
    public void success(ArrayList<Data> dataArrayList) {
        mainView.addList(dataArrayList);

    }
    @Override
    public void onItemClick(int position,List<Data> datalist) {

        Toast.makeText(MyCustomApplciation.getInstance(), "Posiotn :"+ datalist.get(position).getLogin(), Toast.LENGTH_SHORT).show();

    }


}
