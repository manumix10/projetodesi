/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOClienteContaParcelaRec;
import java.util.ArrayList;
import model.ModelClienteContaParcelaRec;
import model.ModelParcelaContaRec;

public class ControllerClienteContaParcelaRec {
    private DAOClienteContaParcelaRec daoClienteContaParcela = new DAOClienteContaParcelaRec();

    public int salvarClienteContaParcelaController(ModelClienteContaParcelaRec pModelClienteContaParcela) {
        return this.daoClienteContaParcela.salvarClienteContaParcelaDAO(pModelClienteContaParcela);
    }

    public ArrayList<ModelClienteContaParcelaRec> getListaClienteContaParcelaController(int pStatus) {
        return this.daoClienteContaParcela.getListaClienteContaParcelaDAO(pStatus);
    }

    public ArrayList<ModelClienteContaParcelaRec> getListaClienteContaParcelaController(ModelParcelaContaRec pModelParcelaContaRec) {
        return this.daoClienteContaParcela.getListaClienteContaParcelaDAO(pModelParcelaContaRec);
    }
}

