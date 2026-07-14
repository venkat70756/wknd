package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.TestService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PrivateKey;
import java.util.Arrays;

@Component(service = TestService.class, immediate = true)
@Designate(ocd = TestConfiguration.class)
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    private String eName;
    private int eId;
    private boolean eType;
    private String[] eSkills;
    private String eLocation;
    private String ePassword;



    @Activate
    @Modified
    public void config(TestConfiguration  testConfiguration) {
//        log.info("Activating TestServiceImpl");
        eName = testConfiguration.getEmployeeName();
        eId = testConfiguration.getEmployeeID();
        eType = testConfiguration.getIsContractEmployee();
        eSkills = testConfiguration.getEmployeeSkills();
        eLocation = testConfiguration.getEmployeeLocation();
        ePassword = testConfiguration.getEmployeeSecretID();

        log.info("Employee Name : " + eName);
        log.info("Employee ID : " + eId);
        log.info("Employee Type : " + eType);
        log.info("Employee Skills : " + Arrays.toString(eSkills));
        log.info("Employee Location : " + eLocation);
        log.info("Employee Password : " + ePassword);
    }

//    @Modified
//    public void modified() {
//        log.info("Modified TestServiceImpl");
//    }

    @Deactivate
    public void deactivate() {
        log.info("Deactivating TestServiceImpl");
    }

}
