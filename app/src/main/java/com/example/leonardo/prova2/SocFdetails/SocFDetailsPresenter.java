package com.example.leonardo.prova2.SocFdetails;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.network.api.SocFAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leonardo on 12/18/17.
 */

public class SocFDetailsPresenter {
    private SocFDetailsView view;

    public SocFDetailsPresenter(SocFDetailsView viewP) {
        this.view = viewP;
    }

}
