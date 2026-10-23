package com.adobe.aem.guides.wknd.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Madhan Demo Osgi Configuration", description = "Learning the OSGI Configuration")
public @interface MadhanConfig {

    @AttributeDefinition(name = "Student Name", description = "Enter Student Name", type = AttributeType.STRING)
    public String getStudentName() default "madhan";


    @AttributeDefinition(name = "Studnet Age", description = "Enter Student Age", type = AttributeType.INTEGER)
    public int getStudentAge();

    @AttributeDefinition(name = "Regular Student", type = AttributeType.BOOLEAN)
    public boolean getStudentType() default true;

    @AttributeDefinition(name = "Student Adhar", type = AttributeType.PASSWORD)
    public String getAdhar();

    @AttributeDefinition(name = "Student Subjects" , type = AttributeType.STRING)
    public String[] getStudentSubjects();

    @AttributeDefinition(name = "Select Student class", type = AttributeType.STRING, options = {
            @Option(label = "6th class", value = "6"),
            @Option(label = "7th class", value = "7"),
            @Option(label = "8th class", value = "8"),
            @Option(label = "9th class", value = "9"),
            @Option(label = "10th class", value = "10")
    })
    public String getStudentClass();


}
