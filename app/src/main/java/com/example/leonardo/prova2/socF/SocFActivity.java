package com.example.leonardo.prova2.socF;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socf);

        ButterKnife.bind(this);
        socFPresenter = new socFPresenter(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        socFPresenter.addSocFInList(requestCode, resultCode, data);
    }

    @Override
    public void updateList(List<String> moviesList) {

        //seta o adapter
        SocFAdapter socFAdapter = new SocFAdapter(moviesList);
        socFAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(SocFActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }

        });

        rvSocF.setAdapter(socFAdapter);

        // criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvSocF.setLayoutManager(layoutManager);
    }
}
