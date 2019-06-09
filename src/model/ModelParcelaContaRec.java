/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.Date;

public class ModelParcelaContaRec {
    private int codigo;
    private int numeroParcela;
    private Date dataVencimento;
    private int status;
    private float valorParcial;
    private float jurosPorAtraso;
    private float valorReceber;
    private int codConta;
    private int codTipoPagamento;
    private Date dataRecebimento;
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

    public void setDataVencimento(Date pDataVencimento) {
        this.dataVencimento = pDataVencimento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
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

    public void setValorReceber(float pValorReceber) {
        this.valorReceber = pValorReceber;
    }

    public float getValorReceber() {
        return this.valorReceber;
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

    public void setDataRecebimento(Date pDataRecebimento) {
        this.dataRecebimento = pDataRecebimento;
    }

    public Date getDataRecebimento() {
        return this.dataRecebimento;
    }

    public void setNumeroDocumento(String pNumeroDocumento) {
        this.numeroDocumento = pNumeroDocumento;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public String toString() {
        return "ModelParcelaContaRec {::codigo = " + this.codigo + "::numeroParcela = " + this.numeroParcela + "::dataVencimento = " + this.dataVencimento + "::status = " + this.status + "::valorParcial = " + this.valorParcial + "::jurosPorAtraso = " + this.jurosPorAtraso + "::valorReceber = " + this.valorReceber + "::codConta = " + this.codConta + "::codTipoPagamento = " + this.codTipoPagamento + "::dataRecebimento = " + this.dataRecebimento + "::numeroDocumento = " + this.numeroDocumento + "}";
    }
}

