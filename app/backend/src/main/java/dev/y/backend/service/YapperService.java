package dev.y.backend.service;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.model.Yapper;
import dev.y.backend.repository.YapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YapperService {

    private final YapperRepository yapperRepository;

    @Autowired
    public YapperService(YapperRepository yapperRepository) {
        this.yapperRepository = yapperRepository;
    }


    public List<YapperDTO> getAllYappers(){
        // TODO
        List<Yapper> yapperList =  yapperRepository.getAllYappers();
        return List.of();
    }

    public YapperDTO getYapperByYapperId(String yapperId){
        // TODO
        Yapper yapper = yapperRepository.getYapperByYapperId(yapperId);
        return null;
    }

    public void createYapper(YapperDTO yapperDTO){
        // TODO
        //yapperRepository.createYapper(yapperDTO);
    }
}
