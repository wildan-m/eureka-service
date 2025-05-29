package com.compudata.eurekadetails.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

/**
 * Base response class for all API responses.
 */
@Data
@Builder
public class ApiResponse {
    private String returnCode;
    private String message;
    private Integer httpStatusCode;
    private String transactionId;
    private float elapsedTime;
    private List<Server> servers;
    private List<Service> services;

    @Data
    @Builder
    public static class Server {
        private String hostName;
        private List<ServiceInstance> services;
    }

    @Data
    @Builder
    public static class Service {
        private String serviceName;
        private List<ServiceInstance> servers;
    }
}
