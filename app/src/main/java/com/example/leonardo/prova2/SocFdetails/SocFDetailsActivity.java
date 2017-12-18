package com.example.leonardo.prova2.SocFdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonardo.prova2.Entity.SocFEntity;
import com.example.leonardo.prova2.R;
import com.example.leonardo.prova2.socF.SocFView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocFDetailsActivity extends AppCompatActivity {


    @BindView(R.id.image_view_header)
    ImageView imgHeader;

    @BindView(R.id.socfname)
    TextView socfname;

    @BindView(R.id.socfdesc)
    TextView socfdesc ;

    @BindView(R.id.socfsite)
    TextView socfsite ;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    SocFEntity socFEntity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soc_filan);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ButterKnife.bind(this);
        socFEntity = (SocFEntity) getIntent().getSerializableExtra("socfe");
        setDetails(socFEntity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void setDetails(SocFEntity socFEntity) {
        Picasso.with(this)
                .load(socFEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        socfname.setText(socFEntity.getName());
        socfdesc.setText(socFEntity.getDescription());
        socfsite.setText(socFEntity.getSite());
        setTitle(socFEntity.getName());
    }



}
