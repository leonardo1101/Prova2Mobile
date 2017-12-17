package com.example.leonardo.prova2.network.api;

import android.app.Activity;
import android.net.http.RequestQueue;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.network.service.SocFService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import com.example.leonardo.prova2.socF.SocFActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFAPI  extends Activity implements  SocFService {
    private static SocFAPI instance;
    private SocFService socFService;
    private SocFListEntity socFListy;

    private static final String ENDPOINT=" https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais.json;";
    private com.android.volley.RequestQueue requestQueue;

    private Gson gson;

    public static SocFAPI getInstance() {
        if (instance == null) {
            instance = new SocFAPI();
        }

        return instance;
    }

    private SocFAPI() {
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();
        fetchPosts();

    }

    private void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<SocFListEntity> socFListEntity = Arrays.asList(gson.fromJson(response,SocFListEntity.class));

            Log.i("PostActivity", socFListEntity.size() + " posts loaded.");
            for (SocFListEntity socFEL : socFListEntity) {
                socFListy = socFEL;
            }
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("PostActivity", error.toString());
        }
    };


    @Override
    public SocFListEntity getSocF() {
        fetchPosts();
        return socFListy;
    }
}


