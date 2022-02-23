package com.powernow.usm.netty;

import com.powernow.usm.netty.handler.AcceptorHandler;
import com.powernow.usm.netty.handler.ProtocolDecoder;
import com.powernow.usm.netty.handler.ProtocolEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @destription
 */
@Slf4j
@Component
@Order(20)
public class NettyServer implements CommandLineRunner {

    @Value("${netty.port}")
    private Integer port;

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;  //最大长度
    private static final int LENGTH_FIELD_LENGTH = 4;  //长度字段所占的字节数
    private static final int LENGTH_FIELD_OFFSET = 5;  //长度偏移
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SErver !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        start();
    }

//    @PostConstruct
//    public void start() throws Exception {
//        System.out.println("SErver !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//    }
    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(group, bossGroup) // 绑定线程池
                    .channel(NioServerSocketChannel.class) // 指定使用的channel
                    .localAddress(port)// 绑定监听端口
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            log.info("收到新的客户端连接: {}",ch.toString());
                            ch.pipeline().addLast("ProtocolDecoder", new ProtocolDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_FIELD_LENGTH,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,true));
//                            ch.pipeline().addLast("ProtocolDecoder", new ProtocolDecoder1(1024 * 8,5,4));
                            ch.pipeline().addLast("ProtocolEncoder", new ProtocolEncoder());
                            ch.pipeline().addLast("IdleStateHandler", new IdleStateHandler(6, 0, 0));
                            ch.pipeline().addLast("AcceptorHandler", new AcceptorHandler());
                        }
                    });
            ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
            System.out.println(NettyServer.class + " 启动正在监听： " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } catch (InterruptedException e) {
            log.warn("Netty绑定异常", e);
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
            bossGroup.shutdownGracefully().sync();
        }
    }



}
