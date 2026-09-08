package com.adobe.aem.guides.wknd.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/querytest")
public class QueryExecutionTest extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(QueryExecutionTest.class);

    private String userQuery = "SELECT * FROM [cq:PageContent] as p WHERE ISDESCENDANTNODE(p,'/content/wknd/us/en')";

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{
        try {

            ResourceResolver resourceResolver = request.getResourceResolver();

            Session session = resourceResolver.adaptTo(Session.class);

            QueryManager queryManager = session.getWorkspace().getQueryManager();

            Query query = queryManager.createQuery(userQuery,Query.JCR_SQL2);

            QueryResult queryResult = query.execute();

            NodeIterator nodeIterator = queryResult.getNodes();

            List<Map<String,String>> pages = new ArrayList<>();

            while (nodeIterator.hasNext()){
                Node node = nodeIterator.nextNode();

                Map<String,String> page = new HashMap<>();
                page.put("pageTitle", node.getProperty("jcr:title").getString());
                page.put("pagePath",node.getParent().getPath());


                if (node.hasProperty("author")) {
                    String author = node.getProperty("author").getString();

                    if (author != null && !author.isEmpty()) {

                    }
                }


                pages.add(page);
            }

            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(pages));

        } catch (Exception e) {
           log.error("Exception is: {}", e.getMessage());
        }


    }
}


// We have the QueryManager to exectue the queries like sql

//java collection Framework
//List <Map<String,String> list = new ArrayList<>();
//
//list.add(m)
//
//
//
//
//Map<String,String> m = new HashMap<>();
//
//m.put("name", "venkat");
//
//m.put("age", "28");

