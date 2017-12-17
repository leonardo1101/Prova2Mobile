package com.example.leonardo.prova2.network.api;

import android.util.Log;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.network.service.SocFService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFAPI implements  SocFService{
    private static SocFAPI instance;
    private SocFService socFService;
    JSONObject Jobject;
    public static SocFAPI getInstance() {
        if (instance == null) {
            instance = new SocFAPI();
        }

        return instance;
    }

    private SocFAPI() {
        Response response;
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://www.dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais")
                .build();
        try {
            response = client.newCall(request).execute();
            String jsonData = response.body().string().toString();
            try {
                Jobject = new JSONObject(jsonData);
            }catch (JSONException e) {
                //some exception handler code.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Converter.Factory defaultConverterFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }

    @Override
    public SocFListEntity getSocF() {
        SocFListEntity socFListEntity = new SocFListEntity();
        SocFEntity socFEntity = new SocFEntity();
        try {
            JSONArray jArray = Jobject.getJSONArray("acoes_sociais");
            for (int i=0;i<jArray.length();i++){
                JSONObject obj = jArray.getJSONObject(i);
                socFEntity.setId(obj.getInt("id"));
                socFEntity.setDescricao(obj.getString("description").toString());
                socFEntity.setNome(obj.getString("name").toString());
                socFEntity.setSite(obj.getString("site").toString());
                socFEntity.setImageURL(obj.getString("image").toString());
                socFListEntity.addSocF(socFEntity);
            }
        }catch (JSONException e) {
            //some exception handler code.
        }
        return socFListEntity;
    }
}


