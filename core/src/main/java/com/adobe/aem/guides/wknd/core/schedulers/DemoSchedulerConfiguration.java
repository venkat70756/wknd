package com.adobe.aem.guides.wknd.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Demo Scheduler Configuration for YL", description = "for Testing" )
public @interface DemoSchedulerConfiguration {

    @AttributeDefinition(name = "Scheduler Name", type = AttributeType.STRING, description = "Enter the scheduler name")
    public String getSchedulerName();


    @AttributeDefinition(name = "Corn Expression", type = AttributeType.STRING, description = "Enter the Corn Expression")
    public String getCronExpression();
}
