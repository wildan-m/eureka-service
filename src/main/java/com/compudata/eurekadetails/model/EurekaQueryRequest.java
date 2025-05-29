package com.compudata.eurekadetails.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Request model for querying Eureka server details.
 */
@Data
public class EurekaQueryRequest {
    @NotBlank(message = "eurekaServerURL is required")
    private String eurekaServerURL;
    
    private String groupBy = "servers"; // Default value as per specification
}
