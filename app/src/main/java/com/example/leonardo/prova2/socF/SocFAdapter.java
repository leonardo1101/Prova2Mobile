package com.example.leonardo.prova2.socF;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.leonardo.prova2.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leonardo on 12/16/17.
 */

public class SocFAdapter extends RecyclerView.Adapter<SocFAdapter.ViewHolder> {

    private List<String> socFList;
    OnRecyclerViewSelected onRecyclerViewSelected;

    //Construtor que recebe a lista
    SocFAdapter(List<String> moviesList) {
        this.socFList = moviesList;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_socf, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txMovieName.setText(socFList.get(position));
        //holder.imgBackgroud.setImageBitmap();
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return socFList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.soc_name)
        TextView txMovieName;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());
        }

    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
