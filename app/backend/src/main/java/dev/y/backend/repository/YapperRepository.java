package dev.y.backend.repository;

import dev.y.backend.dto.YapperDTO;
import dev.y.backend.model.Yapper;

import java.util.List;

public interface YapperRepository {
    public List<Yapper> getAllYappers();
    public Yapper getYapperByYapperId(String yapperId);
    public void createYapper(Yapper yapper);
}
