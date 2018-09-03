package demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MqCtroller {
    @Autowired
    MessageProducer messageProducer;

    @RequestMapping("/demo.action")
    public void demo(){
        messageProducer.sendMessage("{'orderid':'1001191999','datetime':'2018/7/10'}");
    }
}