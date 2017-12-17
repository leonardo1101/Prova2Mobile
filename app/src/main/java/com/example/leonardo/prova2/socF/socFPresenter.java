package com.example.leonardo.prova2.socF;

import android.support.annotation.NonNull;

import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.network.api.SocFAPI;

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
    private List<String> socFList = new ArrayList<>();

    socFPresenter(SocFView socFView){
        this.socFView = socFView;
   }

    protected void setAdapterList(){
        final SocFAPI socFAPI = SocFAPI.getInstance();
        socFView.updateList(socFAPI.getSocF());
    }
}
