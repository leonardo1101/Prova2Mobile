package com.example.leonardo.prova2.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFEntity implements Serializable{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("site")
    @Expose
    private String site;

    private static final long serialVersionUID = 46543445;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage () {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getSite() {
        return site;
    }

}
