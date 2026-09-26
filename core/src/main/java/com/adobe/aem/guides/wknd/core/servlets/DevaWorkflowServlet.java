package com.adobe.aem.guides.wknd.core.servlets;

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

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/deva/wf")
public class DevaWorkflowServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DevaWorkflowServlet.class);


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{

        ResourceResolver resourceResolver = request.getResourceResolver();

        String payload = request.getParameter("payloadPath");

        log.info("payload: {}", payload);

        try {


            WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);

            WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/deva");

            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH",payload);

            workflowSession.startWorkflow(workflowModel,workflowData);
            log.info("Worklfow started");
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
