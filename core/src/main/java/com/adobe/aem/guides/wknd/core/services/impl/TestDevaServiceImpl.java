package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.TestDevaService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = TestDevaService.class, immediate = true)
@Designate(ocd = TestDevaConfiguration.class)
public class TestDevaServiceImpl implements TestDevaService {

    private static final Logger log = LoggerFactory.getLogger(TestDevaServiceImpl.class);

    private String sName;

    private int sId;

    private boolean isRegular;

    private String[] sSubjects;

    private String sClass;

    private String sPan;






    @Activate
    @Modified
    public void activate(TestDevaConfiguration testDevaConfiguration){
//        log.info("Bundle got activated");

        sName = testDevaConfiguration.getStudentName();
        sId = testDevaConfiguration.getStudentID();
        isRegular = testDevaConfiguration.getIsRegular();
        sSubjects = testDevaConfiguration.getSubjects();
        sClass = testDevaConfiguration.getStudentClass();
        sPan = testDevaConfiguration.getStudentPan();

        log.info("Student Class: {} , Student ID:  {}  ,  Regular Student :  {} , Student Subjects: {}, Student Class: {} , Student Pan: {}", sName, sId, isRegular,sSubjects,sClass,sPan);
    }

//    @Modified
//    public void modified(){
//        log.info("Bundle got modified ");
//    }

    @Deactivate
    public void deactivated(){
        log.info("Bundle got deactivated");
    }
}


