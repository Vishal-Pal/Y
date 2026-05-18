package dev.y.backend.service;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.mapper.YapperMapper;
import dev.y.backend.model.Yapper;
import dev.y.backend.repository.OrbiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrbiterService {

    private final OrbiterRepository orbiterRepository;
    private final YapperService yapperService;

    @Autowired
    public OrbiterService(OrbiterRepository orbiterRepository, YapperService yapperService) {
        this.orbiterRepository = orbiterRepository;
        this.yapperService = yapperService;
    }

    public List<YapperDTO> getOrbiters(String orbiteeId) {
        List<String> orbiterIds = orbiterRepository.getOrbiters(orbiteeId);
        List<YapperDTO> orbiterList = new ArrayList<>();
        for(String orbiterId: orbiterIds){
            YapperDTO yapperDTO = yapperService.getYapperByYapperId(orbiterId);
            if(Objects.isNull(yapperDTO)){
                continue;
            }
            orbiterList.add(yapperDTO);
        }
        return orbiterList;
    }

    public String createOrbiter(String orbiteeId, String orbiterId) {
        orbiterRepository.createOrbiter(orbiteeId, orbiterId);
        return "success : \"Entered their orbit!\"";
    }

    public void deleteOrbiter(String orbiteeId, String orbiterId) {
        orbiterRepository.deleteOrbiter(orbiteeId, orbiterId);
    }
}
