package dev.y.backend.controller;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.service.YapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/yappers")
@RequiredArgsConstructor
public class YapperController {

    private final YapperService yapperService;

    @GetMapping
    public ResponseEntity<List<YapperDTO>> getAllYappers(){
        List<YapperDTO> yappers = yapperService.getAllYappers();
        if(Objects.isNull(yappers)
                || yappers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(yappers);
    }

    @GetMapping("{yapperId}")
    public ResponseEntity<YapperDTO> getYapperByYapperId(@PathVariable String yapperId){
        YapperDTO yapperDTO = yapperService.getYapperByYapperId(yapperId);
        if(Objects.isNull(yapperDTO)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(yapperDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createYapper(@RequestBody YapperDTO yapperDTO){
        yapperService.createYapper(yapperDTO);
    }
}
