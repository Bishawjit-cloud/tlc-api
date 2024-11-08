package com.example.tlc_2024.service;

import com.example.tlc_2024.response.DriverResponse;
import com.example.tlc_2024.response.VehicleInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TlcService {

    private static final String TLC_LICENSE_NUMBER_URL = "https://data.cityofnewyork.us/resource/xjfq-wh2d.json?license_number=";
    private static final String VEHICLE_PLATE_NUMBER_URL = "https://data.cityofnewyork.us/resource/8wbx-tsch.json?dmv_license_plate_number=";

    @Autowired
    private RestTemplate restTemplate;

    public TlcService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DriverResponse getDriverInfo(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.isEmpty()) {
            return null; // Early return if the license number is invalid
        }

        String fullUrl = TLC_LICENSE_NUMBER_URL + licenseNumber;
        ResponseEntity<DriverResponse[]> response = restTemplate.getForEntity(fullUrl, DriverResponse[].class);

        if (response != null && response.getBody() != null && response.getBody().length > 0) {
            return response.getBody()[0]; // Return the first DriverResponse
        }

        // Handle case where no data is found for the provided license number
        System.out.println("No driver information found for license number: " + licenseNumber);
        return null; // Return null if no data is found
    }

    public VehicleInfoResponse getVehicleInfo(String plateNumber) {
        if (plateNumber == null || plateNumber.isEmpty()) {
            return null; // Early return if the plate number is invalid
        }

        String fullUrl = VEHICLE_PLATE_NUMBER_URL + plateNumber;
        ResponseEntity<VehicleInfoResponse[]> response = restTemplate.getForEntity(fullUrl, VehicleInfoResponse[].class);

        if (response != null && response.getBody() != null && response.getBody().length > 0) {
            return response.getBody()[0]; // Return the first VehicleInfoResponse
        }

        // Handle case where no data is found for the provided plate number
        System.out.println("No vehicle information found for plate number: " + plateNumber);
        return null; // Return null if no data is found
    }
}
