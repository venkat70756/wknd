package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.MadhanBundlesService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = MadhanBundlesService.class, immediate = true)
@Designate(ocd = MadhanConfig.class)  // for the separate file
//@Designate(ocd = MadhanBundlesServiceImpl.Config.class)  // with in the same file
public class MadhanBundlesServiceImpl implements MadhanBundlesService {


    private static String studentName;

    private static int studentAge;

    private static boolean sType;

    private static String sAdhar;

    private static String[]  studentSubjects;

    private static String studentClass;


    private static final Logger log = LoggerFactory.getLogger(MadhanBundlesServiceImpl.class);


//    @ObjectClassDefinition(name = "venkat m configuration")
//    public @interface Config{
//
//    }

    @Activate
    @Modified
    public void config(MadhanConfig madhanConfig ){

        studentName = madhanConfig.getStudentName();
        studentAge = madhanConfig.getStudentAge();
        sType = madhanConfig.getStudentType();
        sAdhar = madhanConfig.getAdhar();
        studentSubjects = madhanConfig.getStudentSubjects();
        studentClass = madhanConfig.getStudentClass();

//        log.info("Activate method got triggered");

        log.info("Student Name: {} , Student Age: {}, Student Type: {}", studentName,studentAge, sType );

    }
//
//
//    public void modified(){
//        log.info("Modified Method got triggered");
//
//    }


    @Deactivate
    public void deactivate(){
        log.info("Deactivate method got triggered");
    }

    @Override
    public String getStudentName() {
        return studentName;
    }
}
