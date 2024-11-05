package com.example.tlc_2024.api;

import com.example.tlc_2024.response.DriverResponse;
import com.example.tlc_2024.service.TlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tlc")
@CrossOrigin
public class TlcController {

    @Autowired
    private TlcService tlcService;

    @GetMapping("/license-status/{licenseNumber}")
    public ResponseEntity<DriverResponse> fetchData(@PathVariable String licenseNumber) {
        DriverResponse driverResponses = tlcService.getVehicleData(licenseNumber);

        return ResponseEntity.ok(driverResponses); // Return 200 OK with the DriverResponse data
    }
}
