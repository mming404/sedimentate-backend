package filter;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO  过滤消息生产者  tag方式
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class FilterTagProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer syncProducer = new DefaultMQProducer("FilterTagProducer");
        syncProducer.setNamesrvAddr("10.21.23.9:9876");
        syncProducer.start();
        String[] strings = {"TagA", "TagB", "TagC"};
        for (int i = 0; i < 10; i++) {
            Message message = new Message("Filter", strings[i % strings.length], (strings[i % strings.length] + " 杨思铭玩SyncProducer").getBytes(StandardCharsets.UTF_8));
            syncProducer.send(message);
            System.out.println("消息发送成功");
        }

        syncProducer.shutdown();
    }
}
