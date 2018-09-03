package demo.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageConsumer implements MessageListener {
    public void onMessage(Message message) {
        System.out.println("消息出队："+message);
    }
}