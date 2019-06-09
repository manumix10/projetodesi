/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelVendasProdutos {
    private int codigo;
    private int codigoProduto;
    private int codigoVenda;
    private float quantidade;
    private double valorUnitario;
    private double valorOrc;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo_produto(int pCodigoProduto) {
        this.codigoProduto = pCodigoProduto;
    }

    public int getCodigo_produto() {
        return this.codigoProduto;
    }

    public void setCodigo_venda(int pCodigoVenda) {
        this.codigoVenda = pCodigoVenda;
    }

    public int getCodigo_venda() {
        return this.codigoVenda;
    }

    public void setQuantidade(float pQuantidade) {
        this.quantidade = pQuantidade;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public String toString() {
        return "ModelVendasProdutos {::codigo = " + this.codigo + "::codigo_produto = " + this.codigoProduto + "::codigo_venda = " + this.codigoVenda + "::quantidade = " + this.quantidade + "}";
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public float getValorOrc(){
        return (float) this.valorOrc;
    }
    public void setfValorOrc(float valorOrc){
        this.valorOrc = valorOrc;
    }
}

