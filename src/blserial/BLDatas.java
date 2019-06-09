/*
 * Decompiled with CFR 0_122.
 */
package blserial;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class BLDatas {
    SimpleDateFormat dateFormat;

    public String formatarDataBrasil(String pString) {
        String dataRetorno = new String();
        if (pString != null && pString.length() > 9) {
            dataRetorno = dataRetorno + pString.charAt(8);
            dataRetorno = dataRetorno + pString.charAt(9);
            dataRetorno = dataRetorno + '/';
            dataRetorno = dataRetorno + pString.charAt(5);
            dataRetorno = dataRetorno + pString.charAt(6);
            dataRetorno = dataRetorno + '/';
            dataRetorno = dataRetorno + pString.charAt(0);
            dataRetorno = dataRetorno + pString.charAt(1);
            dataRetorno = dataRetorno + pString.charAt(2);
            dataRetorno = dataRetorno + pString.charAt(3);
        }
        return dataRetorno;
    }

    public String formatarDataBrasil(Date pData) {
        String data = new String();
        try {
            this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            data = this.dateFormat.format(pData);
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Data nula: " + pData, "Aviso!", 2);
        }
        return data;
    }

    public String formatarDataUSA(String pString) {
        String dataRetorno = new String();
        if (pString != null && pString.length() > 9) {
            dataRetorno = dataRetorno + pString.charAt(6);
            dataRetorno = dataRetorno + pString.charAt(7);
            dataRetorno = dataRetorno + pString.charAt(8);
            dataRetorno = dataRetorno + pString.charAt(9);
            dataRetorno = dataRetorno + '-';
            dataRetorno = dataRetorno + pString.charAt(3);
            dataRetorno = dataRetorno + pString.charAt(4);
            dataRetorno = dataRetorno + '-';
            dataRetorno = dataRetorno + pString.charAt(1);
            dataRetorno = dataRetorno + pString.charAt(2);
        }
        return dataRetorno;
    }

    public String trocarTracosPorBarras(String pString) {
        String retorno = new String();
        if (pString != null) {
            for (int i = 0; i < pString.length(); ++i) {
                retorno = pString.charAt(i) == '-' ? retorno + '/' : retorno + pString.charAt(i);
            }
        }
        return retorno;
    }

    public Date addDias(int pQteDias, Date pDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.add(5, pQteDias);
        return c.getTime();
    }

    public Date adddMes(Date dataAtual, int quantidadeMes) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(2, quantidadeMes);
        return c.getTime();
    }

    public int diasEntreDatas(Date pDataInicio, Date pDataFim) {
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(pDataInicio);
        fim.setTime(pDataFim);
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        return (int)((dt2 - dt1) / 86400000 + 1);
    }

    public int anosEntreDatas(Date pData1, Date pData2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int ano1 = Integer.parseInt(sdf.format(pData1));
        int ano2 = Integer.parseInt(sdf.format(pData2));
        return ano2 - ano1;
    }

    public Date retornarDataHora() {
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return new Date(teste.format(date));
    }

    public Date retornarData() {
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy");
        return new Date(teste.format(date));
    }

    public int getDiaDaSemana(Date pData) {
        Calendar c = Calendar.getInstance();
        c.setTime(pData);
        int day = c.get(7);
        return day;
    }
}

