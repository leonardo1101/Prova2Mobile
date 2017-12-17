package com.example.leonardo.prova2.Entity;

import java.util.List;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFListEntity {
    private List<SocFEntity> socF;

    public List<SocFEntity> getSocF() {
        return socF;
    }
    public void addSocF(SocFEntity socFE) {
        socF.add(socFE);
    }
}
