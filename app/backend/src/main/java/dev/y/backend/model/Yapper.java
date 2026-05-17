package dev.y.backend.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Data
public class Yapper {
    private int uuid;
    private String yapperId;
    private String name;
    private String email;
    private Instant dob;
    private Instant spawnedOn;
}
