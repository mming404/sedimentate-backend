package simple;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO  异步发送
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("AsyncProducer");
        producer.setNamesrvAddr("10.21.23.9:9876");
        producer.start();
        CountDownLatch count = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message("Simple","Tags",(i+" 杨思铭玩AsyncProducer").getBytes(StandardCharsets.UTF_8));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    count.countDown();
                    System.out.println(index + " 异步消息发送成功");
                }

                @Override
                public void onException(Throwable throwable) {
                    count.countDown();
                    System.out.println(index + " 异步消息发送失败");
                }
            });
        }

        count.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }
}
