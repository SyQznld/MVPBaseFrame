package com.appler.mvpbaseframe.presenter;

import com.appler.mvpbaseframe.base.BaseMvpPresenter;
import com.appler.mvpbaseframe.global.Global;
import com.appler.mvpbaseframe.model.ITestModel;
import com.appler.mvpbaseframe.model.im.TestFrameModel;
import com.appler.mvpbaseframe.view.TestFrameView;

/**
 * Created by appler on 2018/9/19.
 */

public class TestFramePresenter extends BaseMvpPresenter {
    private String TAG = getClass().getSimpleName();
    private TestFrameModel testFrameModel;
    private TestFrameView testFrameView;

    public TestFramePresenter(final TestFrameView testFrameView) {
        this.testFrameView = testFrameView;

        testFrameModel = new TestFrameModel(new ITestModel() {
            @Override
            public void testFrame(String string) {
                testFrameView.testFrame(string);
            }

            @Override
            public void onStart() {
                testFrameView.setState(Global.LOADING_STATE);
            }

            @Override
            public void onError() {
                testFrameView.setState(Global.LOADING_FAIL);
            }

            @Override
            public void onComplete() {
                testFrameView.setState(Global.LOADING_SUCEESS);
            }

            @Override
            public void onNext(String string) {

            }
        });
    }

    public void testFrame(String s) {
        testFrameModel.testFrame(compositeSubscription, s);
    }
}
