/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelCaixaConta {
    private int codigo;
    private String nome;
    private int tipoCaixaConta;
    private String observacao;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTipoCaixaConta(int pTipoCaixaConta) {
        this.tipoCaixaConta = pTipoCaixaConta;
    }

    public int getTipoCaixaConta() {
        return this.tipoCaixaConta;
    }

    public void setObservacao(String pObservacao) {
        this.observacao = pObservacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String toString() {
        return "ModelCaixaConta {::codigo = " + this.codigo + "::nome = " + this.nome + "::tipoCaixaConta = " + this.tipoCaixaConta + "::observacao = " + this.observacao + "}";
    }
}

