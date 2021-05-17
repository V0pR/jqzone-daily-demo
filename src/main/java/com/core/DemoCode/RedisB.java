package com.core.DemoCode;

import com.core.service.RedisService;
import com.core.service.impl.RedisServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

@Slf4j
class RedisB {

    @Autowired
    private RedisService redisService;

    public static final String ORDER_MESSAGE = "wj_qiang";

    public void RedisB(){
        this.redisService = new RedisServiceImpl();
    }

    public void aa() throws InterruptedException {
        // 订单服务
        orderService("bravo1988", 10086L);

        // 启动消费者，取出消息，逐一发送
        new Thread(this::consumeMsg).start();

        // 10秒后再发一条消息，模拟第二次下单
        TimeUnit.SECONDS.sleep(10);
        orderService("bravo2020", 99999L);

        // 等待一会儿，观察第二条消息
        TimeUnit.SECONDS.sleep(10);
    }

    public void orderService(String username, Long orderId) {
        // 1.操作数据库，插入订单

        // 2.其他操作

        // 3.发送消息
        redisService.pushQueue(ORDER_MESSAGE, new Order(username, orderId));
    }

    public void consumeMsg() {
        for (; ; ) {
            Object order = redisService.popQueue(ORDER_MESSAGE, 5, TimeUnit.SECONDS);
            log.info("每隔5秒循环获取，期间for循环阻塞");
            if (order != null) {
                log.info("order:{}", order.toString());
            }
        }
    }
}
@Data
@AllArgsConstructor
class Order {
    private String username;
    private Long resumeId;
}