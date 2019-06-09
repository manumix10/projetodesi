/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelTipoPagamento {
    private int codigo;
    private String descricao;
    private int banco;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setDescricao(String pDescricao) {
        this.descricao = pDescricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setBanco(int pBanco) {
        this.banco = pBanco;
    }

    public int getBanco() {
        return this.banco;
    }

    public String toString() {
        return "ModelTipoPagamento {::codigo = " + this.codigo + "::descricao = " + this.descricao + "::banco = " + this.banco + "}";
    }
}

