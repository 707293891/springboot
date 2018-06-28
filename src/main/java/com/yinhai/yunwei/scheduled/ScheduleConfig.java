package com.yinhai.yunwei.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.*;

/**
 * @author 范超
 * @version V1.0
 * @Title ScheduleConfig
 * @Package com.yinhai.yunwei.scheduled
 * @Descript :TODO()
 * @date : 2018/6/26  下午4:51
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(20);
        scheduledTaskRegistrar.setScheduler(executor);
    }
}
