package com.adobe.aem.guides.wknd.core.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
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
@SlingServletPaths(value = "/bin/yl/query")
public class TestServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(TestServlet.class);


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            ResourceResolver resourceResolver = request.getResourceResolver();

            Session session = resourceResolver.adaptTo(Session.class);

            QueryManager queryManager =session.getWorkspace().getQueryManager();

            String userQuery = "SELECT * FROM [cq:PageContent] as yl WHERE ISDESCENDANTNODE(yl, '/content/wknd/us/en') AND yl.author='yl'";


            Query query = queryManager.createQuery(userQuery, Query.JCR_SQL2);

            QueryResult queryResult = query.execute();

            NodeIterator nodeIterator = queryResult.getNodes();

            log.info("Found {} nodes", nodeIterator.getSize());
            List<Map<String,String>> pages = new ArrayList<>();

            while (nodeIterator.hasNext()) {

                Node node = nodeIterator.nextNode();

                Map<String,String> page = new HashMap<>();
                page.put("pageTitle", node.getProperty("jcr:title").getString());
                page.put("pagePath", node.getParent().getPath());
                pages.add(page);
            }

            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(pages));
        } catch (RepositoryException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }


}