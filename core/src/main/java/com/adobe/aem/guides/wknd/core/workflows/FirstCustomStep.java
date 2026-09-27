package com.adobe.aem.guides.wknd.core.workflows;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = WorkflowProcess.class, property = {
        "process.label= Deva First Custom Step"
})
public class FirstCustomStep implements WorkflowProcess{

    private static final Logger log = LoggerFactory.getLogger(FirstCustomStep.class);

    @Override
    public void execute(WorkItem item, WorkflowSession session, MetaDataMap args) throws WorkflowException {

        log.info("My Custom Step is triggered");

        log.info(item.getWorkflow().getWorkflowModel().toString());
        log.info(item.getWorkflow().getId());

        log.info(item.getWorkflowData().getPayload().toString());

    }
}



/*
 *    @Model --> Sling Model
 *    @Component(service=interface.calss) --> OSGI service
 *    @Component(service=Servlet.class) --> Servlets
 *    @Component(service=Runnable.class) --> Scheduler
 *    @Component(service=WorkflowProcess.class) -- Workflows
*/