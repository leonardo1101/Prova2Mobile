package com.example.leonardo.prova2.network.api;

import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.network.service.SocFService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by leonardo on 12/16/17.
 */

public class SocFAPI {
    private static SocFAPI instance;
    private SocFService socFService;

    public static SocFAPI getInstance() {
        if (instance == null) {
            instance = new SocFAPI();
        }

        return instance;
    }

    private SocFAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(defaultConverterFactory())
                .build();

        this.socFService = retrofit.create(SocFService.class);
    }

    private Converter.Factory defaultConverterFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }


    public Call<SocFListEntity> getSocF() {
        return socFService.getSocFist();
    }
}


