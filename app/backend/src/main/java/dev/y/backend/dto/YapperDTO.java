package dev.y.backend.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class YapperDTO {
    private String yapperId;
    private String name;
    private String email;
    private Instant dob;
}
