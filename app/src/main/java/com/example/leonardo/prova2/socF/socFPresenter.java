package com.example.leonardo.prova2.socF;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 12/16/17.
 */

public class socFPresenter {

    private SocFView socFView;
    private List<String> socFList = new ArrayList<>();

    socFPresenter(SocFView socFView){
        this.socFView = socFView;
   }

    void addSocFInList(int requestCode, int resultCode, Intent data){
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            String socFName = data.getStringExtra("socFName");
            socFList.add(socFName);
            socFView.updateList(socFList);
        }
    }
}
