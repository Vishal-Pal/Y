package dev.y.backend.service;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.mapper.YapperMapper;
import dev.y.backend.model.Yapper;
import dev.y.backend.repository.OrbiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrbiterService {

    private final OrbiterRepository orbiterRepository;
    private final YapperService yapperService;

    public List<YapperDTO> getOrbiters(String orbiteeId) {
        boolean orbiteeYapperExists = yapperService.doesYapperExist(orbiteeId);
        if(!orbiteeYapperExists){
            return null;
        }
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

    public boolean createOrbiter(String orbiteeId, String orbiterId) {
        boolean orbiteeYapperExists = yapperService.doesYapperExist(orbiteeId);
        if(!orbiteeYapperExists){
            return false;
        }
        boolean orbiterYapperExists = yapperService.doesYapperExist(orbiterId);
        if(!orbiterYapperExists){
            return false;
        }
        orbiterRepository.createOrbiter(orbiteeId, orbiterId);
        return true;
    }

    public boolean deleteOrbiter(String orbiteeId, String orbiterId) {
        boolean orbiteeYapperExists = yapperService.doesYapperExist(orbiteeId);
        if(!orbiteeYapperExists){
            return false;
        }
        List<String> orbiterIds = orbiterRepository.getOrbiters(orbiteeId);
        if(Objects.isNull(orbiterIds)
                || orbiterIds.isEmpty()){
            return true;
        }
        boolean orbiterYapperExists = yapperService.doesYapperExist(orbiterId);
        if(!orbiterYapperExists){
            return false;
        }
        orbiterRepository.deleteOrbiter(orbiteeId, orbiterId);
        return true;
    }
}
