package com.appler.mvpbaseframe.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sy.mvpbaseframe.greendao.gen.DaoMaster;
import com.sy.mvpbaseframe.greendao.gen.UserDataDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

/**
 * Created by appler on 2018/9/18.
 */

public class UpgradeHelper extends DaoMaster.OpenHelper{
    public UpgradeHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, name,cursorFactory);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);

        Database database = new StandardDatabase(db);
        MigrationHelper.getInstance().migrate(database, UserDataDao.class);
    }
}
