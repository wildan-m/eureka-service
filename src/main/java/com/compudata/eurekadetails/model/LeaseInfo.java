package com.compudata.eurekadetails.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model class representing lease information for a service instance.
 */
@Data
@Builder
public class LeaseInfo {
    private Integer renewalIntervalInSecs;
    private Integer durationInSecs;
    private Long registrationTimestamp;
    private Long lastRenewalTimestamp;
    private Long evictionTimestamp;
    private Long serviceUpTimestamp;
}
