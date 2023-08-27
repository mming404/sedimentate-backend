package filter;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;

import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO 过滤消费者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class FilterTagConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("FilterTagConsumer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        consumer.subscribe("Filter","TagA || TagC");
        consumer.setMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            System.out.println("消息接收成功:");
            list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        System.out.println("消费者启动成功");
    }
}
