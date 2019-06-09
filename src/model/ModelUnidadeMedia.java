/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelUnidadeMedia {
    private int codigo;
    private String abreviacao;
    private String descricao;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setAbreviacao(String pAbreviacao) {
        this.abreviacao = pAbreviacao;
    }

    public String getAbreviacao() {
        return this.abreviacao;
    }

    public void setDescricao(String pDescricao) {
        this.descricao = pDescricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String toString() {
        return "ModelUnidadeMedia {::codigo = " + this.codigo + "::abreviacao = " + this.abreviacao + "::descricao = " + this.descricao + "}";
    }
}

