package com.mding.chatfeng.start;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponentCallback;
import com.mding.chatfeng.base_common.AppConfig;
import com.mding.chatfeng.base_common.bean.login.GetClusterIp;
import com.mding.chatfeng.base_common.request.body.LoginInBody;
import com.mding.chatfeng.base_common.request.create;
import com.mding.chatfeng.base_common.ui.BaseActivity;
import com.mding.chatfeng.base_common.utils.GsonParamConverter;


public class StartActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //初始化控制器和方法字典
        create.init(getApplicationContext());
        //通过集群初始化动态IP
        create.getComsApi().getClusterIp().build()
                .callAsync(new IComponentCallback() {
                    @Override
                    public void onResult(CC loginCC, CCResult result) {
                        AppConfig.logs(result.isSuccess() + "调用成败：" + result);
                        if (result.isSuccess()) {
                            GetClusterIp mGetClusterIp = new GsonParamConverter().json2Object(result.getDataItem(loginCC.getActionName()).toString(), GetClusterIp.class);
                            AppConfig.httpProtocolIp = mGetClusterIp.getRecord().getHttpProtocolIp();
                            AppConfig.wsProtocolIp_1 = mGetClusterIp.getRecord().getWsProtocolIp_1();
                            AppConfig.skProtocolIp_1 = mGetClusterIp.getRecord().getSkProtocolIp_1();
//                            AppConfig.skProtocolPort=Integer.valueOf(mGetClusterIp.getRecord().getSkProtocolIp_1().split(":")[1]);
                            //此处可能存本地化

                            //异步回调成功后执行跳转组件
                            //此处测试
//                            testAmqp();
//                            tesCommon();
                            testHttp();

                        } else {
                            AppConfig.logs("配置初始化失败，网络数据获取失败");
                            //此处可能取本地化
                        }
                    }
                });

        //批量注册
        addOnClickListeners(R.id.tv_start);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_start:
                onViewClicked();
                break;
        }
    }
    /**
     * doLoginMtn 控制器方法
     * create.login().register  具体方法
     * LoginInBody  请求的数据体
     * 注意：单个组件不能同时调用，需要第一次结束后才能发起第二次重复调用，如需同时调用，需要在组件Action名加上时间戳，如果是同步调用则无需考虑
     *
     * @wdh
     */
    private void testHttp() {
        create.getComsApi().doCommon(create.login().controllersName, create.login().loginIn, new LoginInBody("18150960006", "e5e94876560ab8220f43cbd52854e80a")).build()
                .callAsync(new IComponentCallback() {
                    @Override
                    public void onResult(CC loginCC, CCResult result) {
//                        LoginInBean mLoginInBean = new GsonParamConverter().json2Object(result.getDataItem(loginCC.getActionName()).toString(), LoginInBean.class);
//                        AppConfig.logs("调用成败：" + result.isSuccess() + "  ---解析数据：" + mLoginInBean.getMsg());
                        AppConfig.logs("调用成败：" + result.isSuccess());
                    }
                });
    }


    /**
     * 测试socket组件
     */
    private void testAmqp() {
        create.getComsApi().doAmqpMtn(create.amqp().sendPrivateChat, new LoginInBody("18150960006", "e5e94876560ab8220f43cbd52854e80a")).build()
                .callAsync(new IComponentCallback() {
                    @Override
                    public void onResult(CC loginCC, CCResult result) {
//                        LoginInBean mLoginInBean = new GsonParamConverter().json2Object(result.getDataItem(loginCC.getActionName()).toString(), LoginInBean.class);

                        AppConfig.logs("调用成败：" + result);
                    }
                });
    }


    /**
     * 测试socket组件
     */
    private void tesCommon() {
        create.mComsApi.doCommon(create.amqp().controllersName, create.amqp().sendPrivateChat, new LoginInBody("18150960006", "e5e94876560ab8220f43cbd52854e80a")).build()
                /*create.mComsApi.doCommon(create.login().controllersName,create.login().register, new LoginInBody("123123", "5123123", "12312", "13123", "13")).build()*/
                .callAsync(new IComponentCallback() {
                    @Override
                    public void onResult(CC loginCC, CCResult result) {
//                        LoginInBean mLoginInBean = new GsonParamConverter().json2Object(result.getDataItem(loginCC.getActionName()).toString(), LoginInBean.class);

                        AppConfig.logs("调用成败：" + result);
                    }
                });

    }


    public void onViewClicked() {


        CC.obtainBuilder("JumpIComponent")
                .setActionName("IA_GetTokenAndSave")
                .build()
                .callAsyncCallbackOnMainThread(new IComponentCallback() {
                    @Override
                    public void onResult(CC cc, CCResult result) {
                        //此onResult在主线程中运行

                    }
                });
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();

    }
}
