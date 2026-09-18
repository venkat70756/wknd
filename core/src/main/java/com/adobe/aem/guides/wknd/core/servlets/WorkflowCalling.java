package com.adobe.aem.guides.wknd.core.servlets;

/*
 * We are calling the Workflows in the backend services.
 */





import com.adobe.granite.workflow.WorkflowSession;
//import com.adobe.granite.workflow.WorkflowService;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/workflow")
public class WorkflowCalling extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(WorkflowCalling.class);


//    @Reference
//    private WorkflowService workflowService;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{

        String payload = request.getParameter("payload");

        if (payload == null || payload.isEmpty()) {
            response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Please send the payload path");
            return;
        }

        try {
//            ResourceResolver resourceResolver = request.getResourceResolver();
//
//            Session session = resourceResolver.adaptTo(Session.class);
//
//            WorkflowSession workflowSession = workflowService.getWorkflowSession(session);
//
//            WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/avinash");
//
//            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payload);
//
//
//            workflowSession.startWorkflow(workflowModel, workflowData);
            response.getWriter().write("Workflow started");
        }catch (Exception e) {
                log.error("Error while starting workflow", e);
                response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Error while starting workflow: " + e.getMessage());
            }

        }
}
