package schedule;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @Description: TODO  定时延迟消息
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class ScheduleProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer syncProducer = new DefaultMQProducer("ScheduleProducer");
        syncProducer.setNamesrvAddr("10.21.23.9:9876");
        syncProducer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("Schedule","tags",(i+" 杨思铭玩定时延迟消息").getBytes(StandardCharsets.UTF_8));
            message.setDelayTimeLevel(2);//指定延迟等级发送
//            message.setDelayTimeMs(10000L);//自定义延迟时间发送  低版本不支持
            syncProducer.send(message);
            System.out.println("消息发送成功_"+ LocalDateTime.now());
        }

        syncProducer.shutdown();
    }
}
