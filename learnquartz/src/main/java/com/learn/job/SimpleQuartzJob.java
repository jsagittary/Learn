package com.learn.job;

import org.quartz.*;

/**
 * @author: ZhouJie
 * @date: Create in 2018-05-19 20:59
 * @description:
 * @modified By:
 */
public class SimpleQuartzJob implements Job {

    public SimpleQuartzJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleTrigger trigger = (SimpleTrigger) context.getTrigger();
        int cnt = trigger.getTimesTriggered();
        System.out.println("执行第" + cnt + "次");
    }
}
