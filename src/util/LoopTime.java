/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

public class LoopTime {
    public static final long TEMPO = 60000;

    public static void main(String[] args) {
        System.out.println("inicio");
        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask(){

                @Override
                public void run() {
                    try {
                        System.out.println("Teste agendador");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, 60000, 60000);
        }
    }

}

