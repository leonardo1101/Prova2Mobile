package com.example.leonardo.prova2.socF;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.network.api.SocFAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leonardo on 12/16/17.
 */

public class socFPresenter {

    private SocFView socFView;
    private List<SocFEntity> socFList;
    private SocFListEntity socFListEntity;

    socFPresenter(SocFView socFView){
        this.socFView = socFView;
   }

    protected void setAdapterList(){
        final SocFAPI socialActionsApi = SocFAPI.getInstance();
        socialActionsApi.getActions().enqueue(new Callback<SocFListEntity>() {
            @Override
            public void onResponse(Call<SocFListEntity> call, Response<SocFListEntity> response) {

                 socFListEntity = response.body();

                if(socFListEntity != null && socFListEntity.getSocFist() != null){
                    socFView.updateList(socFListEntity.getSocFist());
                }
            }
            @Override
            public void onFailure(Call<SocFListEntity> call, Throwable t) {

            }
        });
    }

    SocFEntity getMovieId(int position) throws IndexOutOfBoundsException {
        return socFListEntity.getSocFist().get(position);

    }

    void saveMovies() {
        String jsonMovieEntity = new Gson().toJson(socFListEntity);
        socFView.saveMoviesInSharedPreferences(jsonMovieEntity);
    }
}
