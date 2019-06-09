/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.text.DecimalFormat;

public class BLMascaras {
    public String converterVirgulaParaPonto(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; ++i) {
            retorno = pString.charAt(i) == ',' ? retorno + '.' : retorno + pString.charAt(i);
        }
        return retorno;
    }

    public String converterPontoPraVirgula(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; ++i) {
            retorno = pString.charAt(i) == '.' ? retorno + ',' : retorno + pString.charAt(i);
        }
        return retorno;
    }

    public float converterVirgulaParaPontoReturnFloat(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; ++i) {
            retorno = pString.charAt(i) == ',' ? retorno + '.' : retorno + pString.charAt(i);
        }
        return Float.parseFloat(retorno);
    }

    public String removerPontos(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; ++i) {
            retorno = pString.charAt(i) == '.' ? retorno + "" : retorno + pString.charAt(i);
        }
        return retorno;
    }

    public String addPonto(String pString) {
        int pontoConter = 0;
        for (int i = 0; i < pString.length(); ++i) {
            if (pString.charAt(i) != '.') continue;
            ++pontoConter;
        }
        if (pontoConter == 0) {
            pString = pString + ".0";
        }
        return pString;
    }

    public double truncar3Casas(double pValor) {
        return (double)Math.round(pValor * 100.0) / 100.0;
    }

    public int converteInteiro(int pString) {
        DecimalFormat df = new DecimalFormat("#.0");
        pString = Integer.parseInt(df.format(pString));
        return pString;
    }

    public double converteArredondar2Casas(double pDouble) {
        DecimalFormat df = new DecimalFormat("#,00");
        pDouble = Double.parseDouble(df.format(pDouble));
        return pDouble;
    }

    public float arredondamentoComPontoDuasCasas(float pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }

    public Double arredondamentoComPontoDuasCasasDouble(Double pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(this.converterVirgulaParaPonto(df.format(pValor)));
    }

    public String arredondamentoComPontoDuasCasasString(float pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }

    public float arredondamentoComPontoTresCasas(float pValor) {
        DecimalFormat df = new DecimalFormat("#.000");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }

    public String arredondamentoDoubleComPontoDuasCasasString(Double pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }
}

