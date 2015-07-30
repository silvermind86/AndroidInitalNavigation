package com.testes.jonasmagno.navegacao.System;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.ConnectException;

/**
 * Created by jonas.magno on 30/07/2015.
 */
public class Coneccao {

    private ConnectivityManager connectivity;

    public Coneccao(ConnectivityManager c){
        this.connectivity = c;
    }


    public boolean checkInternetConnection() throws ConnectException {

        if(!(this.connectivity instanceof ConnectivityManager)){
            throw new ConnectException("A aplicação não forneceu componentes para verificar o estado da rede.");
        }
         // = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] inf = connectivity.getAllNetworkInfo();
        if (inf != null) {
            for (int i = 0; i < inf.length; i++)
                if (inf[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
        }

        return false;
    }
}
