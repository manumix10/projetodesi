/*
 * Decompiled with CFR 0_122.
 */
package model;

import DAO.DAOAtualizacao;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import sun.misc.BASE64Encoder;

public class ModelAtualizacao {
    private boolean atualizadoDesatualizado;

    public void downloadAtualizacao() {
        try {
            File file3 = new File("BLVendasMEI.jar");
            FileOutputStream out = new FileOutputStream(file3, false);
            URL url = new URL("");
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            in.close();
            out.close();
        }
        catch (FileNotFoundException file3) {
        }
        catch (MalformedURLException file3) {
        }
        catch (IOException file3) {
            // empty catch block
        }
    }

    public static File gravaArquivoDeURL(String stringUrl, String pathLocal) {
        try {
            URL url = new URL(stringUrl);
            String nomeArquivoLocal = "BLVendasMEI.jar";
            InputStream is = url.openStream();
            FileOutputStream fos = new FileOutputStream(pathLocal + nomeArquivoLocal);
            int umByte = 0;
            while ((umByte = is.read()) != -1) {
                fos.write(umByte);
            }
            is.close();
            fos.close();
            return new File(pathLocal + nomeArquivoLocal);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean downloadArquivo(String stringUrl, String pathLocal) {
        return false;
        
    }

    public boolean gravaArquivoDeURLBoolean(String stringUrl, String pathLocal, String pUsuario, String pSenha) {
        try {
            URLConnection conn;
            URL url = new URL(stringUrl);
            String nomeArquivoLocal = "BLVendasMEI.exe";
            try {
                conn = url.openConnection();
                if (pUsuario != null) {
                    BASE64Encoder enc = new BASE64Encoder();
                    String dadosUsuario = pUsuario + ":" + pSenha;
                    conn.setRequestProperty("Authorization", "Basic " + enc.encode(dadosUsuario.getBytes()));
                }
            }
            catch (Exception e) {
                return false;
            }            
            FileOutputStream fos = new FileOutputStream(pathLocal + nomeArquivoLocal);
    //        int umByte = 0;
    //        InputStream is = conn.getInputStream();
            
     //       while ((umByte = is.read()) != -1) {
    //            fos.write(umByte);
    //        }
    //        is.close();
            fos.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String retornarNumeroAtualizacao() {
        DAOAtualizacao daoAtualizacao = new DAOAtualizacao();
        return daoAtualizacao.retornarNumeroAtualizacao();
    }

    public String retornarDadosAtualizacao() {
        DAOAtualizacao daoAtualizacao = new DAOAtualizacao();
        return daoAtualizacao.retornarDadosAtualizacao();
    }

    public String retornarVersaoSoftware() {
        DAOAtualizacao daoAtualizacao = new DAOAtualizacao();
        return daoAtualizacao.retornarVersaoSoftware();
    }

    public boolean isAtualizadoDesatualizado() {
        return this.atualizadoDesatualizado;
    }

    public void setAtualizadoDesatualizado(boolean atualizadoDesatualizado) {
        this.atualizadoDesatualizado = atualizadoDesatualizado;
    }
}

