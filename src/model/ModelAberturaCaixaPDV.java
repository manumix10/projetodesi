/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.Date;

public class ModelAberturaCaixaPDV {
    private int codigo;
    private int codigoUsuario;
    private Double valorAbertura;
    private Double valorFechamento;
    private Date data;
    private int status;
    private String nomeUsuario;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigoUsuario(int pCodigoUsuario) {
        this.codigoUsuario = pCodigoUsuario;
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setValorAbertura(Double pValorAbertura) {
        this.valorAbertura = pValorAbertura;
    }

    public Double getValorAbertura() {
        return this.valorAbertura;
    }

    public void setValorFechamento(Double pValorFechamento) {
        this.valorFechamento = pValorFechamento;
    }

    public Double getValorFechamento() {
        return this.valorFechamento;
    }

    public void setData(Date pData) {
        this.data = pData;
    }

    public Date getData() {
        return this.data;
    }

    public void setStatus(int pStatus) {
        this.status = pStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "ModelAberturaCaixaPDV {::codigo = " + this.codigo + "::codigoUsuario = " + this.codigoUsuario + "::valorAbertura = " + this.valorAbertura + "::valorFechamento = " + this.valorFechamento + "::data = " + this.data + "::status = " + this.status + "}";
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}

