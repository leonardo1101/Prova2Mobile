package com.example.leonardo.prova2.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFEntity {

    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String nome;
    @SerializedName("description")
    public String descricao;
    @SerializedName("image")
    public String imageURL;
    @SerializedName("site")
    public String site;

}
