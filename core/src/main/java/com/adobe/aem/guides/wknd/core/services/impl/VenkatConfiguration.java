package com.adobe.aem.guides.wknd.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Venkat Factory configuration")
public @interface VenkatConfiguration {

    @AttributeDefinition(name = "id", type = AttributeType.STRING)
    public String getId();


    @AttributeDefinition(name = "canName", type = AttributeType.STRING)
    public String getCanName();
}
