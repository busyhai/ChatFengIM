package com.mding.chatfeng.login;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;

/**
 * 项目：ChatFengIM-master
 * 文件描述：
 * 作者：zll
 * 创建时间：2019/6/10 0010
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class Jump implements IComponent {
    @Override
    public String getName() {
        //指定组件的名称
        return "JumpIComponent";
    }

    @Override
    public boolean onCall(CC cc) {
        //跳转到页面：ActivityA
        CCUtil.navigateTo(cc, LoginActivity.class);
        //返回处理结果给调用方
        CC.sendCCResult(cc.getCallId(), CCResult.success());
        return false;
    }
}
