package order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Description: TODO 顺序消息消费者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class OrderConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OrderConsumer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        consumer.subscribe("Order","*");
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
//        consumer.setMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
//            System.out.println("消息接收成功:");
//            list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        });
        consumer.start();
        System.out.println("消费者启动成功");
    }
}
