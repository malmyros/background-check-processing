package org.example.backgroundcheckprocessing.workflows;

import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowRule;
import org.example.backgroundcheckprocessing.activities.BackgroundCheckActivitiesImpl;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;
import org.junit.Rule;
import org.junit.Test;

import static org.example.backgroundcheckprocessing.fixtures.BackgroundCheckRequestFixtures.getBackgroundCheckRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BackgroundCheckWorkflowTest {

    @Rule
    public TestWorkflowRule testWorkflowRule =
            TestWorkflowRule.newBuilder()
                    .setWorkflowTypes(BackgroundCheckWorkflowImpl.class)
                    .setActivityImplementations(new BackgroundCheckActivitiesImpl())
                    .build();

    @Test
    public void shouldReturnTheBackgroundCheckResponse() {

        WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
                .setTaskQueue(testWorkflowRule.getTaskQueue())
                .build();

        BackgroundCheckWorkflow backgroundCheckWorkflow = testWorkflowRule
                .getWorkflowClient()
                .newWorkflowStub(
                        BackgroundCheckWorkflow.class,
                        workflowOptions);

        BackgroundCheckRequest backgroundCheckRequest = getBackgroundCheckRequest();
        BackgroundCheckResponse backgroundCheckResponse = backgroundCheckWorkflow
                .backgroundCheck(backgroundCheckRequest);

        assertNotNull(backgroundCheckResponse);
        assertEquals(backgroundCheckRequest.socialSecurityNumber(), backgroundCheckResponse.socialSecurityNumber());
        assertEquals(BackgroundCheckStatus.PASS, backgroundCheckResponse.backgroundCheckStatus());

        testWorkflowRule.getTestEnvironment().shutdown();
    }
}