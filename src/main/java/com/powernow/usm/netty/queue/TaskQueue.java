package com.powernow.usm.netty.queue;

import com.powernow.usm.netty.protocol.MessageHolder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 接收阻塞队列，缓存刚入站的任务.
 *
 * Transport Module ---> InboundQueue ---> Service Module.
 *
 */
public class TaskQueue {
    private volatile static BlockingQueue<MessageHolder> queue;

    public static BlockingQueue<MessageHolder> getQueue() {
        if (queue == null) {
            synchronized (TaskQueue.class) {
                if (queue == null) {
                    // 创建消息队列并指定容量大小，未指定默认Integer.MAX_VALUE
                    queue = new LinkedBlockingDeque<>();
                }
            }
        }
        return queue;
    }
}
