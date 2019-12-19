package com.appler.mvpbaseframe.model.im;

import android.util.Log;

import com.appler.mvpbaseframe.base.BaseRetrofit;
import com.appler.mvpbaseframe.model.ITestModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by appler on 2018/9/19.
 */

public class TestFrameModel {

    private String TAG = getClass().getSimpleName();

    private ITestModel iTestModel;
    private BaseRetrofit baseRetrofit = new BaseRetrofit();

    public TestFrameModel(ITestModel iTestModel) {
        this.iTestModel = iTestModel;
    }

    public void testFrame(CompositeSubscription compositeSubscription,String s){
        compositeSubscription.add(
                baseRetrofit.getApiService().testFrame(s)
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        iTestModel.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                        iTestModel.onError();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            iTestModel.testFrame(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                })
        );
    }
}
