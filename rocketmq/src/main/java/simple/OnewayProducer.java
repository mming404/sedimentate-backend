package simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO  单向发送  用于日志等
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class OnewayProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer onewayProducer = new DefaultMQProducer("OnewayProducer");
        onewayProducer.setNamesrvAddr("10.21.23.9:9876");
        onewayProducer.start();
        for (int i = 0; i < 3; i++) {
            Message message = new Message("Simple","tags",(i+" 杨思铭玩OnewayProducer").getBytes(StandardCharsets.UTF_8));
            onewayProducer.sendOneway(message);
            System.out.println("单向消息发送成功");
        }

        onewayProducer.shutdown();
    }
}
