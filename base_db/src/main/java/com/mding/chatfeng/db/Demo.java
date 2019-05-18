package com.mding.chatfeng.db;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteOpenHelper;

public class Demo {
    private SQLiteOpenHelper mDBHelper;
    private SQLiteDatabase mDB;
    Context mContext;
    private int mDBVersion;
    public Demo(){

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
            }

            @Override
            protected Cursor doInBackground(Void... voids) {
                if (mDBHelper != null && mDB != null && mDB.isOpen()) {
                    mDBHelper.close();
                    mDBHelper = null;
                    mDB = null;
                }

                mDBHelper = new PlainTextDBHelper(mContext);
                mDBHelper.setWriteAheadLoggingEnabled(true);
                mDB = mDBHelper.getWritableDatabase();
                mDBVersion = mDB.getVersion();
                return mDB.rawQuery("SELECT rowid as _id, content, '???' as sender FROM message;",
                        null);
            }
        };



    }

}
