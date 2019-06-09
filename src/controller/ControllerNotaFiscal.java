/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAONotaFiscal;
import java.util.ArrayList;
import model.ModelNotaFiscal;

/**
 *
 * @author MICRO-70
 */
public class ControllerNotaFiscal {
    private DAONotaFiscal daoNotaFiscal = new DAONotaFiscal();

    public int salvarNotaFiscalController(ModelNotaFiscal pModelNotaFiscal) {
        return this.daoNotaFiscal.salvarNotaFiscalDAO(pModelNotaFiscal);
    }
    
    public ArrayList<ModelNotaFiscal> getNotaFiscalController() {
        return this.daoNotaFiscal.getListaNotaFiscalDAO();
    }


    public ArrayList<ModelNotaFiscal> getListaNotaFiscal() {
        return this.daoNotaFiscal.getListaNotaFiscalDAO();
    }
    
    public boolean excluirNotaFiscalController(String numeronota){
       return this.daoNotaFiscal.excluirNotaFiscalDAO(numeronota);
         
    }

    
}
