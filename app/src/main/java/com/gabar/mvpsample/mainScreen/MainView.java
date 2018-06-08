package com.gabar.mvpsample.mainScreen;

import java.util.ArrayList;

/**
 * Created by sanjeev on 7/8/17.
 */


public interface MainView {

    void showProgress();

    void hideProgress();

    void addList(ArrayList<Data> dataArrayList);

    void initAdapter();

}
