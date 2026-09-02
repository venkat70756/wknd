package com.adobe.aem.guides.wknd.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Avinash Test Scheduler Config")
public @interface TestSchedulerConfig {

    @AttributeDefinition(name = "Job Name" , type = AttributeType.STRING)
    public String getJobName() default "AvinashTesting";

    @AttributeDefinition(name = "Corn Expression", type = AttributeType.STRING)
    public String getCornExpression() default "0/5 * * * * ?";
}
