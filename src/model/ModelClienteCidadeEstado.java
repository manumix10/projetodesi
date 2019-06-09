/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelCidade;
import model.ModelCliente;
import model.ModelEstado;

public class ModelClienteCidadeEstado {
    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelCliente modelCliente;

    public void setModelCidade(ModelCidade pModelCidade) {
        this.modelCidade = pModelCidade;
    }

    public ModelCidade getModelCidade() {
        return this.modelCidade;
    }

    public void setModelEstado(ModelEstado pModelEstado) {
        this.modelEstado = pModelEstado;
    }

    public ModelEstado getModelEstado() {
        return this.modelEstado;
    }

    public String toString() {
        return "ModelCidadeEstado {::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "}";
    }

    public ModelCliente getModelCliente() {
        return this.modelCliente;
    }

    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }
}

