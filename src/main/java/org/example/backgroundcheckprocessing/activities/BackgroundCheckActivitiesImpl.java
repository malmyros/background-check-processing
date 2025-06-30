package org.example.backgroundcheckprocessing.activities;

import io.temporal.workflow.Workflow;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BackgroundCheckActivitiesImpl implements BackgroundCheckActivities {

    private static final Logger logger = LoggerFactory.getLogger(BackgroundCheckActivitiesImpl.class);

    @Override
    public BackgroundCheckStatus ssnTraceActivity(String socialSecurityNumber) {

        // Adding sleep to simulate a request to an external service
        logger.info("Sleeping for 10 seconds");
        Workflow.sleep(Duration.ofSeconds(10));

        // This is where a call to another service would be made to perform the trace
        // We are simulating that the service that does SSNTrace executed successfully
        // with a passing value being returned
        return BackgroundCheckStatus.PASS;
    }
}
