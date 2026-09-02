package com.adobe.aem.guides.wknd.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = TestSchedulerConfig.class)
public class AvinashTestScheduler implements Runnable {

    @Reference
    private Scheduler scheduler;

    private static final Logger log = LoggerFactory.getLogger(AvinashTestScheduler.class);

    private String JOB_NAME;

    private String CORN_EXPRESSION ;


    @Activate
    @Modified
    protected void config( TestSchedulerConfig testSchedulerConfig){

        JOB_NAME = testSchedulerConfig.getJobName();
        CORN_EXPRESSION = testSchedulerConfig.getCornExpression();

        ScheduleOptions scheduleOptions = scheduler.EXPR(CORN_EXPRESSION);
        scheduleOptions.name(JOB_NAME);
        scheduleOptions.canRunConcurrently(false);

        scheduler.schedule(this,scheduleOptions);

        log.info("Scheduler has been started");

    }

    @Deactivate
    protected void unschedule(){
        log.info("Scheduler has been Stopped");
        scheduler.unschedule(JOB_NAME);
    }


    @Override
    public void run() {
        log.info("Scheduler is running");
    }
}
