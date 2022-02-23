package com.powernow.usm.netty.protocol;

import io.netty.channel.Channel;
import lombok.Data;

/**
 * 消息载体.
 *
 * 传输模块与服务模块之间双向数据传输载体:
 *
 *                   MessageHolder
 * Service Module <----------------> Transport Module
 *
 */
@Data
public class MessageHolder {


    /**
     * 消息标志    0x01:请求 Client --> Server
     *           0x02:响应 Server --> Client
     *           0x03:通知 Server --> Client  e.g.消息转发
     */
    private byte sign;
    /**
     * 消息类型 0x15: 个人消息
     *        0x16： 群组消息
     *        0x11: 登录（建立连接）
     *        0x13: 登出（销毁连接）
     *        0x23: 心跳
     *        0x14: 重连
     */
    private byte type;

    /**
     * 响应状态
     *          0x31: 49 请求成功
     *          0x32: 50 请求错误
     *          0x33: 51 服务器繁忙
     *          0x34: 52 服务器错误
     */
    private byte status;
    // Json消息体
    private String body;
    // 接收到消息的通道
    private Channel channel;

}
