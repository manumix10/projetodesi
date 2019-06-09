/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOClienteContaParcelaPag;
import java.util.ArrayList;
import model.ModelClienteContaParcelaPag;
import model.ModelClienteContaParcelaRec;
import model.ModelParcelaContaPag;

public class ControllerClienteContaParcelaPag {
    private DAOClienteContaParcelaPag dAOClienteContaParcelaPag = new DAOClienteContaParcelaPag();

    public int salvarClienteContaParcelaController(ModelClienteContaParcelaRec pModelClienteContaParcela) {
        return this.dAOClienteContaParcelaPag.salvarClienteContaParcelaDAO(pModelClienteContaParcela);
    }

    public ArrayList<ModelClienteContaParcelaPag> getListaClienteContaParcelaController(ModelParcelaContaPag pModelParcelaContaPag) {
        return this.dAOClienteContaParcelaPag.getListaClienteContaParcelaDAO(pModelParcelaContaPag);
    }
}

