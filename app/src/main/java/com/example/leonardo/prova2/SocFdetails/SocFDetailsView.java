package com.example.leonardo.prova2.SocFdetails;

import com.example.leonardo.prova2.Entity.SocFEntity;

/**
 * Created by leonardo on 12/18/17.
 */

public interface SocFDetailsView {
    void showDetails(SocFEntity socFEntity);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
