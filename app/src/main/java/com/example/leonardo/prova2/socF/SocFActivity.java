package com.example.leonardo.prova2.socF;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.R;
import com.example.leonardo.prova2.SocFdetails.SocFDetailsActivity;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFActivity extends AppCompatActivity implements SocFView {

    @BindView(R.id.rv_socFilan)
    RecyclerView rvSocF;

    socFPresenter socFPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socf);
        ButterKnife.bind(this);

        socFPresenter = new socFPresenter(this);
        socFPresenter.setAdapterList();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void updateList(List<SocFEntity> socFList) {

            SocFAdapter socFAdapter;
            socFAdapter = new SocFAdapter(socFList,this);

            socFAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View view, int position) {
                    Intent openDetailActivity = new Intent(SocFActivity.this, SocFDetailsActivity.class);
                    SocFEntity socFEntity = new SocFEntity();
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
    public void saveMoviesInSharedPreferences(String jsonMovieEntity) {
        //salva json dos filmes para trabalhar ofline
        SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.socf),MODE_PRIVATE).edit();
        editor.putString(getString(R.string.socf_entity_json), jsonMovieEntity);
        editor.apply();
    }


}
