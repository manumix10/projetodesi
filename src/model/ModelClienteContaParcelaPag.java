/*
 * Decompiled with CFR 0_122.
 */
package model;

import model.ModelContaPagar;
import model.ModelFornecedor;
import model.ModelParcelaContaPag;

public class ModelClienteContaParcelaPag {
    private ModelContaPagar modelContaPagar;
    private ModelFornecedor modelFornecedor;
    private ModelParcelaContaPag modelParcelaContaPag;

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

    public void setModelParcelaContaPag(ModelParcelaContaPag pModelParcelaContaPag) {
        this.modelParcelaContaPag = pModelParcelaContaPag;
    }

    public ModelParcelaContaPag getModelParcelaContaPag() {
        return this.modelParcelaContaPag;
    }

    public String toString() {
        return "ModelClienteContaParcela {::modelContaReceber = " + this.modelContaPagar + "::modelCliente = " + this.modelFornecedor + "::modelParcelaContaRec = " + this.modelParcelaContaPag + "}";
    }
}

