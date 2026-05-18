package dev.y.backend.repository.impl;

import dev.y.backend.model.Yapper;
import dev.y.backend.repository.OrbiterRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryOrbiterRepositoryImpl implements OrbiterRepository {

    private final Map<String, Set<String>> orbiterIdToOrbiteeIdSetMap;

    public InMemoryOrbiterRepositoryImpl(){
        orbiterIdToOrbiteeIdSetMap = new HashMap<>();
    }

    @Override
    public List<String> getOrbiters(String orbiteeId) {
        return new ArrayList<>(orbiterIdToOrbiteeIdSetMap.get(orbiteeId));
    }

    @Override
    public void createOrbiter(String orbiteeId, String orbiterId) {
        Set<String> existingOrbiters = orbiterIdToOrbiteeIdSetMap.getOrDefault(orbiteeId, new HashSet<>());
        existingOrbiters.add(orbiterId);
        orbiterIdToOrbiteeIdSetMap.put(orbiteeId, existingOrbiters);
    }

    @Override
    public void deleteOrbiter(String orbiteeId, String orbiterId) {
        Set<String> existingOrbiters = orbiterIdToOrbiteeIdSetMap.get(orbiteeId);
        if(Objects.isNull(existingOrbiters)
                || existingOrbiters.isEmpty()){
            return;
        }
        existingOrbiters.remove(orbiterId);
        orbiterIdToOrbiteeIdSetMap.put(orbiteeId, existingOrbiters);
    }
}
