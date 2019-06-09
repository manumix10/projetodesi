/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelContaPagar;
import model.ModelFornecedor;
import model.ModelParcelaContaPag;

public class ModelFornecedorContaParcela {
    private ModelContaPagar modelContaPagar;
    private ModelFornecedor modelFornecedor;
    private ModelParcelaContaPag modelParcelaConta;

    public void setModelContaPagar(ModelContaPagar pModelContaPagar) {
        this.modelContaPagar = pModelContaPagar;
    }

    public ModelContaPagar getModelContaPagar() {
        return this.modelContaPagar;
    }

    public void setModelFornecedor(ModelFornecedor pModelFornecedor) {
        this.modelFornecedor = pModelFornecedor;
    }

    public ModelFornecedor getModelFornecedor() {
        return this.modelFornecedor;
    }

    public void setModelParcelaConta(ModelParcelaContaPag pModelParcelaConta) {
        this.modelParcelaConta = pModelParcelaConta;
    }

    public ModelParcelaContaPag getModelParcelaConta() {
        return this.modelParcelaConta;
    }

    public String toString() {
        return "ModelFornecedorContaParcela {::modelContaPagar = " + this.modelContaPagar + "::modelFornecedor = " + this.modelFornecedor + "::modelParcelaConta = " + this.modelParcelaConta + "}";
    }
}

