package org.example.backgroundcheckprocessing.activities;

import io.temporal.testing.TestActivityEnvironment;
import io.temporal.testing.TestEnvironmentOptions;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;
import org.example.backgroundcheckprocessing.fixtures.BackgroundCheckRequestFixtures;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackgroundCheckActivitiesTest {

    private TestActivityEnvironment testEnv;

    @Before
    public void setup() {
        testEnv = TestActivityEnvironment.newInstance(
                TestEnvironmentOptions.newBuilder()
                        .setUseTimeskipping(false)
                        .build());
    }

    @Test
    public void shouldReturnTheBackgroundCheckStatus() {

        testEnv.registerActivitiesImplementations(new BackgroundCheckActivitiesImpl());

        BackgroundCheckActivities backgroundCheckActivities = testEnv
                .newActivityStub(BackgroundCheckActivities.class);

        BackgroundCheckStatus backgroundCheckStatus = backgroundCheckActivities
                .ssnTraceActivity(BackgroundCheckRequestFixtures.SOCIAL_SECURITY_NUMBER);

        assertEquals(BackgroundCheckStatus.PASS, backgroundCheckStatus);
    }

}