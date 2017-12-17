package com.example.leonardo.prova2.Entity;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFEntity {

    private int id;
    private String nome;
    private String descricao;
    private String imageURL;
    private String site;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getSite() {
        return site;
    }

    public int getId() {
        return id;
    }

}
