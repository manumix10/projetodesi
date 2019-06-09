/*
 * Decompiled with CFR 0_122.
 */
package util;

import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerProdutos;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import model.ModelEmpresaCidadeEstado;
import model.ModelVendas;
import model.ModelVendasProdutos;
import util.BLMascaras;

public class ImprimePDV {
    public void geraCupomTXT(int pCodigo) throws IOException {
        ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ControllerVendas controllerVendas = new ControllerVendas();
        ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
        ArrayList listaModelVendasProdutoses = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
        BLMascaras bLMascaras = new BLMascaras();
        modelVendas = controllerVendas.getVendasController(pCodigo);
        listaModelVendasProdutoses = controllerVendasProdutos.getListaVendasProdutosController(pCodigo);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        String data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        String hora1 = formata.format(agora);
        String conteudoFor = "";
        for (int i = 0; i < listaModelVendasProdutoses.size(); ++i) {
            conteudoFor = conteudoFor + ((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getQuantidade() + " x " + bLMascaras.arredondamentoDoubleComPontoDuasCasasString(controllerProdutos.getProdutosController(((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getCodigo_produto()).getValor()) + " - " + controllerProdutos.getProdutosController(((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getCodigo_produto()).getNome() + "\n\r";
        }
        this.imprimir(modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "\n\r" + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r" + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r" + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r" + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r" + "--------------------------------\n\r" + "        CUPOM NAO FISCAL        \n\r" + "--------------------------------\n\r" + "QT   PRECO   DESCRICAO\n\r" + conteudoFor + "" + "--------------------------------\n\r" + "Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue()) + "\n\r" + "   Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto().floatValue()) + "\n\r" + "Valor total: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue() - modelVendas.getDesconto().floatValue()) + "\n\r" + "\n\r\n\r\n\r\n\r\f");
    }

    public void imprimir(String pTexto) {
        try {
            ByteArrayInputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor.INPUT_STREAM docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            HashPrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
            printerAttributes.add(new JobName("Impressao", null));
            printerAttributes.add(OrientationRequested.PORTRAIT);
            printerAttributes.add(MediaSizeName.ISO_A4);
            DocPrintJob printJob = impressora.createPrintJob();
            try {
                printJob.print(documentoTexto, printerAttributes);
            }
            catch (PrintException e) {
                JOptionPane.showMessageDialog(null, "N\u00e3o foi poss\u00edvel realizar a impress\u00e3o !!", "Erro", 0);
            }
            prin.close();
        }
        catch (Exception prin) {
      //       empty catch block
        }
    }
}

