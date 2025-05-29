package com.compudata.eurekadetails.controller;

import com.compudata.eurekadetails.model.ApiResponse;
import com.compudata.eurekadetails.model.EurekaQueryRequest;
import com.compudata.eurekadetails.service.EurekaQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for handling Eureka query requests.
 */
@RestController
@RequestMapping("/cdi-eureka-service/v1/eureka")
@RequiredArgsConstructor
public class EurekaQueryController {

    private final EurekaQueryService eurekaQueryService;

    /**
     * Endpoint for retrieving applications from Eureka server.
     *
     * @param request The query request containing Eureka server URL and grouping preference
     * @return Response containing service/server details based on grouping preference
     */
    @GetMapping("/apps")
    public ResponseEntity<ApiResponse> getApplications(@Valid @RequestBody EurekaQueryRequest request) {
        return ResponseEntity.ok(eurekaQueryService.queryEurekaServer(request));
    }
}
