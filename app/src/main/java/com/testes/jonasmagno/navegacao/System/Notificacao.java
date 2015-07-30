package com.testes.jonasmagno.navegacao.System;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.testes.jonasmagno.navegacao.AberturaActivity;

/**
 * Created by jonas.magno on 30/07/2015.
 */
public class Notificacao {

    private NotificationManager notf;
    PendingIntent in;

    public Notificacao(PendingIntent pIntent){

        this.in = pIntent;

    }

    public boolean lancarNotificacaoAviso(){



        return false;
    }
}
