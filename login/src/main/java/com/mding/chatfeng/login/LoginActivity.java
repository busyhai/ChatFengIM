package com.mding.chatfeng.login;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponentCallback;
import com.mding.chatfeng.base_common.request.bean.UserBean;
import com.mding.chatfeng.login.util.UserStateManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private String callId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callId = CCUtil.getNavigateCallId(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        editText = new EditText(this);
        editText.setHint("adwwdwddw");
        editText.setText("billy");
        layout.addView(editText, params);
        Button button = new Button(this);
        button.setText("dddd");
        button.setOnClickListener(this);
        layout.addView(button, params);
        setContentView(layout);
    }

    @Override
    public void onClick(View v) {
        String username = editText.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            //仅业务提示，登录操作并未结束
            Toast.makeText(this,"onClick", Toast.LENGTH_SHORT).show();
        } else {
            UserStateManager.setLoginUser(new UserBean(1, username));


            //获取token并保存
            CC.obtainBuilder("login.IC_CheckLogin")
                    .setActionName("IA_GetTokenAndSave")
                    .build()
                    .callAsync(new IComponentCallback() {
                        @Override
                        public void onResult(CC loginCC, CCResult result) {
                            String toast = "IA_GetTokenAndSave " + (result.isSuccess() ? "success" : "failed");
                            Log.d("xx",toast);
                            if(result.isSuccess()){
                                //如果保存成功则调用使用token登入
                            }
                        }
                    });



            //返回登录结果
//            sendLoginResult();
//            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //为确保一定会调用CC.sendCCResult，在onDestroy中再次确认是否已返回登录结果
//        sendLoginResult();
    }

    private boolean resultSent;

    private void sendLoginResult() {
        if (resultSent) {
            return;
        }
        resultSent = true;
        //判断是否为CC调用打开本页面
        if (callId != null) {
            CCResult result;
            if (UserStateManager.getLoginUser() == null) {
                result = CCResult.error("login canceled");
            } else {
                //演示跨app传递自定义类型及各种集合类型
                List<UserBean> list = new ArrayList<>();
                list.add(new UserBean(1, "aaa"));
                list.add(new UserBean(3, "ccc"));
                SparseArray<UserBean> userSparseArray = new SparseArray<>();
                userSparseArray.put(1, new UserBean(1, "a"));
                userSparseArray.put(10, new UserBean(10, "a"));
                userSparseArray.put(30, new UserBean(30, "a"));
                UserBean[][] userArray = new UserBean[5][2];
                SparseIntArray sparseIntArray = new SparseIntArray();
                sparseIntArray.put(1, 111);
                sparseIntArray.put(2, 222);
                Map<String, UserBean> map = new HashMap<>();
                map.put("user1", new UserBean(1, "111"));
                map.put("user2", new UserBean(2, "222"));

                result = CCResult.success(UserStateManager.KEY_USER, UserStateManager.getLoginUser()) //UserBean
                        .addData("list", list) // List<UserBean>
                        .addData("nullObject", null) //null
                        .addData("sparseArray", userSparseArray) //SparseArray<UserBean>
                        .addData("sparseIntArray", sparseIntArray) //SparseIntArray/SparseLongArray
                        .addData("user2Array", userArray) // UserBean[][]
                        .addData("untypedArray", list.toArray()) // Object[]
                        .addData("typedArray", list.toArray(new UserBean[]{})) // UserBean[]
                        .addData("map", map) // Map
                ;
            }
            //为确保不管登录成功与否都会调用CC.sendCCResult，在onDestroy方法中调用
            CC.sendCCResult(callId, result);
        }
    }
}