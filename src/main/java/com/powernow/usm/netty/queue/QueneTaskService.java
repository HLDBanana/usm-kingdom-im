package com.powernow.usm.netty.queue;

import com.powernow.usm.netty.protocol.MessageHolder;
import com.powernow.usm.netty.queue.TaskQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The implementation of Service.
 *
 */
@Slf4j
@Component
@Order(1)
public class QueneTaskService implements CommandLineRunner {

    @Autowired
    private Dispatcher dispatcher;

    public static AtomicBoolean shutdown = new AtomicBoolean(false);

    // 任务队列
    private BlockingQueue<MessageHolder> taskQueue;
    // 阻塞式地从taskQueue取MessageHolder
    private ExecutorService takeExecutor;
    // 执行业务的线程池
    private ExecutorService taskExecutor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("task~~~~~~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        init();
        start();
    }

    private void init() {
        takeExecutor = Executors.newSingleThreadExecutor();
        taskExecutor = Executors.newFixedThreadPool(10);
        taskQueue = TaskQueue.getQueue();
        log.info("初始化服务完成");
    }

    private void start() {
        takeExecutor.execute(new Runnable() {
            @Override
            public void run() {
                while (!shutdown.get()) {
                    try {
                        MessageHolder messageHolder = taskQueue.take();
                        log.info("TaskQueue取出任务: taskQueue=" + taskQueue.size());
                        startTask(messageHolder);
                    } catch (InterruptedException e) {
                        log.warn("receiveQueue take", e);
                    }
                }
            }

            private void startTask(MessageHolder messageHolder) {
                taskExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        log.info("开始执行取出的任务 messageHolder=" + messageHolder);
                        dispatcher.dispatch(messageHolder);
                    }
                });
            }
        });
        log.info("启动服务完成");
    }



}
