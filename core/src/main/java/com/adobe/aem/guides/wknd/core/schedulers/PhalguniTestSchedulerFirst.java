package com.adobe.aem.guides.wknd.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component(service = Runnable.class, immediate = true)
@Designate(ocd = PhalguniTestSchedulerConfig.class)
public class PhalguniTestSchedulerFirst implements Runnable{

    @Reference
    private Scheduler scheduler;

    private String JOB_NAME;

    private String CORN_EXPRESSION ;

    private static final Logger log = LoggerFactory.getLogger(PhalguniTestSchedulerFirst.class);

    @Activate
    @Modified
    protected void start(PhalguniTestSchedulerConfig config){
        JOB_NAME = config.getJobName();
        CORN_EXPRESSION = config.getCronExpression();

        log.info("Scheduler got startd");
        ScheduleOptions scheduleOptions = scheduler.EXPR(CORN_EXPRESSION);
        scheduleOptions.name(JOB_NAME);
        scheduleOptions.canRunConcurrently(false);

        scheduler.schedule(this, scheduleOptions);
    }


    @Deactivate
    protected void stop(){
        scheduler.unschedule(JOB_NAME);
    }



    @Override
    public void run() {
        log.info("Scheduler running");
    }
}
