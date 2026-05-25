package dev.y.backend.mapper;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.model.Yapper;

public class YapperMapper {

    public static Yapper toEntity(YapperDTO yapperDTO){
        Yapper yapper = new Yapper();
        yapper.setYapperId(yapperDTO.getYapperId());
        yapper.setName(yapperDTO.getYapperName());
        yapper.setEmail(yapperDTO.getEmail());
        yapper.setDob(yapperDTO.getDob());
        return yapper;
    }

    public static YapperDTO toDTO(Yapper yapper){
        YapperDTO yapperDTO = new YapperDTO();
        yapperDTO.setYapperId(yapper.getYapperId());
        yapperDTO.setYapperName(yapper.getName());
        yapperDTO.setEmail(yapper.getEmail());
        yapperDTO.setDob(yapper.getDob());
        return yapperDTO;    }
}
