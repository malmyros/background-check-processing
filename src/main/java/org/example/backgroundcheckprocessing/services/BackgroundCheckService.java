package org.example.backgroundcheckprocessing.services;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.example.backgroundcheckprocessing.common.Workflows;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;
import org.example.backgroundcheckprocessing.workflows.BackgroundCheckWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundCheckService {

    @Autowired
    private WorkflowClient workflowClient;

    public BackgroundCheckResponse processBackgroundCheck(
            BackgroundCheckRequest backgroundCheckRequest) {

        long currentTime = System.nanoTime();
        String workflowId = "process-background-check-%s".formatted(currentTime);
        WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
                .setWorkflowId(workflowId)
                .setTaskQueue(Workflows.BACKGROUND_CHECK_TASK_QUEUE)
                .build();

        BackgroundCheckWorkflow backgroundCheckWorkflow = workflowClient
                .newWorkflowStub(BackgroundCheckWorkflow.class, workflowOptions);
        return backgroundCheckWorkflow.backgroundCheck(backgroundCheckRequest);
    }
}
