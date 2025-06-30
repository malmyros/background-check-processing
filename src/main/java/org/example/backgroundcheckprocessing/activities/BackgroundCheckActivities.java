package org.example.backgroundcheckprocessing.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;

@ActivityInterface
public interface BackgroundCheckActivities {

    @ActivityMethod
    BackgroundCheckStatus ssnTraceActivity(String socialSecurityNumber);
}
