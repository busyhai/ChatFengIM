package com.mding.chatfeng.base_common.ui;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

public class BaseActivity extends Activity  implements View.OnClickListener {


    protected void addOnClickListeners(@IdRes int... ids) {
        if (ids != null) {
            for (@IdRes int id : ids) {
                findViewById(id).setOnClickListener(this);
            }
        }
    }


    @Override
    public void onClick(View v) {

    }
}
