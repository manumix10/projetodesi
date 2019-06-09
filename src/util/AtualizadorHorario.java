/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class AtualizadorHorario
extends Thread {
    private JLabel hr;
    private boolean mostrarData;

    public AtualizadorHorario(JLabel hora) {
        this.hr = hora;
    }

    public void mostrarData(boolean mostrar) {
        this.mostrarData = mostrar;
    }

    @Override
    public void run() {
        try {
            do {
                Date d = new Date();
                StringBuffer data = new StringBuffer();
                if (this.mostrarData) {
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
                    data.append(sdfData.format(d));
                    data.append(" - ");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                this.hr.setText(data.toString() + sdf.format(d));
                Thread.sleep(1000);
                this.hr.revalidate();
            } while (true);
        }
        catch (InterruptedException ex) {
            System.out.println("Problema na atualiza\u00e7\u00e3o da data/hora");
            ex.printStackTrace();
            return;
        }
    }
}

