/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;
import model.ModelFornecedor;
import model.ModelProdutos;
import model.ModelUnidadeMedia;

public class ModelProdutoFornecedorUM {
    private ModelProdutos modelProdutos;
    private ModelFornecedor modelFornecedor;
    private ModelUnidadeMedia unidadeMedia;
    private ArrayList<ModelProdutoFornecedorUM> listaModelProdutoFornecedorUMs;

    public ModelProdutos getModelProdutos() {
        return this.modelProdutos;
    }

    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    public ModelFornecedor getModelFornecedor() {
        return this.modelFornecedor;
    }

    public void setModelFornecedor(ModelFornecedor modelFornecedor) {
        this.modelFornecedor = modelFornecedor;
    }

    public ModelUnidadeMedia getUnidadeMedia() {
        return this.unidadeMedia;
    }

    public void setUnidadeMedia(ModelUnidadeMedia unidadeMedia) {
        this.unidadeMedia = unidadeMedia;
    }

    public ArrayList<ModelProdutoFornecedorUM> getListaModelProdutoFornecedorUMs() {
        return this.listaModelProdutoFornecedorUMs;
    }

    public void setListaModelProdutoFornecedorUMs(ArrayList<ModelProdutoFornecedorUM> listaModelProdutoFornecedorUMs) {
        this.listaModelProdutoFornecedorUMs = listaModelProdutoFornecedorUMs;
    }
}

