package com.adobe.aem.guides.wknd.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
public class PhalguniTestScheduler implements Runnable {

    private static final String  CRON_EXPRESSION = "*/3 * * * * *";

    private static final String NAME= "Phalguni";

    private static final Logger log = LoggerFactory.getLogger(PhalguniTestScheduler.class);

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate() {
        log.info("Activating PhalguniTestScheduler.");
        ScheduleOptions scheduleOptions = scheduler.EXPR(CRON_EXPRESSION);
        scheduleOptions.name(NAME);
//        scheduleOptions.canRunConcurrently(true);

        scheduler.schedule(this, scheduleOptions);
        log.info("PhalguniTestScheduler Started.");
    }

    @Deactivate
    protected void deactivate() {
        log.info("Deactivating PhalguniTestScheduler.");
        scheduler.unschedule(NAME);

        log.info("PhalguniTestScheduler Stopped.");
    }

    @Override
    public void run() {
        log.info("PhalguniTestScheduler is Running.");
    }
}
