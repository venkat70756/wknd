package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = "wknd/components/title",
        methods = HttpConstants.METHOD_GET,
        selectors = "p",
        extensions = "html"
)
// AEM 6.5
//@Component(service= Servlet.class,
//   property ={
//         "sling.servlet.resourceTypes=/bin/yl",
//         "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//         "sling.servlet.selectors = p",
//          "sling.servlet.extensions=html"
//   })
public class PhalguniResServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(PhalguniResServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {

        log.info("PhalguniResServlet doGet");
    }
}
