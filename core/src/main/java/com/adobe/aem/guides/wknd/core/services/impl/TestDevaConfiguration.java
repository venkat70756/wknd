package com.adobe.aem.guides.wknd.core.services.impl;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Test Deva Configuration", description = "Training Test")
public @interface TestDevaConfiguration {

    @AttributeDefinition(name = "Student Name", type = AttributeType.STRING, description = "Enter Student Name")
    public String getStudentName() default "venkat";

    @AttributeDefinition(name="Student Id", type = AttributeType.INTEGER, description = "Enter Student ID")
    public int getStudentID() default 123;

    @AttributeDefinition(name = "Is Regular", type = AttributeType.BOOLEAN)
    public boolean getIsRegular();

    @AttributeDefinition(name = "Student Subjects", type =AttributeType.STRING, description = "Enter Student Subjects")
    public String[] getSubjects() default {"telugu", "English"};


    @AttributeDefinition(name="Student Class", type = AttributeType.STRING, description = "Select the Student Class", options = {
            @Option(label = "6th Class", value = "6th"),
            @Option(label = "7th Class", value = "7th"),
            @Option(label = "8th Class", value = "8th"),
            @Option(label = "9th Class", value = "9th"),
            @Option(label = "10th Class", value = "10th")

    })
    public String getStudentClass();


    @AttributeDefinition(name = "Student PAN", type = AttributeType.PASSWORD, description = "Enter Student Adhar")
    public String getStudentPan();


}


