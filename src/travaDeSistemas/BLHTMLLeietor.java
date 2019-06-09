/*
 * Decompiled with CFR 0_122.
 */
package travaDeSistemas;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import sun.misc.BASE64Encoder;

public class BLHTMLLeietor {
    private URL url;
    private URLConnection conn;
    private boolean streamAberto = false;

    public static String encode(String source) {
        BASE64Encoder enc = new BASE64Encoder();
        return enc.encode(source.getBytes());
    }

    public boolean abrirConexao(String URL2, String pUsuario, String pSenha) {
        try {
            this.url = new URL(URL2);
            try {
                this.conn = this.url.openConnection();
                if (pUsuario != null) {
                    this.conn.setRequestProperty("Authorization", "Basic " + BLHTMLLeietor.encode(new StringBuilder().append(pUsuario).append(":").append(pSenha).toString()));
                }
            }
            catch (Exception e) {
                return false;
            }
        }
        catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    public ArrayList<String> lerPaginaHTML() {
        ArrayList<String> listaDeLinhas = new ArrayList<String>();

        this.streamAberto = true;
        return listaDeLinhas;
    }

    public boolean isStreamAberto() {
        return this.streamAberto;
    }

    public void setStreamAberto(boolean streamAberto) {
        this.streamAberto = streamAberto;
    }
}

