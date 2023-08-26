package simple;

import java.nio.charset.StandardCharsets;
import java.util.Collection;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Description: TODO 同步消息
 * @Author MiSinG
 * @Date 2023/8/26
 * @Version V1.0
 **/
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer syncProducer = new DefaultMQProducer("SyncProducer");
        syncProducer.setNamesrvAddr("10.21.23.9:9876");
        syncProducer.start();
        for (int i = 0; i < 3; i++) {
            Message message = new Message("Simple","tags",(i+" 杨思铭玩SyncProducer").getBytes(StandardCharsets.UTF_8));
            SendResult result = syncProducer.send(message);
        }

        syncProducer.shutdown();
    }
}
