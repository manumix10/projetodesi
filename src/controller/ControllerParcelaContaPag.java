/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOParcelaContaPag;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelFormPagDatas;
import model.ModelParcelaContaPag;
import util.Data;
import util.Mascaras;

public class ControllerParcelaContaPag {
    private DAOParcelaContaPag daoParcelaConta = new DAOParcelaContaPag();

    public ArrayList<ModelParcelaContaPag> criarlistaDeParcelasMes(double pValorTotalReceber, ArrayList<ModelFormPagDatas> pListaDeDiasParcela, int pNumTotalParcelas, Date pDataParcela, double pEntrada, int pNaoPago) {
        ArrayList<ModelParcelaContaPag> listaDeParcelas = new ArrayList<ModelParcelaContaPag>();
        ModelParcelaContaPag modelParcela = new ModelParcelaContaPag();
        Data blDatas = new Data();
        DecimalFormat formatar = new DecimalFormat("#0.00");
        double valorParcelar = (pValorTotalReceber - pEntrada) / (double)pNumTotalParcelas;
        int inicioCont = 0;
        int mes = 1;
        if (pEntrada > 0.0) {
            inicioCont = 2;
            ++pNumTotalParcelas;
            modelParcela.setNumeroParcela(1);
            modelParcela.setValorPagar(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(pEntrada))));
            modelParcela.setStatus(pNaoPago);
            modelParcela.setJurosPorAtraso(0.0f);
            modelParcela.setValorParcial(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(pEntrada))));
            modelParcela.setDataVenciamento(pDataParcela);
            listaDeParcelas.add(modelParcela);
        } else {
            inicioCont = 1;
        }
        for (int i = inicioCont; i <= pNumTotalParcelas; ++i) {
            modelParcela = new ModelParcelaContaPag();
            modelParcela.setNumeroParcela(i);
            modelParcela.setValorPagar(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(valorParcelar))));
            modelParcela.setStatus(pNaoPago);
            modelParcela.setJurosPorAtraso(0.0f);
            modelParcela.setValorParcial(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(valorParcelar))));
            try {
                modelParcela.setDataVenciamento(blDatas.converterDataParaDateUS(blDatas.adddMes(pDataParcela, mes)));
            }
            catch (Exception ex) {
                Logger.getLogger(ControllerParcelaContaPag.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaDeParcelas.add(modelParcela);
            ++mes;
        }
        return listaDeParcelas;
    }

    public ArrayList<ModelParcelaContaPag> criarlistaDeParcelasDia(double pValorTotalReceber, ArrayList<ModelFormPagDatas> pListaDeDiasParcela, int pNumTotalParcelas, Date pDataParcela, double pEntrada, int pNaoPago) {
        ArrayList<ModelParcelaContaPag> listaDeParcelas = new ArrayList<ModelParcelaContaPag>();
        ModelParcelaContaPag modelParcela = new ModelParcelaContaPag();
        Data blDatas = new Data();
        DecimalFormat formatar = new DecimalFormat("#0.00");
        double valorParcelar = (pValorTotalReceber - pEntrada) / (double)pNumTotalParcelas;
        int inicioCont = 0;
        int dias = 0;
        if (pEntrada > 0.0) {
            dias = 2;
            inicioCont = 2;
            ++pNumTotalParcelas;
            modelParcela.setNumeroParcela(1);
            modelParcela.setValorPagar(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(pEntrada))));
            modelParcela.setStatus(pNaoPago);
            modelParcela.setJurosPorAtraso(0.0f);
            modelParcela.setValorParcial(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(pEntrada))));
            modelParcela.setDataVenciamento(pDataParcela);
            listaDeParcelas.add(modelParcela);
        } else {
            inicioCont = 1;
            dias = 1;
        }
        for (int i = inicioCont; i <= pNumTotalParcelas; ++i) {
            modelParcela = new ModelParcelaContaPag();
            modelParcela.setNumeroParcela(i);
            modelParcela.setValorPagar(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(valorParcelar))));
            modelParcela.setStatus(pNaoPago);
            modelParcela.setJurosPorAtraso(0.0f);
            modelParcela.setValorParcial(Float.parseFloat(new Mascaras().converterVirgulaParaPonto(formatar.format(valorParcelar))));
            try {
                modelParcela.setDataVenciamento(blDatas.converterDataParaDateUS(blDatas.addDias(pListaDeDiasParcela.get(i - dias).getDiasFormaPagamento(), pDataParcela)));
            }
            catch (Exception ex) {
                Logger.getLogger(ControllerParcelaContaPag.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaDeParcelas.add(modelParcela);
        }
        return listaDeParcelas;
    }

    public int salvarParcelaContaController(ModelParcelaContaPag pModelParcelaConta) {
        return this.daoParcelaConta.salvarParcelaContaDAO(pModelParcelaConta);
    }

    public ModelParcelaContaPag getParcelaContaController(int pCodigo) {
        return this.daoParcelaConta.getParcelaContaDAO(pCodigo);
    }

    public ArrayList<ModelParcelaContaPag> getListaParcelaContaController() {
        return this.daoParcelaConta.getListaParcelaContaDAO();
    }

    public boolean atualizarParcelaContaController(ModelParcelaContaPag pModelParcelaConta) {
        return this.daoParcelaConta.atualizarParcelaContaDAO(pModelParcelaConta);
    }

    public boolean excluirParcelaContaController(int pCodigo) {
        return this.daoParcelaConta.excluirParcelaContaDAO(pCodigo);
    }

    public ArrayList<ModelParcelaContaPag> getListaParcelaContaController(ModelParcelaContaPag pModelParcelaConta) {
        return this.daoParcelaConta.getListaParcelaContaDAO(pModelParcelaConta);
    }

    public ArrayList<ModelParcelaContaPag> getListaParcelaCodigoContaController(int pCodidoConta) {
        return this.daoParcelaConta.getListaParcelaCodigoContaDAO(pCodidoConta);
    }

    public boolean pagarParcelaController(ModelParcelaContaPag pModelParcelaConta) {
        return this.daoParcelaConta.pagarParcelaDAO(pModelParcelaConta);
    }

    public boolean revogarPagamentoParcelaController(ModelParcelaContaPag pModelParcelaContaPag) {
        return this.daoParcelaConta.revogarPagamentoParcelaDAO(pModelParcelaContaPag);
    }

    public boolean alterarDadosDaParcelaPagarController(ModelParcelaContaPag pModelParcelaContaPag) {
        return this.daoParcelaConta.alterarDadosDaParcelaPagarDAO(pModelParcelaContaPag);
    }

    public ModelParcelaContaPag getParcelaCodigoContaController(int pCodigoConta) {
        return this.daoParcelaConta.getParcelaCodigoContaDAO(pCodigoConta);
    }
}

