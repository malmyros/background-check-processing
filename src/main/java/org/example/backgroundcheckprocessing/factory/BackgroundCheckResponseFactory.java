package org.example.backgroundcheckprocessing.factory;

import lombok.experimental.UtilityClass;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckStatus;

@UtilityClass
public class BackgroundCheckResponseFactory {

    public static BackgroundCheckResponse getBackgroundCheckResponse(
            String socialSecurityNumber,
            BackgroundCheckStatus backgroundCheckStatus) {

        return new BackgroundCheckResponse(socialSecurityNumber, backgroundCheckStatus);
    }
}
