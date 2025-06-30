package org.example.backgroundcheckprocessing.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


@Schema(description = "The background check request")
public record BackgroundCheckRequest(

        @JsonDeserialize
        @NotBlank(message = "The social security number cannot be empty")
        @Schema(description = "The social security number", example = "409-52-2002")
        String socialSecurityNumber
) {
}
