package dev.y.backend.controller;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.service.OrbiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/yappers/{orbiteeId}/orbiters")
@RequiredArgsConstructor
public class OrbiterController {

    private final OrbiterService orbiterService;

    @GetMapping
    public ResponseEntity<Object> getOrbiters(@PathVariable String orbiteeId){
        List<YapperDTO> orbiters = orbiterService.getOrbiters(orbiteeId);
        if(Objects.isNull(orbiters)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Yapper not here fam!"));
        }
        return ResponseEntity.ok(orbiters);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrbiter(@PathVariable String orbiteeId, @RequestBody Map<String, Object> payload){
        String orbiterId = String.valueOf(payload.get("orbiterId"));
        boolean success = orbiterService.createOrbiter(orbiteeId, orbiterId);
        if(success){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of("success", "Entered their orbit!"));
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Yapper not here fam!"));
    }

    @DeleteMapping("{orbiterId}")
    public ResponseEntity<Map<String, String>> deleteOrbiter(@PathVariable String orbiteeId, @PathVariable String orbiterId){
        boolean success = orbiterService.deleteOrbiter(orbiteeId, orbiterId);
        if(success){
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Yapper not here fam!"));
    }
}
