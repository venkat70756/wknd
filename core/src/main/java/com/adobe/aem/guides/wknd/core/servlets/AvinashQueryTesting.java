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

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
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

            log.info(queryResult.toString());

            NodeIterator nodeIterator = queryResult.getNodes();

            List<Map<String, String> > pages = new ArrayList<>();

            while (nodeIterator.hasNext()){

                Map<String, String> page = new HashMap<>();

                Node node = nodeIterator.nextNode();

                page.put("pageTitle",node.getProperty("jcr:title").getString());

                page.put("pagePath", node.getParent().getPath());

                pages.add(page);

            }
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(pages));



        } catch (Exception e) {
           log.error(e.getMessage());
        }

    }
}


// ResourceResolver--> Session --> QueryManager --> Query --> QueryResults


// for(int i-0; i<=10;

//            String name = "venkat";
//
//            String[] names = new String[5];
//
//            names[0] = "a";
//            names[1] = "b";
//            names[2] = "c";
//            names[3] = "d";
//            names[4] = "e";

//     Collection Framework

// List( ArrayList LinkedList) , Set, Queue  and Map

// API Json