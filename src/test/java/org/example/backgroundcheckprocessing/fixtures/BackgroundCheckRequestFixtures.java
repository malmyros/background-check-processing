package org.example.backgroundcheckprocessing.fixtures;

import lombok.experimental.UtilityClass;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;

@UtilityClass
public class BackgroundCheckRequestFixtures {

    public static String SOCIAL_SECURITY_NUMBER = "409-52-2002";

    public static BackgroundCheckRequest getBackgroundCheckRequest() {
        return new BackgroundCheckRequest(SOCIAL_SECURITY_NUMBER);
    }
}
