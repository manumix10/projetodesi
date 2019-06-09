/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class MyTime
extends Observable
implements Runnable {
    private String horas;

    public MyTime(Observer obs) {
        this.addObserver(obs);
    }

    @Override
    public void run() {
        do {
            this.horas = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime());
            this.notifyObservers();
        } while (true);
    }

    public String getHoras() {
        return this.horas;
    }
}

