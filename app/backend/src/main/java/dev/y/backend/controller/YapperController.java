package dev.y.backend.controller;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.service.YapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api/v1/yappers")
@RequiredArgsConstructor
public class YapperController {

    private final YapperService yapperService;

    @GetMapping
    public ResponseEntity<List<YapperDTO>> getAllYappers(){
        List<YapperDTO> yappers = yapperService.getAllYappers();
        if(Objects.isNull(yappers)){
            yappers = List.of();
        }
        return ResponseEntity.ok(yappers);
    }

    @GetMapping("{yapperId}")
    public ResponseEntity<Object> getYapperByYapperId(@PathVariable String yapperId){
        YapperDTO yapperDTO = yapperService.getYapperByYapperId(yapperId);
        if(Objects.isNull(yapperDTO)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Yapper not here fam!"));
        }
        return ResponseEntity.ok(yapperDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public YapperDTO createYapper(@RequestBody YapperDTO yapperDTO){
        return yapperService.createYapper(yapperDTO);
    }
}
