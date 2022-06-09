package com.hrs.hrsystem.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

// Author --Fahim
@Component
@Data
public class EmergencyDetails {
    private User user;
    private List<DoctorDetail> familyDoctors;
    private List<Documents> documents;
    private List<InsuranceDetail> insuranceDetails;
    private List<ContactPersonDetail> contactPersonDetails;
    private List<Report> reports;
}
