/*
 * Decompiled with CFR 0_122.
 */
package controller;

import java.io.File;
import model.ModelAtualizacao;

public class ControllerAtualizacao {
    public void downloadAtualizacao() {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        modelAtualizacao.downloadAtualizacao();
    }

    public static File gravaArquivoDeURL(String stringUrl, String pathLocal) {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return ModelAtualizacao.gravaArquivoDeURL(stringUrl, pathLocal);
    }

    public boolean gravaArquivoDeURLBoolean(String stringUrl, String pathLocal, String pUsuario, String pSenha) {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return modelAtualizacao.gravaArquivoDeURLBoolean(stringUrl, pathLocal, pUsuario, pSenha);
    }

    public boolean downloadArquivo(String stringUrl, String pathLocal) {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return ModelAtualizacao.downloadArquivo(stringUrl, pathLocal);
    }

    public String retornarNumeroAtualizacao() {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return modelAtualizacao.retornarNumeroAtualizacao();
    }

    public String retornarDadosAtualizacao() {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return modelAtualizacao.retornarDadosAtualizacao();
    }

    public String retornarVersaoSoftware() {
        ModelAtualizacao modelAtualizacao = new ModelAtualizacao();
        return modelAtualizacao.retornarVersaoSoftware();
    }
}

