package org.example.backgroundcheckprocessing.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckRequest;
import org.example.backgroundcheckprocessing.dto.BackgroundCheckResponse;
import org.example.backgroundcheckprocessing.services.BackgroundCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/background-checks")
@RequiredArgsConstructor
public class BackgroundCheckController {

    private final BackgroundCheckService backgroundCheckService;

    @PostMapping
    public ResponseEntity<BackgroundCheckResponse> processBackgroundCheck(
            @Valid @RequestBody BackgroundCheckRequest backgroundCheckRequest) {

        BackgroundCheckResponse backgroundCheckResponse = backgroundCheckService
                .processBackgroundCheck(backgroundCheckRequest);

        return ResponseEntity.ok(backgroundCheckResponse);
    }
}
