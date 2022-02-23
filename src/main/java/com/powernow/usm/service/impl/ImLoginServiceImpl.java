package com.powernow.usm.service.impl;

import com.powernow.usm.netty.connection.ConnPool;
import com.powernow.usm.netty.protocol.LoginMessageHolder;
import com.powernow.usm.service.ImLoginService;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



/**
 * @destription
 */
@Slf4j
@Service
public class ImLoginServiceImpl implements ImLoginService {


    @Override
    public void login(Channel channel, LoginMessageHolder loginMessage) {
        /**
         * 1、验证sender地址是否存在
         * 2、验证通过  登记在线，否则返回异常
         * 3、登录成功，发送所有离线消息？
         */
        ConnPool.add(loginMessage.getSender(),channel);
        log.info(ConnPool.connsMap.toString());
        // 发送离线消息


    }
}
