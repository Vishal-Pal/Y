package dev.y.backend.repository;

import dev.y.backend.model.Yapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryYapperRepositoryImpl implements YapperRepository{

    private Map<String, Yapper> yapperIdToYapperMap;

    public InMemoryYapperRepositoryImpl(){
        this.yapperIdToYapperMap = new HashMap<>();
    }

    @Override
    public List<Yapper> getAllYappers() {
        // TODO
        return List.of();
    }

    @Override
    public Yapper getYapperByYapperId(String yapperId) {
        // TODO
        return null;
    }

    @Override
    public void createYapper(Yapper yapperDTO) {
        // TODO
    }
}
