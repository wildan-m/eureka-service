package com.compudata.eurekadetails.model;

import lombok.Builder;
import lombok.Data;
import java.util.Map;

/**
 * Model class representing a service instance in Eureka.
 */
@Data
@Builder
public class ServiceInstance {
    private String serviceName;
    private String ipAddr;
    private String port;
    private String securePort;
    private String url;
    private String homePageUrl;
    private String statusPageUrl;
    private String status;
    private String lastUpdatedTimestamp;
    private String lastDirtyTimestamp;
    private boolean isCoordinatingDiscoveryServer;
    private Map<String, String> metadataMap;
    private LeaseInfo leaseInfo;
}
