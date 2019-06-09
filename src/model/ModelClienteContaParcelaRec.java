/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelCliente;
import model.ModelContaReceber;
import model.ModelParcelaContaRec;

public class ModelClienteContaParcelaRec {
    private ModelContaReceber modelContaReceber;
    private ModelCliente modelCliente;
    private ModelParcelaContaRec modelParcelaContaRec;

    public void setModelContaReceber(ModelContaReceber pModelContaReceber) {
        this.modelContaReceber = pModelContaReceber;
    }

    public ModelContaReceber getModelContaReceber() {
        return this.modelContaReceber;
    }

    public void setModelCliente(ModelCliente pModelCliente) {
        this.modelCliente = pModelCliente;
    }

    public ModelCliente getModelCliente() {
        return this.modelCliente;
    }

    public void setModelParcelaContaRec(ModelParcelaContaRec pModelParcelaContaRec) {
        this.modelParcelaContaRec = pModelParcelaContaRec;
    }

    public ModelParcelaContaRec getModelParcelaContaRec() {
        return this.modelParcelaContaRec;
    }

    public String toString() {
        return "ModelClienteContaParcela {::modelContaReceber = " + this.modelContaReceber + "::modelCliente = " + this.modelCliente + "::modelParcelaContaRec = " + this.modelParcelaContaRec + "}";
    }
}

