package org.example.backgroundcheckprocessing.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;

@WorkflowInterface
public interface BackgroundCheckWorkflow {

    @WorkflowMethod
    BackgroundCheckResponse backgroundCheck(BackgroundCheckRequest backgroundCheckRequest);
}
