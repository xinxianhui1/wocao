package demo.rabbitmq;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/applicationContext-*.xml")
public class RabbitMq_Test {

    @Autowired
    MessageProducer messageProducer;

    @Test
    public void testRabbitMq(){
        Object obj="{'id':1001,'name':'剑网三','age':14}";
        messageProducer.sendMessage(obj);
    }
}
