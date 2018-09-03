package demo.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestJob {

    @Test
    public  void TestDemo() throws SchedulerException {

        //创建JOBDetail对象
        JobDetail build = JobBuilder.newJob(DemoJob.class)
                .withIdentity("job1", "group1").build();

        SimpleScheduleBuilder builder =
                SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10).withRepeatCount(10);


        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                /// 设置触发器名，组名
                .withIdentity("trigger1","group1")
                // 设置重复间隔+重复次数，一直重复的话设置repeatForever()
                .withSchedule(builder)
                // 设置开始时间
                .startNow().build();



        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // 为Scheduler对象新增JOB以及对应的SimpleTrigger
        sched.scheduleJob(build,trigger);

        // 启动定时任务管理器
        System.out.println("开启定时任务.......");
        sched.start();

        // 主线程睡眠2分钟
        try {
            // wait five minutes to show jobs
            Thread.sleep(120L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭定时任务管理器
        System.out.println("定时任务结束.......");
        sched.shutdown(true);

    }

    public static void main(String[] args) throws Exception {
        // 创建JobDetail对象，指定对象的任务名称、组名
        JobDetail job = JobBuilder.newJob(DemoJob.class)
                .withIdentity("job1","group1").build();
        CronScheduleBuilder builder = CronScheduleBuilder
                .cronSchedule("0/10 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(builder).build();
// 创建任务管理器Scheduler对象
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        // 主线程睡眠1分钟
        Thread.sleep(60L * 1000L);
        // 关闭定时任务管理器
        scheduler.shutdown(true);
    }

}
