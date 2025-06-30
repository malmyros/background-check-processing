package org.example.backgroundcheckprocessing.workflows;

import io.temporal.activity.ActivityOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import org.example.backgroundcheckprocessing.activities.BackgroundCheckActivities;
import org.example.backgroundcheckprocessing.common.Workflows;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;
import org.example.backgroundcheckprocessing.factory.BackgroundCheckResponseFactory;

import java.time.Duration;

@WorkflowImpl(workers = Workflows.BACKGROUND_CHECK_WORKER, taskQueues = Workflows.BACKGROUND_CHECK_TASK_QUEUE)
public class BackgroundCheckWorkflowImpl implements BackgroundCheckWorkflow {

    ActivityOptions activityOptions = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build();

    private final BackgroundCheckActivities backgroundCheckActivities =
            Workflow.newActivityStub(BackgroundCheckActivities.class, activityOptions);

    @Override
    public BackgroundCheckResponse backgroundCheck(
            BackgroundCheckRequest backgroundCheckRequest) {

        String socialSecurityNumber = backgroundCheckRequest.socialSecurityNumber();
        BackgroundCheckStatus backgroundCheckStatus = backgroundCheckActivities
                .ssnTraceActivity(socialSecurityNumber);

        return BackgroundCheckResponseFactory.getBackgroundCheckResponse(
                socialSecurityNumber, backgroundCheckStatus);
    }
}
