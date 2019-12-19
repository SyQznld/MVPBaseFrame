package com.appler.mvpbaseframe.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.appler.mvpbaseframe.utils.UpgradeHelper;
import com.sy.mvpbaseframe.greendao.gen.DaoMaster;
import com.sy.mvpbaseframe.greendao.gen.DaoSession;

import java.util.LinkedList;

/**
 * Created by appler on 2018/9/18.
 */

public class BaseApplication extends Application {
    private String TAG = "BaseApplication";
    private Context context;
    private static BaseApplication baseApplication;
    public static LinkedList<Activity> activityLinkedList;

    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        context = this;
        baseApplication = this;

        setupDatabase();

        activityLinkedList = new LinkedList<>();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activityLinkedList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityLinkedList.remove(activity);
            }
        });
    }

    private void setupDatabase() {

        UpgradeHelper helper = new UpgradeHelper(context, "MvpBaseFrame.db", null);

        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();

    }

    public Context getContext() {
        return context;
    }

    public static BaseApplication getBaseApplication() {
        return baseApplication;
    }

    public static DaoSession getDaoInstance() {
        return daoSession;
    }


    //两次返回键返回
    public void exitApp() {
        //当前容器内activity列表
        for (Activity activity : activityLinkedList) {
            Log.i(TAG, "exitApp: " + activity.getLocalClassName());
        }
        //逐个退出activity
        for (Activity activity : activityLinkedList) {
            activity.finish();
        }
        //结束进程
        System.exit(0);
    }
}
