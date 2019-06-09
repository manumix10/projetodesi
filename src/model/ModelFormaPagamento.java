/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelFormaPagamento {
    private int codigo;
    private String descricao;
    private float desconto;
    private int quantidadeParcelas;
    private String observacao;
    private boolean situacao;

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

    public void setDesconto(float pDesconto) {
        this.desconto = pDesconto;
    }

    public float getDesconto() {
        return this.desconto;
    }

    public void setQuantidadeParcelas(int pQuantidadeParcelas) {
        this.quantidadeParcelas = pQuantidadeParcelas;
    }

    public int getQuantidadeParcelas() {
        return this.quantidadeParcelas;
    }

    public void setObservacao(String pObservacao) {
        this.observacao = pObservacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setSituacao(boolean pSituacao) {
        this.situacao = pSituacao;
    }

    public boolean isSituacao() {
        return this.situacao;
    }

    public String toString() {
        return "ModelFormaPagamento {::codigo = " + this.codigo + "::descricao = " + this.descricao + "::desconto = " + this.desconto + "::quantidadeParcelas = " + this.quantidadeParcelas + "::observacao = " + this.observacao + "::situacao = " + this.situacao + "}";
    }
}

