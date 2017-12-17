package com.example.leonardo.prova2.network.service;

import com.example.leonardo.prova2.Entity.SocFListEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by leonardo on 12/16/17.
 */

public interface SocFService {
    @GET("s/50vmlj7dhfaibpj/sociais.json")
    Call<SocFListEntity> getSocFist();
}
