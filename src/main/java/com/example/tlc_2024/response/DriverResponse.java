package com.example.tlc_2024.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class DriverResponse {

    @JsonProperty("license_number")
    private String licenseNumber; // Updated field
    private String name;

    @JsonProperty("type")
    private String licenseType; // Updated field
    @JsonProperty("expiration_date")
    private String expirationDate; // Keep as String

    @JsonProperty("wheelchair_accessible_trained")
    private String wheelchairAccessibleTrained; // Updated field
    @JsonProperty("last_date_updated")
    private String lastDateUpdated; // Keep as String
    @JsonProperty("last_time_updated")
    private String lastTimeUpdated; // Keep as String

    // Custom setter for last_date_updated
    public void setLastDateUpdated(String lastDateUpdated) {
        if (lastDateUpdated != null) {
            LocalDateTime dateTime = LocalDateTime.parse(lastDateUpdated);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            this.lastDateUpdated = dateTime.format(dateFormatter);
        } else {
            this.lastDateUpdated = null;
        }
    }

    // Custom setter for last_time_updated
    public void setLastTimeUpdated(String lastTimeUpdated) {
        if (lastTimeUpdated != null) {
            LocalTime time = LocalTime.parse(lastTimeUpdated);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
            this.lastTimeUpdated = time.format(timeFormatter);
        } else {
            this.lastTimeUpdated = null;
        }
    }

    // Custom setter for expiration_date
    public void setExpirationDate(String expirationDate) {
        if (expirationDate != null) {
            LocalDateTime dateTime = LocalDateTime.parse(expirationDate); // Parse with time
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            this.expirationDate = dateTime.toLocalDate().format(dateFormatter); // Extract date and format
        } else {
            this.expirationDate = null;
        }
    }
}
