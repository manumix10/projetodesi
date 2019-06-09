/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

public class ModelOrdemServico {
    private int codigo;
    private int vendasCodigo;
    private int clientesCodigo;
    private Date dataSaida;
    private Date dataGarantia;
    private String garantia;    
    private ArrayList<ModelOrdemServico> listamModelVendases;    
    private String observacao;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }
    public void setVendasCodigo(int pVendasCodigo) {
        this.vendasCodigo = pVendasCodigo;
    }
    public int getVendasCodigo() {
        return this.vendasCodigo;
    }

    public void setClientesCodigo(int pClientesCodigo) {
        this.clientesCodigo = pClientesCodigo;
    }

    public int getClientesCodigo() {
        return this.clientesCodigo;
    }
    
    public void setDataSaida(Date pDataSaida){
        this.dataSaida = pDataSaida;
    }
    
    public Date getDataSaida(){
        return this.dataSaida;
    }
    
    public void setDataGarantia(Date pDataGarantia){
        this.dataGarantia = pDataGarantia;
    }
    
    public Date getDataGarantia(){
        return this.dataGarantia;
    }    
   

    public String toString() {
        return "ModelVendas {::codigo = " + this.codigo + "::data_saida = " + this.dataSaida + "::data_garantia = " + this.dataGarantia + "}"; //"::garantia = " + this.garantia + 
    }


    public ArrayList<ModelOrdemServico> getListamModelVendases() {
        return null;
   //     return this.listamModelVendases;
    }

    public void setListamModelVendases(ArrayList<ModelOrdemServico> listamModelVendases) {
        this.listamModelVendases = listamModelVendases;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
     public void setGarantia(String garantia){
        this.garantia = garantia;
    }
    
    public String getGarantia(){
        return this.garantia;
    }

}

