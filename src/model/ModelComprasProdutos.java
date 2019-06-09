/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

public class ModelComprasProdutos {
    private int codigo;
    private int codigoProduto;
    private int codigoFornecedor;
    private float quantidade;
    private Double valorCusto;
    private Date data;
    private ArrayList<ModelComprasProdutos> listaModelComprasProdutoses;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigoProduto(int pCodigoProduto) {
        this.codigoProduto = pCodigoProduto;
    }

    public int getCodigoProduto() {
        return this.codigoProduto;
    }

    public void setCodigoFornecedor(int pCodigoFornecedor) {
        this.codigoFornecedor = pCodigoFornecedor;
    }

    public int getCodigoFornecedor() {
        return this.codigoFornecedor;
    }

    public void setQuantidade(float pQuantidade) {
        this.quantidade = pQuantidade;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setValorCusto(Double pValorCusto) {
        this.valorCusto = pValorCusto;
    }

    public Double getValorCusto() {
        return this.valorCusto;
    }

    public String toString() {
        return "ModelComprasProdutos {::codigo = " + this.codigo + "::codigoProduto = " + this.codigoProduto + "::codigoFornecedor = " + this.codigoFornecedor + "::quantidade = " + this.quantidade + "::valorCusto = " + this.valorCusto + "}";
    }

    public ArrayList<ModelComprasProdutos> getListaModelComprasProdutoses() {
        return this.listaModelComprasProdutoses;
    }

    public void setListaModelComprasProdutoses(ArrayList<ModelComprasProdutos> listaModelComprasProdutoses) {
        this.listaModelComprasProdutoses = listaModelComprasProdutoses;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

