package dev.y.backend.service;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.mapper.YapperMapper;
import dev.y.backend.model.Yapper;
import dev.y.backend.repository.YapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class YapperService {

    private int globalYapperUuid;
    private final YapperRepository yapperRepository;

    @Autowired
    public YapperService(YapperRepository yapperRepository) {
        this.yapperRepository = yapperRepository;
        globalYapperUuid = 0;
    }


    public List<YapperDTO> getAllYappers(){
        List<Yapper> yapperList =  yapperRepository.getAllYappers();
        return yapperList.stream().map(YapperMapper::toDTO).toList();
    }

    public YapperDTO getYapperByYapperId(String yapperId){
        Yapper yapper = yapperRepository.getYapperByYapperId(yapperId);
        return yapper == null? null:YapperMapper.toDTO(yapper);
    }

    public YapperDTO createYapper(YapperDTO yapperDTO){
        Yapper yapper = YapperMapper.toEntity(yapperDTO);
        yapper.setUuid(globalYapperUuid++);
        yapper.setSpawnedOn(Instant.now());
        yapperRepository.createYapper(yapper);
        return yapperDTO;
    }

    public boolean doesYapperExist(String yapperId){
        Yapper yapper = yapperRepository.getYapperByYapperId(yapperId);
        return yapper != null;
    }
}
