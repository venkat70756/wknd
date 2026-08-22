package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.TestAvinashService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Component(service = TestAvinashService.class, immediate = true)
@Designate(ocd = TestAvinashConfiguration.class)
public class TestAvinashServiceImpl implements TestAvinashService {

    private static final Logger log = LoggerFactory.getLogger(TestAvinashServiceImpl.class);

    private int sId;

    private String sName;

    private boolean isRegular;

    private String[] studentSubjects;

    private String studentClass;

    private String studentPan;





    @Activate
    @Modified
    public void config(TestAvinashConfiguration testAvinashConfiguration){
        log.info("Bundle Got Activated/Modified");

        sId = testAvinashConfiguration.getStudentID();

        sName = testAvinashConfiguration.getStudentName();

        isRegular = testAvinashConfiguration.getIsRegular();

        studentSubjects = testAvinashConfiguration.getStudentSubjects();

        studentClass = testAvinashConfiguration.getStudentClass();

        studentPan = testAvinashConfiguration.getStudentPan();

//        log.info("Student Id : " + sId );
//        log.info("Student  Name : " + sName );
//        log.info("Student type Regular  : " +  isRegular );
//        log.info("Student Subjects  : " + Arrays.toString(studentSubjects));
//        log.info("Student  Class : " + studentClass );
//        log.info("Student Pan  : " +  studentPan);


        log.info("Student Id : {}, Student  Name : {} , Student type Regular : {}, Student Subjects : {} , Student  Class : {} , Student Pan  : {}", sId,sName,isRegular,studentSubjects,studentClass,studentPan);
    }


//    @Modified
//    public void modified(){
//        log.info("Bundle Got modified");
//    }

    @Deactivate
    public void deactivated(){
        log.info("Bundle got deactivated");
    }

}
