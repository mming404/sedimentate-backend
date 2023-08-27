package simple;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.store.ReadOffsetType;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO 拉模式消费者
 * @Author MiSinG
 * @Date 2023/8/27
 * @Version V1.0
 **/
public class PullConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("PullConsumer");
        consumer.setNamesrvAddr("10.21.23.9:9876");
        HashSet<String> strings = new HashSet<>();
        strings.add("Simple");
        consumer.setRegisterTopics(strings);
        consumer.start();
        while (true) {


            consumer.getRegisterTopics().forEach(n -> {
                        try {
                            Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues(n);
                            messageQueues.forEach(l -> {
                                try {
                                    long offset = consumer.getOffsetStore().readOffset(l, ReadOffsetType.READ_FROM_MEMORY);
                                    if (offset < 0) {
                                        offset = consumer.getOffsetStore().readOffset(l, ReadOffsetType.READ_FROM_STORE);
                                    }
                                    if (offset < 0) {
                                        offset = consumer.maxOffset(l);
                                    }
                                    if (offset < 0) {
                                        offset = 0;
                                    }
                                    PullResult pullResult = consumer.pull(l, "*", offset, 32);
                                    switch (pullResult.getPullStatus()) {
                                        case FOUND:
                                            pullResult.getMsgFoundList().forEach(k -> System.out.println("消息消费成功" + new String(k.getBody(), StandardCharsets.UTF_8)));
                                            consumer.updateConsumeOffset(l, pullResult.getNextBeginOffset());
                                            break;
                                        default:break;
                                    }
                                } catch (MQClientException e) {
                                    throw new RuntimeException(e);
                                } catch (RemotingException e) {
                                    throw new RuntimeException(e);
                                } catch (MQBrokerException e) {
                                    throw new RuntimeException(e);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        } catch (MQClientException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

    }
}
