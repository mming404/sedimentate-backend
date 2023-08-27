package schedule;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @Description: TODO  延迟消费者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class ScheduleConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ScheduleProducer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        consumer.subscribe("Schedule","*");
        consumer.setMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
            System.out.println("消息接收成功:"+ LocalDateTime.now());
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        System.out.println("消费者启动成功");
    }
}
