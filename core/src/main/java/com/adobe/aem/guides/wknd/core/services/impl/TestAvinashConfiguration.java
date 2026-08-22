package com.adobe.aem.guides.wknd.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Avinash Test Configuration", description = "for testing")
public @interface TestAvinashConfiguration {

    @AttributeDefinition(name = "Student ID", type = AttributeType.INTEGER, description = "Enter Student ID")
    public int getStudentID() default 123;

    @AttributeDefinition(name = "Student Name", type = AttributeType.STRING, description = "Enter the Student Name")
    public String getStudentName() default "XXXXXXX";

    @AttributeDefinition(name = "Is Regular", type = AttributeType.BOOLEAN, description = "Student Regular or Irregular")
    public boolean getIsRegular() default true;

    @AttributeDefinition(name = "Student Subjects", type = AttributeType.STRING, description = "Enter the Student Subjects")
    public String[] getStudentSubjects() default {"English", "Science"};

    @AttributeDefinition(name = "Student Class", type = AttributeType.STRING, description = "Select Student Class", options = {
            @Option(label = "6th Class", value = "6th"),
            @Option(label = "7th Class", value = "7th"),
            @Option(label = "8th Class", value = "8th"),
            @Option(label = "9th Class", value = "9th"),
            @Option(label = "10th Class", value = "10th")
    })
    public String getStudentClass();

    @AttributeDefinition(name = "Student Pan", type = AttributeType.PASSWORD, description = "Enter Student PAN")
    public String getStudentPan();


}
