package com.example.leonardo.prova2.socF;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.R;
import com.example.leonardo.prova2.SocFdetails.SocFDetailsActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFActivity extends AppCompatActivity implements SocFView {

    @BindView(R.id.rv_socFilan)
    RecyclerView rvSocF;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    private socFPresenter socFPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socf);
        ButterKnife.bind(this);

        socFPresenter = new socFPresenter(this);
        socFPresenter.setAdapterList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download:
                socFPresenter.saveMovies();

            default:
                return super.onOptionsItemSelected(item);
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void updateList(List<SocFEntity> socFList) {

            SocFAdapter socFAdapter;
            socFAdapter = new SocFAdapter(socFList,this);

            socFAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View view, int position) {
                    Intent openDetailActivity = new Intent(SocFActivity.this, SocFDetailsActivity.class);
                    SocFEntity socFEntity;
                    socFEntity = socFPresenter.getMovieId(position);
                    openDetailActivity.putExtra("socfe",socFEntity);
                    startActivity(openDetailActivity);
                }
            });

            rvSocF.setAdapter(socFAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rvSocF.setLayoutManager(layoutManager);

    }
    @Override
    public void saveSocFInSharedPreferences(String jsonSocFEntity) {
        //salva json dos filmes para trabalhar ofline
        SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.socf),MODE_PRIVATE).edit();
        editor.putString(getString(R.string.socf_entity_json), jsonSocFEntity);
        editor.apply();
    }
    @Override
    public void workOffline() {
        SharedPreferences preferences = getSharedPreferences(getString(R.string.socf), MODE_PRIVATE);
        String jsonSocF = preferences.getString(getString(R.string.socf_entity_json), null);
        socFPresenter.openSocF(jsonSocF);

    }
    @Override
    public void openSocF(String jsonSocF) {
        SocFListEntity socFListEntity = new Gson().fromJson(jsonSocF, SocFListEntity.class);
        if(socFListEntity.getSocFList() != null) {
            Log.e("Teste:",""+socFListEntity.getSocFList().size());
            List<SocFEntity> socFList = socFListEntity.getSocFList();
            socFPresenter.setListOff(socFList);
            updateList(socFList);
        }
    }


}
