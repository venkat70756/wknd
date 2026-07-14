package com.adobe.aem.guides.wknd.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Test Configuration for Phalguni", description = "Entering the Employee details")
public @interface TestConfiguration {

    @AttributeDefinition(name = "Employee Name", type = AttributeType.STRING, description = "Enter the Employee name")
    public String getEmployeeName() default "Phalguni";

    @AttributeDefinition(name = "Employee ID", type = AttributeType.INTEGER, description = "Enter the Employee ID")
    public int getEmployeeID() default 2443;

    @AttributeDefinition(name = "Is Contract Employee", type = AttributeType.BOOLEAN, description = "If the employes type is Contract, please enable the checkbox, if not uncheck the checkbox ")
    public boolean getIsContractEmployee() default true;

    @AttributeDefinition(name = "Employee Skills", type = AttributeType.STRING, description = "Enter the employee skills")
    public String[] getEmployeeSkills() default {"HTML", "JavaScript"};

    @AttributeDefinition(name = "Employee Location", type = AttributeType.STRING, description = "Select the Employee Location", options = {
            @Option(label = "India", value = "in"),
            @Option(label = "United States", value = "usa"),
            @Option(label = "United Kingdom", value = "UK")
    })
    public String getEmployeeLocation();


    @AttributeDefinition(name = "Employees Id", type = AttributeType.PASSWORD, description = "Enter the Employeee Secret ID")
    public String getEmployeeSecretID();

}



