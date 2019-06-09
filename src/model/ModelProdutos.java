/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;

public class ModelProdutos {
    private int codigo;
    private int fornecedoresCodigo;
    private String nome;
    private Double valor;
    private float estoque;
    private String codigoBarras;
    private ArrayList<ModelProdutos> listaModelProdutoses;
    private int unidadeMedida;
    private Double valorCusto;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setFornecedoresCodigo(int pFornecedores_codigo) {
        this.fornecedoresCodigo = pFornecedores_codigo;
    }

    public int getFornecedoresCodigo() {
        return this.fornecedoresCodigo;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setValor(Double pValor) {
        this.valor = pValor;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setEstoque(float pEstoque) {
        this.estoque = pEstoque;
    }

    public float getEstoque() {
        return this.estoque;
    }

    public String toString() {
        return "ModelProdutos {::codigo = " + this.codigo + "::fornecedores_codigo = " + this.fornecedoresCodigo + "::nome = " + this.nome + "::valor = " + this.valor + "::estoque = " + this.estoque + "}";
    }

    public ArrayList<ModelProdutos> getListaModelProdutoses() {
        return this.listaModelProdutoses;
    }

    public void setListaModelProdutoses(ArrayList<ModelProdutos> listaModelProdutoses) {
        this.listaModelProdutoses = listaModelProdutoses;
    }

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getUnidadeMedida() {
        return this.unidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getValorCusto() {
        return this.valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }
}

