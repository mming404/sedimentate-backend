package simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/8/26
 * @Version V1.0
 **/
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("SimpleConsumer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        consumer.subscribe("Simple","*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                list.forEach(n-> System.out.println("消息接收成功:" + n));
                System.out.println("消息接收成功:");
                list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("消费者启动成功");
    }
}
