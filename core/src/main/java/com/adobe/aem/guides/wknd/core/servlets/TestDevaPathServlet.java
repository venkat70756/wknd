package com.adobe.aem.guides.wknd.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/deva")

//aem 6.5 path based servlet registration
//@Component(service = Servlet.class, options={
//        "sling.servlet.paths=/bin/deva"
//})

public class TestDevaPathServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(TestDevaPathServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        log.info("Do get Triggered");

        String title = "";

        String pageName = request.getParameter("pageName");

        ResourceResolver resourceResolver = request.getResourceResolver();

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        Page page = pageManager.getPage(pageName);


        if (page != null){
            title = page.getTitle();
        }

        ValueMap properties = page.getProperties();

        String author = properties.get("author", String.class);

//        String writer = properties.get("writer",String.class);

        String writer = page.getProperties().get("writer", String.class);



        log.info("Page Title: {}", title);

        log.info("Author : {}", author);

        log.info("Writer : {}", writer);




        if (page.hasChild(pageName)){
                Iterator<Page> childPages = page.listChildren();

                while (childPages.hasNext()){
                    Page child = childPages.next();

                  log.info("Child Page Title: {}", child.getTitle());
                }
        }
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response){
        log.info("Do Post Triggered");
    }

}


// ResourceResolverFactory
// ResourceResolver
// Resolver
// PageManager & Page
// Node
// Asset API
// ContentFragment API
