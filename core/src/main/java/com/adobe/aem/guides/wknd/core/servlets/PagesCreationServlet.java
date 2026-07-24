package com.adobe.aem.guides.wknd.core.servlets;

import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
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
@SlingServletPaths("/bin/pagecreation")
public class PagesCreationServlet  extends SlingAllMethodsServlet {

    private static  final Logger LOG = LoggerFactory.getLogger(PagesCreationServlet.class);

    @Reference
    Replicator replicator;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        String templatePath = request.getParameter("templatePath");
        String pageTitle = request.getParameter("pageTitle");
        String pageName = request.getParameter("pageName");
        String parentPagePath = request.getParameter("parentPagePath");

        ResourceResolver resourceResolver = request.getResourceResolver();

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        Session session = resourceResolver.adaptTo(Session.class);

        if (templatePath != null && pageTitle != null && pageName != null && parentPagePath != null) {

            try {

                if (pageManager != null) {

                    Page page = pageManager.create(parentPagePath, pageName, templatePath, pageTitle);
                    resourceResolver.commit();

                    LOG.info("Page Created Successfully");

                    if (page != null) {

                        if (session != null) {

                            replicator.replicate(session, ReplicationActionType.ACTIVATE, page.getPath());

                            LOG.info("Page Activated Successfully");
                        }else {
                            LOG.error("Page not Activated");
                        }
                    }
                }else {
                    LOG.info("Page Not Created Successfully because PageManager is null");
                }


            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
        else {
            LOG.error("Please pass all the required parameters");
            response.setContentType("application/json");
            response.getWriter().println("Please pass all the required parameters");
        }
    }
 }
