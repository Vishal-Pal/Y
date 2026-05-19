package dev.y.backend.controller;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.service.OrbiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/yappers/{orbiteeId}/orbiters")
@RequiredArgsConstructor
public class OrbiterController {

    private final OrbiterService orbiterService;

    @GetMapping
    public List<YapperDTO> getOrbiters(@PathVariable String orbiteeId){
        return orbiterService.getOrbiters(orbiteeId);
    }

    @PostMapping
    public String createOrbiter(@PathVariable String orbiteeId, @RequestBody Map<String, Object> payload){
        String orbiterId = String.valueOf(payload.get("orbiterId"));
        return orbiterService.createOrbiter(orbiteeId, orbiterId);
    }

    @DeleteMapping("{orbiterId}")
    public void deleteOrbiter(@PathVariable String orbiteeId, @PathVariable String orbiterId){
        orbiterService.deleteOrbiter(orbiteeId, orbiterId);
    }
}
