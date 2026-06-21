package com.adobe.aem.guides.wknd.core.servlets.impl;

import com.adobe.aem.guides.wknd.core.servlets.DummyConfiguration;
import com.adobe.aem.guides.wknd.core.servlets.DummyEmployeeService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

@Component(service = DummyEmployeeService.class)
@Designate(ocd = DummyConfiguration.class)
public class DummyEmployeeServiceImpl implements DummyEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(DummyEmployeeServiceImpl.class);

    private String apiUrl;
    @Activate
    @Modified
    public void config(DummyConfiguration  dummyConfiguration ) {
        apiUrl = dummyConfiguration.employeeApiEndpoint();
        log.info("Dummy employee API endpoint : " + apiUrl);
    }

    @Override
    public String getEmployees() {

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet request = new HttpGet(apiUrl);

            request.addHeader("Accept", "application/json");

            CloseableHttpResponse response = client.execute(request);

            log.info("Dummy employee API response : " + response);

            return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        } catch (Exception e) {
            return "{\"error\":\"Unable to fetch employees\"}";
        }
    }
}
