package com.powernow.usm.netty.client;


import cn.hutool.core.util.RandomUtil;
import com.powernow.usm.netty.protocol.LoginMessageHolder;
import com.powernow.usm.netty.protocol.Message;
import com.powernow.usm.netty.connection.ConnPool;
import com.powernow.usm.netty.protocol.MessageHolder;
import com.powernow.usm.netty.protocol.ProtocolHeader;
import com.powernow.usm.utils.Serializer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 最终接收数据的Handler.
 *
 * @author Yohann.
 */
@Slf4j
public class AcceptorHandler extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext ctx;

//    private ConnectionListener connListener;

//    public AcceptorHandler(ConnectionListener connListener) {
//        this.connListener = connListener;
//    }

    public AcceptorHandler(){}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 活跃");
        this.ctx = ctx;
        // 获取随机数
        int randomNum = RandomUtil.randomInt(0,10);
        LoginMessageHolder message1 = new LoginMessageHolder();
        message1.setSender(""  + randomNum);
        log.info("注册channel,user = {}",randomNum);

//        for (int i = 0; i < 1; i++) {
            Message message = new Message();
            message.setSender(1 + "");
            message.setReceiver("" + 7);
            message.setContent("hello receiver " + 7 + ", i am sender" + 1);
            message.setTime(System.currentTimeMillis());
            MessageHolder messageHolder = new MessageHolder();
            messageHolder.setSign(ProtocolHeader.REQUEST);
            messageHolder.setType(ProtocolHeader.PERSON_MESSAGE);
//        messageHolder.setType(ProtocolHeader.LOGIN);
            messageHolder.setStatus((byte) 0);
            messageHolder.setBody(Serializer.serialize(message));
            Channel channel = ctx.channel();
            channel.writeAndFlush(messageHolder);
//        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("读取完毕 活跃");
        if (msg instanceof MessageHolder) {
            MessageHolder messageHolder = (MessageHolder) msg;
            log.info("读取到服务端推送的消息：{}",messageHolder.toString());
            // 处理消息
//            Dispatcher.dispatch(messageHolder);
        } else {
            throw new IllegalArgumentException("msg is not instance of MessageHolder");
        }
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        // 断开连接 移除在线用户
        String username = ConnPool.query(ctx.channel());
        ConnPool.remove(username);
        System.out.println("断开");
    }


    public synchronized ChannelPromise sendMessage(MessageHolder message) {
        while (ctx == null) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                //logger.error("等待ChannelHandlerContext实例化");
            } catch (InterruptedException e) {
                log.error("等待ChannelHandlerContext实例化过程中出错",e);
            }
        }
        log.info("client发送消息：{}",message.toString());
        ChannelPromise promise = ctx.newPromise();
        ctx.writeAndFlush(message);
        return promise;
    }
}
