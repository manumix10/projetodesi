/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;

public class ModelFormPagDatas {
    private int codigo;
    private int codigoPagamento;
    private int diasFormaPagamento;
    private int parcelaNumero;
    private ArrayList<ModelFormPagDatas> listaDeDatas;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigoPagamento(int pCodigoPagamento) {
        this.codigoPagamento = pCodigoPagamento;
    }

    public int getCodigoPagamento() {
        return this.codigoPagamento;
    }

    public void setDiasFormaPagamento(int pDiasFormaPagamento) {
        this.diasFormaPagamento = pDiasFormaPagamento;
    }

    public int getDiasFormaPagamento() {
        return this.diasFormaPagamento;
    }

    public void setParcelaNumero(int pParcelaNumero) {
        this.parcelaNumero = pParcelaNumero;
    }

    public int getParcelaNumero() {
        return this.parcelaNumero;
    }

    public String toString() {
        return "ModelFormPagDatas {::codigo = " + this.codigo + "::codigoPagamento = " + this.codigoPagamento + "::diasFormaPagamento = " + this.diasFormaPagamento + "::parcelaNumero = " + this.parcelaNumero + "}";
    }

    public ArrayList<ModelFormPagDatas> getListaDeDatas() {
        return this.listaDeDatas;
    }

    public void setListaDeDatas(ArrayList<ModelFormPagDatas> listaDeDatas) {
        this.listaDeDatas = listaDeDatas;
    }
}

