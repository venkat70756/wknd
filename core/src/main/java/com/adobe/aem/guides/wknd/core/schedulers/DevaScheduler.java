package com.adobe.aem.guides.wknd.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = DevaScheduler.DevaSchedulerConfig.class)
public class DevaScheduler implements Runnable{

    @ObjectClassDefinition(name = "Deva Scheduler Configuration", description = "test")
    public @interface DevaSchedulerConfig{
        @AttributeDefinition(name = "Job name", type = AttributeType.STRING, description = "enter job name")
        public String getJobName() default "deva";

        @AttributeDefinition(name = "Cron Expression", type = AttributeType.STRING, description = "provide the Cron  expression")
        public String getCronExpression() default "*/5 * * * * *";
    }


    @Reference
    Scheduler scheduler;

    private static final Logger log = LoggerFactory.getLogger(DevaScheduler.class);


    private String JOB_NAME;

    private String CRON_EXPRESSION ;


    @Activate
    @Modified
    public void activateScheduler( DevaSchedulerConfig config){
        JOB_NAME = config.getJobName();
        CRON_EXPRESSION = config.getCronExpression();
        addScheduler();
    }

    @Deactivate
    public void deactivateScheduler(){
        removeScheduler();
    }

    public  void addScheduler(){
        ScheduleOptions scheduleOptions = scheduler.EXPR(CRON_EXPRESSION);
        scheduleOptions.name(JOB_NAME);
        scheduleOptions.canRunConcurrently(false);
        scheduler.schedule(this, scheduleOptions);
    }

    public void removeScheduler(){
        scheduler.unschedule(JOB_NAME);
    }
    @Override
    public void run() {
        log.info("Deva Scheudler is running");
    }
}




/*
 * @Model
 * @Componenent(service=Interface.class) --> Osgi service
 * @Componenet(service= Servlet.class) --> Servlet
 * @Cmponennet(service= Runnable.class) --> Scheduler
 */