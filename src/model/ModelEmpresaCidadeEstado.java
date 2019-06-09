/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelCidade;
import model.ModelEmpresa;
import model.ModelEstado;

public class ModelEmpresaCidadeEstado {
    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelEmpresa modelEmpresa;

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

    public void setModelEmpresa(ModelEmpresa pModelEmpresa) {
        this.modelEmpresa = pModelEmpresa;
    }

    public ModelEmpresa getModelEmpresa() {
        return this.modelEmpresa;
    }

    public String toString() {
        return "ModelEmpresaCidadeEstado {::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "::modelEmpresa = " + this.modelEmpresa + "}";
    }
}

