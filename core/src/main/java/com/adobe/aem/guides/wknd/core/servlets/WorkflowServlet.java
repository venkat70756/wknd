package com.adobe.aem.guides.wknd.core.servlets;


/*
 * using this path based servlet we are calling the workflow model
 */

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/workflow")
public class WorkflowServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(WorkflowServlet.class);


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{

        String  payloadPath = request.getParameter("payloadPath");

        log.info("payloadPath = " + payloadPath);

        try {

            ResourceResolver resourceResolver = request.getResourceResolver();

            WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);


            WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/phalguni");

            log.info("workflowModel = " + workflowModel);

            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH",payloadPath);

            log.info("workflowData = " + workflowData);

            workflowSession.startWorkflow(workflowModel, workflowData);
            log.info("workflowSession started");

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("Workflow Triggered Successfully on this payload: " + payloadPath);

        } catch (WorkflowException e) {
            log.error(e.getMessage(), e);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("Workflow Triggered got failed on this payload: " + payloadPath);
            throw new RuntimeException(e);
        }

    }

}
