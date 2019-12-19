package com.appler.mvpbaseframe.utils;


import android.os.Handler;
import android.os.Looper;

/**
 * Created by appler on 2018/9/18.
 */

public class MainHandler extends Handler {

    private static volatile MainHandler mainHandler;

    public static MainHandler getInstance(){
        if (null == mainHandler){
            synchronized (MainHandler.class){
                if (null == mainHandler){
                    mainHandler = new MainHandler();
                }
            }
        }
        return  mainHandler;
    }

    private MainHandler(){
        super(Looper.getMainLooper());
    }
}
