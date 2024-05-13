package com.aditya.notificationservice.dto;

import com.aditya.notificationservice.entity.VisitType;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
public class VisitTrackerDTO {

    private Integer version;

    private String visitorUsername;

    private String fullName;

    private String ownerUsername;

    private Long ownerAddressId;

    private String AddressName;

    private LocalDateTime visitDateTime;

    private LocalDateTime exitDateTime;

    private LocalDateTime dateTimeOfVisitSchedule;

    private VisitType visitType;

    private LocalDateTime actualVisitDateTime;

    private LocalDateTime actualExitDateTime;

    private String AuthCode;

    private Integer NumberOfVisitors;

    private Boolean isVehiclePresent;

    private String visitorVehicleName;

    private Boolean ownerApproval;

    private LocalDateTime approvalOrRejectionTime;

    private String rejectionReason;

    private String extraManualComments;

}
