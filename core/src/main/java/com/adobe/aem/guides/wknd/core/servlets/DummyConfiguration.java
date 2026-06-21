package com.adobe.aem.guides.wknd.core.servlets;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Dummy employee Rest API Endpoint ")
public @interface DummyConfiguration {

    @AttributeDefinition(name = "Employee API endpoint", type = AttributeType.STRING)
    public String employeeApiEndpoint() default "https://dummy.restapiexample.com/api/v1/employees";
}
