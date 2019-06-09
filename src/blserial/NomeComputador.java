/*
 * Decompiled with CFR 0_122.
 */
package blserial;

import java.io.PrintStream;
import java.net.InetAddress;

public class NomeComputador {
    public String getComputador() {
        String nomecomputador = new String();
        try {
            nomecomputador = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e) {
            System.out.println("Exception caught =" + e.getMessage());
        }
        return nomecomputador;
    }
}

