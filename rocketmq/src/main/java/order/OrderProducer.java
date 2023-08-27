package order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Description: TODO 顺序消息的生产者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class OrderProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("OrderProducer");
        producer.setNamesrvAddr("10.21.23.9:9876");
        producer.start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Message message = new Message("Order", "TagA", ("order_" + i + "_step_" + j).getBytes(StandardCharsets.UTF_8));
                producer.send(message, (list, message1, o) -> {
                    Integer id = (Integer) o;
                    long index = id % list.size();
                    return list.get((int) index);
                }, i);
                System.out.println("消息发送成功");
            }
        }

        producer.shutdown();
    }
}
