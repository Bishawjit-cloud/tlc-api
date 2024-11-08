package com.example.tlc_2024.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class VehicleInfoResponse {

    private String active;

    @JsonProperty("vehicle_license_number")
    private String vehicleLicenseNumber;

    private String name;

    @JsonProperty("license_type")
    private String licenseType;

    @JsonProperty("expiration_date")
    private String expirationDate;

    @JsonProperty("permit_license_number")
    private String permitLicenseNumber;

    @JsonProperty("dmv_license_plate_number")
    private String dmvLicensePlateNumber;

    @JsonProperty("vehicle_vin_number")
    private String vehicleVinNumber;

    @JsonProperty("wheelchair_accessible")
    private String wheelchairAccessible;

    @JsonProperty("vehicle_year")
    private String vehicleYear;

    @JsonProperty("base_number")
    private String baseNumber;

    @JsonProperty("base_name")
    private String baseName;

    @JsonProperty("base_type")
    private String baseType;

    private String veh;

    @JsonProperty("base_telephone_number")
    private String baseTelephoneNumber;

    @JsonProperty("base_address")
    private String baseAddress;

    private String reason;

    @JsonProperty("last_date_updated")
    private String lastDateUpdated;

    @JsonProperty("last_time_updated")
    private String lastTimeUpdated;

    // Custom setter for last_date_updated (Formatted as MM/dd/yyyy)
    public void setLastDateUpdated(String lastDateUpdated) {
        if (lastDateUpdated != null) {
            // Assuming the input format is "yyyy-MM-dd'T'HH:mm:ss.SSS"
            LocalDateTime dateTime = LocalDateTime.parse(lastDateUpdated);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            this.lastDateUpdated = dateTime.format(dateFormatter);
        } else {
            this.lastDateUpdated = null;
        }
    }

    // Custom setter for last_time_updated (Formatted as hh:mm)
    public void setLastTimeUpdated(String lastTimeUpdated) {
        if (lastTimeUpdated != null) {
            // Assuming the input format is "HH:mm"
            LocalTime time = LocalTime.parse(lastTimeUpdated);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
            this.lastTimeUpdated = time.format(timeFormatter);
        } else {
            this.lastTimeUpdated = null;
        }
    }

    // Custom setter for expiration_date (Formatted as MM/dd/yyyy)
    public void setExpirationDate(String expirationDate) {
        if (expirationDate != null) {
            // Assuming the input format is "yyyy-MM-dd'T'HH:mm:ss.SSS"
            LocalDateTime dateTime = LocalDateTime.parse(expirationDate);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            this.expirationDate = dateTime.toLocalDate().format(dateFormatter);
        } else {
            this.expirationDate = null;
        }
    }
}
