package dev.y.backend.repository;

import java.util.List;

public interface OrbiterRepository {
    List<String> getOrbiters(String orbiteeId);
    void createOrbiter(String orbiteeId, String orbiterId);
    void deleteOrbiter(String orbiteeId, String orbiterId);
}
