package com.adobe.aem.guides.wknd.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

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
@SlingServletPaths(value = "/bin/devatestquery")
public class DevaTestQuery extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {




        String userQuery = "SELECT * FROM [cq:PageContent] as p WHERE ISDESCENDANTNODE(p, '/content/wknd') AND p.author='deva'";
        try {
        ResourceResolver resourceResolver = request.getResourceResolver();

        Session session = resourceResolver.adaptTo(Session.class);


            QueryManager queryManager = session.getWorkspace().getQueryManager();

            Query query = queryManager.createQuery(userQuery,Query.JCR_SQL2);


            QueryResult queryResult = query.execute();


            NodeIterator nodeIterator = queryResult.getNodes();

            List<Map<String,String>> list = new ArrayList<>();

            while (nodeIterator.hasNext()){

                Node node = nodeIterator.nextNode();

                Map<String,String> map = new HashMap<>();

                map.put("pageTitle", node.getProperty("jcr:title").getString());
                map.put("pagePath", node.getParent().getPath());

                list.add(map);
            }
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(list));

        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }
}
