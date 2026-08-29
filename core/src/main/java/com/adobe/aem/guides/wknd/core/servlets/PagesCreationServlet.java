package com.adobe.aem.guides.wknd.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/pagecreation")
public class PagesCreationServlet  extends SlingAllMethodsServlet {

    private static  final Logger LOG = LoggerFactory.getLogger(PagesCreationServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        String templatePath = request.getParameter("templatePath");
        String pageTitle = request.getParameter("pageTitle");
        String pageName = request.getParameter("pageName");
        String parentPagePath = request.getParameter("parentPagePath");

        String action = request.getParameter("actionType");

        String deletePagePath = request.getParameter("PagePath");

        ResourceResolver resourceResolver = request.getResourceResolver();

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        try {

            if (action.equals("creation")) {

                Page page = pageManager.create(parentPagePath, pageName, templatePath, pageTitle);

                resourceResolver.commit();

                LOG.info("Page Created Successfully");
            } else if (action.equals("deletion")) {

                Page page = pageManager.

            } else if (action.equals("modification")){

            }else {
                response.setContentType("application/jso");
                PrintWriter printWriter = response.getWriter();

                printWriter.println("Enter the Action Type");
            }


        }catch (Exception e){
                LOG.error(e.getMessage());
        }
    }
 }
