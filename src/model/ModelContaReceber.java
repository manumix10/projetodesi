/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.sql.Date;

public class ModelContaReceber {
    private int codigo;
    private int codigoPessoa;
    private String descricao;
    private Date data;
    private Date vencimento;
    private Date pagamento;
    private int tipoPagamento;
    private String observacao;
    private int situacao;
    private float valor;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigoPessoa(int pCodigoCliente) {
        this.codigoPessoa = pCodigoCliente;
    }

    public int getCodigoPessoa() {
        return this.codigoPessoa;
    }

    public void setDescricao(String pDescricao) {
        this.descricao = pDescricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setData(Date pData) {
        this.data = pData;
    }

    public Date getData() {
        return this.data;
    }

    public void setVencimento(Date pVencimento) {
        this.vencimento = pVencimento;
    }

    public Date getVencimento() {
        return this.vencimento;
    }

    public void setPagamento(Date pPagamento) {
        this.pagamento = pPagamento;
    }

    public Date getPagamento() {
        return this.pagamento;
    }

    public void setTipoPagamento(int pTipoPagamento) {
        this.tipoPagamento = pTipoPagamento;
    }

    public int getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setObservacao(String pObservacao) {
        this.observacao = pObservacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setSituacao(int pSituacao) {
        this.situacao = pSituacao;
    }

    public int isSituacao() {
        return this.situacao;
    }

    public void setValor(float pValor) {
        this.valor = pValor;
    }

    public float getValor() {
        return this.valor;
    }

    public String toString() {
        return "ModelContaPagar {::codigo = " + this.codigo + "::codigoCliente = " + this.codigoPessoa + "::descricao = " + this.descricao + "::data = " + this.data + "::vencimento = " + this.vencimento + "::pagamento = " + this.pagamento + "::tipoPagamento = " + this.tipoPagamento + "::observacao = " + this.observacao + "::situacao = " + this.situacao + "::valor = " + this.valor + "}";
    }
}

