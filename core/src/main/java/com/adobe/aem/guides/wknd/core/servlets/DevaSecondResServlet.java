package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.services.ResourceUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "wknd/components/deva/demo",
        selectors = "devatwo",
        extensions = "html",
        methods = HttpConstants.METHOD_GET
)public class DevaSecondResServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DevaSecondResServlet.class);

    @Reference
    private ResourceUtil resourceUtil;


    @Reference
    private SlingSettingsService slingSettingsService;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        log.info("Resource based servlet got triggered");


        if (slingSettingsService.getRunModes().contains("author")){
            response.getWriter().write("Second Resource based servlet got triggered on author");
        } else if (slingSettingsService.getRunModes().contains("publish")){
            response.getWriter().write("Second Resource based servlet got triggered on pbulisher");
        }else {
            response.getWriter().write("please run on author or publisher");
        }

        response.getWriter().write("Resource based servlet got triggered");

    }
}
