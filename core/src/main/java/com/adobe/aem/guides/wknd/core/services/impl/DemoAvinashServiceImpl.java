package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.DemoAvinashService;
import org.osgi.service.component.annotations.Component;

@Component(service = DemoAvinashService.class)
public class DemoAvinashServiceImpl implements DemoAvinashService {

    String mno = "88434343434";

    @Override
    public String getMobileNumber() {
        return mno;
    }
}
