package demo.rabbitmq;

import javax.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
@Service
public class MessageProducer {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        System.out.println("消息入队："+message);
        amqpTemplate.convertAndSend("queueTestKey", message);
    }
}