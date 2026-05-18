package dev.y.backend.repository;

import dev.y.backend.model.Yapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        return new ArrayList<>(yapperIdToYapperMap.values());
    }

    @Override
    public Yapper getYapperByYapperId(String yapperId) {
        return yapperIdToYapperMap.get(yapperId);
    }

    @Override
    public void createYapper(Yapper yapper) {
        String yapperId = yapper.getYapperId();
        yapperIdToYapperMap.put(yapperId, yapper);
    }
}
