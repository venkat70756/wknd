package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/avinashquery")
public class AvinashQueryTesting extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(AvinashQueryTesting.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("do get method triggered");
        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            Session session = resourceResolver.adaptTo(Session.class);


            QueryManager queryManager = session.getWorkspace().getQueryManager();

            String userQuery = "SELECT * FROM [cq:PageContent] as v WHERE ISDESCENDANTNODE(v, '/content/wknd')";

            Query query = queryManager.createQuery( userQuery, Query.JCR_SQL2);

            QueryResult queryResult = query.execute();


        } catch (Exception e) {
           log.error(e.getMessage());
        }

    }
}


// ResourceResolver--> Session --> QueryManager --> Query --> QueryResults