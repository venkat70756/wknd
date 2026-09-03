package com.adobe.aem.guides.wknd.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Phalguni Test Scheduler Configuration")
public @interface PhalguniTestSchedulerConfig {

    @AttributeDefinition(name = "Job name", type = AttributeType.STRING)
    public String getJobName() default "phalguni";

    @AttributeDefinition(name = "Cron Expression", type = AttributeType.STRING)
    public String getCronExpression() default "*/3 * * * * ?";
}
