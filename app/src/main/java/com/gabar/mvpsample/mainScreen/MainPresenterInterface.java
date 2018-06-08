package com.gabar.mvpsample.mainScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjeev on 7/8/17.
 */


public interface MainPresenterInterface {


    void checkCredsAndHitApi();
    void success(ArrayList<Data> dataArrayList);
    void onItemClick(int position ,List<Data> dataList);


}
