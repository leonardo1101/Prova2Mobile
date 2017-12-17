package com.example.leonardo.prova2.Entity;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFListEntity {

    @SerializedName("acoes_sociais")
    @Expose
    public List<SocFEntity> acoes_sociais = null;

    public List<SocFEntity> getSocFist() {
        return acoes_sociais;
    }


}
