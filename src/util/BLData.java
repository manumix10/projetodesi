/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BLData {
    public String addBarras(String pString) {
        String dataRetorno = new String();
        if (pString != null) {
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

    public String trocarTracos(String pString) {
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

    public Date subtraidMes(Date dataAtual, int quantidadeMes) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(2, - quantidadeMes);
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

    public String retornarDataHora() {
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return teste.format(date);
    }

    public java.sql.Date converterDataStringParaDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        java.sql.Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = new java.sql.Date(formatter.parse(data).getTime());
        return date;
    }

    public java.sql.Date converterDataStringParaDateUS(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        java.sql.Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        date = new java.sql.Date(formatter.parse(data).getTime());
        return date;
    }

    public java.sql.Date converterDataParaDateUS(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals("")) {
            return null;
        }
        java.sql.Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        date = new java.sql.Date(formatter.parse(dataString).getTime());
        return date;
    }

    public java.sql.Date converterDataParaDateBR(Date pData) throws Exception {
        SimpleDateFormat formatarDateUS = new SimpleDateFormat("yyyy-MM-dd");
        String dataString = formatarDateUS.format(pData);
        if (pData == null || pData.equals("")) {
            return null;
        }
        java.sql.Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = new java.sql.Date(formatarDateUS.parse(dataString).getTime());
        return date;
    }

    public String converterDataParaDateBRASIL(Date pData) {
        SimpleDateFormat formatarDateUS = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDateUS.format(pData);
    }

    public Date formataDataBR(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.parse(data);
        return date;
    }

    public String formatarData(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(pData);
    }

    public String formatarDataFirebird(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(pData);
    }
}

