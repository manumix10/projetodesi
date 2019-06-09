/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.Date;

public class ModelParcelaContaPag {
    private int codigo;
    private int numeroParcela;
    private Date dataVenciamento;
    private int status;
    private float valorParcial;
    private float jurosPorAtraso;
    private float valorPagar;
    private int codConta;
    private int codTipoPagamento;
    private Date dataPagamento;
    private String numeroDocumento;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNumeroParcela(int pNumeroParcela) {
        this.numeroParcela = pNumeroParcela;
    }

    public int getNumeroParcela() {
        return this.numeroParcela;
    }

    public void setDataVenciamento(Date pDataVenciamento) {
        this.dataVenciamento = pDataVenciamento;
    }

    public Date getDataVenciamento() {
        return this.dataVenciamento;
    }

    public void setStatus(int pStatus) {
        this.status = pStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public void setValorParcial(float pValorParcial) {
        this.valorParcial = pValorParcial;
    }

    public float getValorParcial() {
        return this.valorParcial;
    }

    public void setJurosPorAtraso(float pJurosPorAtraso) {
        this.jurosPorAtraso = pJurosPorAtraso;
    }

    public float getJurosPorAtraso() {
        return this.jurosPorAtraso;
    }

    public void setValorPagar(float pValorPagar) {
        this.valorPagar = pValorPagar;
    }

    public float getValorPagar() {
        return this.valorPagar;
    }

    public void setCodConta(int pCodConta) {
        this.codConta = pCodConta;
    }

    public int getCodConta() {
        return this.codConta;
    }

    public void setCodTipoPagamento(int pCodTipoPagamento) {
        this.codTipoPagamento = pCodTipoPagamento;
    }

    public int getCodTipoPagamento() {
        return this.codTipoPagamento;
    }

    public void setDataPagamento(Date pDataPagamento) {
        this.dataPagamento = pDataPagamento;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setNumeroDocumento(String pNumeroDocumento) {
        this.numeroDocumento = pNumeroDocumento;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public String toString() {
        return "ModelParcelaConta {::codigo = " + this.codigo + "::numeroParcela = " + this.numeroParcela + "::dataVenciamento = " + this.dataVenciamento + "::status = " + this.status + "::valorParcial = " + this.valorParcial + "::jurosPorAtraso = " + this.jurosPorAtraso + "::valorPagar = " + this.valorPagar + "::codConta = " + this.codConta + "::codTipoPagamento = " + this.codTipoPagamento + "::dataPagamento = " + this.dataPagamento + "::numeroDocumento = " + this.numeroDocumento + "}";
    }
}

