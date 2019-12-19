package com.appler.mvpbaseframe.model;

/**
 * Created by appler on 2018/9/19.
 */

public interface IModel {

    void onStart();

    void onError();

    void onComplete();

    void onNext(String string);

}
