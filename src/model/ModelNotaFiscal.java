/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author MICRO-70
 */
public class ModelNotaFiscal {
   // private int codigonota;
    private String numeronota;       
    private Date data;    
    private String quantidade;
    private String valornota;
    private int codigofornecedor;   

    
    public void setNumeroNota(String pNumeroNota) {
        this.numeronota = pNumeroNota;
    }

    public String getNumeroNota() {
        return this.numeronota;
    }

    public void setData(Date pData) {
        this.data = pData;
    }

    public Date getData() {
        return this.data;
    }

    public void setQuantidade(String pQuantidade) {
        this.quantidade = pQuantidade;
    }

    public String getQuantidade() {
        return this.quantidade;
    }
    
    public void setValorNota(String pValorNota) {
        this.valornota = pValorNota;
    }

    public String getValorNota() {
        return this.valornota;
    }
    public void setCodigoFornecedor(int pCodigoFornecedor) {
        this.codigofornecedor = pCodigoFornecedor;
    }

    public int getCodigoFornecedor() {
        return this.codigofornecedor;
    }
    @Override
    public String toString() {
        return "ModelNotaFiscal {::codigofornecedor = " + this.codigofornecedor + "::numeronota = " + this.numeronota + "::data = " + this.data + "::quantidade = " + this.quantidade + "::valornota = " + this.valornota + "}";
    }
}
