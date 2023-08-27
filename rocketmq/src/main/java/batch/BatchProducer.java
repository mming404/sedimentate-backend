package batch;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @Description: TODO 批量消息生产者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class BatchProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer syncProducer = new DefaultMQProducer("BatchProducer");
        syncProducer.setNamesrvAddr("10.21.23.9:9876");
        syncProducer.start();
        ArrayList<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("Simple","tags",(i+" 杨思铭玩批量BatchProducer").getBytes(StandardCharsets.UTF_8));
            messages.add(message);
        }
        //总消息大小不能超过4M  建议保持1M左右
        syncProducer.send(messages);

        syncProducer.shutdown();
    }
}
