package dev.y.backend.controller;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.service.YapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1")
public class YapperController {

    private final YapperService yapperService;

    @Autowired
    public YapperController(YapperService yapperService){
        this.yapperService = yapperService;
    }

    @GetMapping("/yappers")
    public List<YapperDTO> getAllYappers(){
        return yapperService.getAllYappers();
    }

    @GetMapping("/yappers/:yapperId")
    public YapperDTO getYapperByYapperId(@PathVariable String yapperId){
        return yapperService.getYapperByYapperId(yapperId);
    }

    @PostMapping("/yappers")
    public void createYapper(@RequestBody YapperDTO yapperDTO){
        yapperService.createYapper(yapperDTO);
    }
}
