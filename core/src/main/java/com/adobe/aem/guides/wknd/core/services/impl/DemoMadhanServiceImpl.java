package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.DemoMadhanService;
import org.osgi.service.component.annotations.Component;

@Component(service = DemoMadhanService.class)
public class DemoMadhanServiceImpl implements DemoMadhanService {

  private String name = "madhan name coming from osgi service";

    @Override
    public String getMyName() {
        return name;
    }
}
