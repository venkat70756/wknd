package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/employee")
public class EmployeeServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServlet.class);


    @Reference
    DummyEmployeeService dummyEmployeeService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        log.info("Employee Servlet Called");
        response.setContentType("application/json");

        response.getWriter().write(dummyEmployeeService.getEmployees());

    }
}
