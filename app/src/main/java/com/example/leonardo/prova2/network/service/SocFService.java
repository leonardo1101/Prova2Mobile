package com.example.leonardo.prova2.network.service;

import com.example.leonardo.prova2.Entity.SocFListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by leonardo on 12/16/17.
 */

public interface SocFService {

    SocFListEntity getSocF();
}
