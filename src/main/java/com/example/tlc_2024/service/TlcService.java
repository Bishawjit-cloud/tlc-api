package com.example.tlc_2024.service;

import com.example.tlc_2024.response.DriverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class TlcService {

    private static final String URL = "https://data.cityofnewyork.us/resource/xjfq-wh2d.json?license_number=";

    @Autowired
    private RestTemplate restTemplate;

    public TlcService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DriverResponse getVehicleData(String licenseNumber) {
        String fullUrl = URL + licenseNumber;
        ResponseEntity<DriverResponse[]> response = restTemplate.getForEntity(fullUrl, DriverResponse[].class);

        DriverResponse[] driverResponses = response.getBody();
        if (driverResponses != null && driverResponses.length > 0) {
            return driverResponses[0]; // Return the first DriverResponse
        }
        return null; // or throw an exception if you prefer
    }
}
