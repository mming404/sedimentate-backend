package broadcast;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO  广播消息消费者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class BroadcastConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("SimpleConsumer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        consumer.subscribe("Simple","*");
        consumer.setMessageModel(MessageModel.CLUSTERING); //集群模式
//        consumer.setMessageModel(MessageModel.BROADCASTING);//广播模式
        consumer.setMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            System.out.println("消息接收成功:");
            list.forEach(n-> System.out.println(new String(n.getBody(), StandardCharsets.UTF_8)));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        System.out.println("消费者启动成功");
    }
}
