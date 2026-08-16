package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.DemoDevaService;
import org.osgi.service.component.annotations.Component;

@Component(service = DemoDevaService.class)
public class DemoDevaServiceImpl implements DemoDevaService {

    private static String name = "Venkat from osgi service";

    @Override
    public String getMyName() {
        return name;
    }
}
