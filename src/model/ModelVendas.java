/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

public class ModelVendas {
    private int codigo;
    private int produtosCodigo;
    private int clientesCodigo;
    private Date dataVenda;
    private Date dataVenda1;
    private Date dataSaida;
    private Date dataGarantia;
    private String garantia;
    private float quantidade;
    private Double valor; 
    private float valorTotal;
    private float desconto;
    private int tipoPagamento;
    private ArrayList<ModelVendas> listamModelVendases;
    private int tipo;
    private String observacao;
   

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setProdutosCodigo(int pProdutosCodigo) {
        this.produtosCodigo = pProdutosCodigo;
    }

    public int getProdutosCodigo() {
        return this.produtosCodigo;
    }

    public void setClientesCodigo(int pClientesCodigo) {
        this.clientesCodigo = pClientesCodigo;
    }

    public int getClientesCodigo() {
        return this.clientesCodigo;
    }

    public void setDataVenda(Date pDataVenda) {
        this.dataVenda = pDataVenda;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }
    
    public void setDataVenda1(Date pDataVenda1) {
        this.dataVenda1 = pDataVenda1;
    }
    
    public Date getDataVenda1() {
        return this.dataVenda1;
    }

    public void setQuantidade(float pQuantidade) {
        this.quantidade = pQuantidade;
    }     

    public float getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "ModelVendas {::codigo = " + this.codigo + "::produtosCodigo = " + this.produtosCodigo + "::clientesCodigo = " + this.clientesCodigo + "::dataVenda = " + this.dataVenda + "::dataVenda1 = " + this.dataVenda1 + "::quantidade = " + this.quantidade + "}"; 
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ArrayList<ModelVendas> getListamModelVendases() {
        return this.listamModelVendases;
    }

    public void setListamModelVendases(ArrayList<ModelVendas> listamModelVendases) {
        this.listamModelVendases = listamModelVendases;
    }

    public Float getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Float getDesconto() {
        return this.desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public int getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
        
    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getGarantia(){
        return this.garantia;
    }
    
     public void setGarantia(String garantia){
        this.garantia = garantia;
    }
     
     public Date getDataGarantia(){
         return this.dataGarantia;
     }
     
     public void setDataGarantia(Date dataGarantia){
         this.dataGarantia = dataGarantia;
     }
     
     public Date getDataSaida(){
         return this.dataSaida;
     }
     
     public void setDataSaida(Date dataSaida){
         this.dataSaida = dataSaida;
     }
}

