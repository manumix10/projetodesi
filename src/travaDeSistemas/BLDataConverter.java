/*
 * Decompiled with CFR 0_122.
 */
package travaDeSistemas;

public class BLDataConverter {
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
}

