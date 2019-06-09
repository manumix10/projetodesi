/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;
import model.ModelCidade;
import model.ModelEstado;

public class ModelCidadeEstado {
    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ArrayList<ModelCidadeEstado> listaModelCidadeEstados;

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

    public ArrayList<ModelCidadeEstado> getListaModelCidadeEstados() {
        return this.listaModelCidadeEstados;
    }

    public void setListaModelCidadeEstados(ArrayList<ModelCidadeEstado> listaModelCidadeEstados) {
        this.listaModelCidadeEstados = listaModelCidadeEstados;
    }
}

