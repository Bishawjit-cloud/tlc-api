package com.example.tlc_2024.api;

import com.example.tlc_2024.response.DriverResponse;
import com.example.tlc_2024.response.VehicleInfoResponse;
import com.example.tlc_2024.service.TlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tlc")
// if UI is added as static content using this annotation is optional
@CrossOrigin
public class TlcController {

    @Autowired
    private TlcService tlcService;

    public TlcController(TlcService tlcService) {
        this.tlcService = tlcService;
    }

    @GetMapping("/license-status/{licenseNumber}")
    public ResponseEntity<DriverResponse> getDriverInfo(@PathVariable String licenseNumber) {
        DriverResponse driverResponses = tlcService.getDriverInfo(licenseNumber);
        return ResponseEntity.ok(driverResponses);
    }

    @GetMapping("/plate-number/{plateNumber}")
    public ResponseEntity<VehicleInfoResponse> getVehicleInfo(@PathVariable String plateNumber) {
        VehicleInfoResponse vehicleInfo = tlcService.getVehicleInfo(plateNumber);
        return ResponseEntity.ok(vehicleInfo);
    }
}
