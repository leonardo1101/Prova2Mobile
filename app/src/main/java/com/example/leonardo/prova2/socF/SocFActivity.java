package com.example.leonardo.prova2.socF;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.leonardo.prova2.Entity.SocFListEntity;
import com.example.leonardo.prova2.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFActivity extends AppCompatActivity implements SocFView {

    @BindView(R.id.rv_socFilan)
    RecyclerView rvSocF;

    socFPresenter socFPresenter;
    SocFAdapter socFAdapter;


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


    public void updateList(SocFListEntity socFLisi) {
        socFAdapter = new SocFAdapter(socFLisi.getSocF());

        socFAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(SocFActivity.this, "Clique rápido", Toast.LENGTH_SHORT).show();
            }
        });

        rvSocF.setAdapter(socFAdapter);

    }
}
