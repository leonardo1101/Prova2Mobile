package com.example.leonardo.prova2.socF;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.Entity.SocFListEntity;

import java.util.List;

/**
 * Created by leonardo on 12/16/17.
 */

public interface SocFView {
    void updateList(List<SocFEntity> socFList);
    void saveMoviesInSharedPreferences(String jsonMovieEntity);
}
