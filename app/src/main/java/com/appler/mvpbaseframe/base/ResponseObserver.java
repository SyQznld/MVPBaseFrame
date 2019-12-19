package com.appler.mvpbaseframe.base;


import rx.Subscriber;

public abstract class ResponseObserver<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);
}