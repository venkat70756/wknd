package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.services.PageCreationService;
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

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/pagecreation")
public class PagesCreationServlet  extends SlingAllMethodsServlet {

    private static  final Logger LOG = LoggerFactory.getLogger(PagesCreationServlet.class);

    @Reference
    PageCreationService pageCreationService;

    @Reference
    ResourceResolver resourceResolver;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        String templatePath = request.getParameter("templatePath");
        String pageTitle = request.getParameter("pageTitle");
        String pageName = request.getParameter("pageName");
        String parentPagePath = request.getParameter("parentPagePath");

        pageCreationService.getPageCreation(resourceResolver,parentPagePath,pageName,templatePath,pageTitle);

//        ResourceResolver resourceResolver = request.getResourceResolver();
//
//        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//
//        try {
//
//            Page page = pageManager.create(parentPagePath,pageName,templatePath,pageTitle);
//
//            resourceResolver.commit();
//
//            LOG.info("Page Created Successfully");
//
//
//        }catch (Exception e){
//                LOG.error(e.getMessage());
//        }
    }
 }
