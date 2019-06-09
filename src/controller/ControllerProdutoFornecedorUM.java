/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOProdutoFornecedorUM;
import java.util.ArrayList;
import model.ModelProdutoFornecedorUM;

public class ControllerProdutoFornecedorUM {
    private DAOProdutoFornecedorUM dAOProdutoFornecedorUM = new DAOProdutoFornecedorUM();

    public ArrayList<ModelProdutoFornecedorUM> getlistaProdutoFornecedorUM() {
        return this.dAOProdutoFornecedorUM.getProdutoFornecedorUM();
    }
}

