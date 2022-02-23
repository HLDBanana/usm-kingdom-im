package com.powernow.usm.netty.client;

import com.powernow.usm.netty.handler.ProtocolDecoder;
import com.powernow.usm.netty.handler.ProtocolEncoder;
import com.powernow.usm.netty.protocol.Message;
import com.powernow.usm.netty.protocol.MessageHolder;
import com.powernow.usm.netty.protocol.ProtocolHeader;
import com.powernow.usm.utils.Serializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Data;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @destription
 */
@Data
public class NettyClient {
    private final String host;
    private final int port;



    private static final int MAX_FRAME_LENGTH = 1024 * 1024;  //最大长度
    private static final int LENGTH_FIELD_LENGTH = 4;  //长度字段所占的字节数
    private static final int LENGTH_FIELD_OFFSET = 5;  //长度偏移
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    public NettyClient() {
        this(12345);
    }

    public NettyClient(int port) {
        this("localhost", port);
    }

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group) // 注册线程池
                    .channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
                    .remoteAddress(new InetSocketAddress(this.host, this.port)) // 绑定连接端口和host信息
                    .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("连接connected...");
//                            ByteBuf byteBuf= Unpooled.copiedBuffer("$".getBytes());//防止粘包处理在消息末尾使用换行符对消息进行分割，或者使用其他特殊字符来对消息进行分割；
//                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));//防止粘包处理在消息末尾使用换行符对消息进行分割，或者使用其他特殊字符来对消息进行分割；
                            ch.pipeline().addLast("ProtocolDecoder", new ProtocolDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_FIELD_LENGTH,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,true));

//                            ch.pipeline().addLast("ProtocolDecoder", new ProtocolDecoder1(1024 * 8,5,4));
                            ch.pipeline().addLast("ProtocolEncoder", new ProtocolEncoder());
                            ch.pipeline().addLast("IdleStateHandler", new IdleStateHandler(0, 5, 0));
                            ch.pipeline().addLast("ReaderHandler", new AcceptorHandler());
                        }
                    });
            System.out.println("created..");

            ChannelFuture cf = b.connect().sync(); // 异步连接服务器
            System.out.println("connected..."); // 连接完成

            cf.channel().closeFuture().sync(); // 异步等待关闭连接channel
            System.out.println("closed.."); // 关闭完成
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
        }
    }

    public static void main(String[] args) throws Exception {

            NettyClient nettyClient = new NettyClient("127.0.0.1", 12345);

            nettyClient.start();// 连接127.0.0.1/12345，并启动

        System.out.println("===================================");
    }
}
