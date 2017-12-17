package com.example.leonardo.prova2.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFListEntity {

    @SerializedName("acoes_sociais")
    public List<SocFEntity> socF;

    public List<SocFEntity> getSocF() {
        return socF;
    }
    public void addSocF(SocFEntity socFE) {
        socF.add(socFE);
    }
}
