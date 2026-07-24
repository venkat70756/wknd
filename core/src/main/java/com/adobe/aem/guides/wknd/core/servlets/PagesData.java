package com.adobe.aem.guides.wknd.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
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
@SlingServletPaths(value = "/bin/pagesData")
public class PagesData extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(PagesData.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException, ServletException{

        String pagePath = request.getParameter("pagePath");

        ResourceResolver resourceResolver = request.getResourceResolver();

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        Page page = pageManager.getPage(pagePath);

        if (page != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println("Page Title: " + page.getTitle());
        }else  {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println("Page Not found");
        }


    }
}
