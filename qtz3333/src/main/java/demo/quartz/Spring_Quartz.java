package demo.quartz;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/applicationContext22222222-Quartz.xml")
public class Spring_Quartz {

    @Test
    public void cc() throws SchedulerException {

          System.out.println("开始执行");
        try {
            Thread.sleep(1000*160);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
