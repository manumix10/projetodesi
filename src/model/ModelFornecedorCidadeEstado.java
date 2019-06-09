/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelCidade;
import model.ModelEstado;
import model.ModelFornecedor;

public class ModelFornecedorCidadeEstado {
    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelFornecedor modelFornecedor;

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

    public ModelFornecedor getModelFornecedor() {
        return this.modelFornecedor;
    }

    public void setModelFornecedor(ModelFornecedor modelFornecedor) {
        this.modelFornecedor = modelFornecedor;
    }
}

