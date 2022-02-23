package com.powernow.usm.service;

import com.powernow.usm.netty.protocol.Message;
import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;

/**
 * 功能描述
 *
 * @date $
 * @destription xx
 */
public interface PersonMessageService {

    /**
     * 发送个人消息
     * @param channel
     * @param message
     */
    public Future sendMessage(Channel channel, Message message);
}
