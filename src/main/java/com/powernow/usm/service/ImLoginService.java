package com.powernow.usm.service;

import com.powernow.usm.netty.protocol.LoginMessageHolder;
import io.netty.channel.Channel;

/**
 * 功能描述
 *
 * @date $
 * @destription xx
 */
public interface ImLoginService {

    /**
     * 登录事件
     * @param channel
     */
    public void login(Channel channel, LoginMessageHolder loginMessage);
}
