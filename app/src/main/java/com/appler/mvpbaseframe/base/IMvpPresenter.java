package com.appler.mvpbaseframe.base;

import android.support.annotation.UiThread;

/**
 * Created by appler on 2018/9/18.
 */

public interface IMvpPresenter<V> {

    //绑定视图
    @UiThread
    void attachView(V view);


    //解除绑定（每个v记得使用完之后解绑，以便用户防止内存泄漏）
    @UiThread
    void detachView();

}
