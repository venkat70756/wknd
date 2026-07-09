package com.adobe.aem.guides.wknd.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
public class DemoScheduler implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(DemoScheduler.class);

    @Reference
    private Scheduler scheduler;

    private String SchedulerName = "DemoScheduler";

    private String CronExpression = "*/3 * * * * ?";


    @Activate
    @Modified
    protected void activate() {

        ScheduleOptions scheduleOptions = scheduler.EXPR(CronExpression);
        scheduleOptions.name(SchedulerName);
        scheduler.schedule(this, scheduleOptions);

    }

    @Deactivate
    protected void deactivate() {
        scheduler.unschedule(SchedulerName);
    }



    @Override
    public void run() {
        log.info("Running DemoScheduler");
    }
}
