package demo.quartz;

import java.util.Date;

public class Jobs {
    //任务1
    public void job1() {
        System.out.println("job1:"+new Date(System.currentTimeMillis()));
    }
    //任务2
    public void job2() {
        System.out.println("job2:"+new Date(System.currentTimeMillis()));
    }
}