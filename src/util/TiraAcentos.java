/*
 * Decompiled with CFR 0_122.
 */
package util;

public class TiraAcentos {
    public String TiraAcentos(String passa) {
        passa = passa.replaceAll("[\u00c2\u00c0\u00c1\u00c4\u00c3]", "A");
        passa = passa.replaceAll("[\u00e2\u00e3\u00e0\u00e1\u00e4]", "a");
        passa = passa.replaceAll("[\u00ca\u00c8\u00c9\u00cb]", "E");
        passa = passa.replaceAll("[\u00ea\u00e8\u00e9\u00eb]", "e");
        passa = passa.replaceAll("\u00ce\u00cd\u00cc\u00cf", "I");
        passa = passa.replaceAll("\u00ee\u00ed\u00ec\u00ef", "i");
        passa = passa.replaceAll("[\u00d4\u00d5\u00d2\u00d3\u00d6]", "O");
        passa = passa.replaceAll("[\u00f4\u00f5\u00f2\u00f3\u00f6]", "o");
        passa = passa.replaceAll("[\u00db\u00d9\u00da\u00dc]", "U");
        passa = passa.replaceAll("[\u00fb\u00fa\u00f9\u00fc]", "u");
        passa = passa.replaceAll("\u00c7", "C");
        passa = passa.replaceAll("\u00e7", "c");
        passa = passa.replaceAll("[\u00fd\u00ff]", "y");
        passa = passa.replaceAll("\u00dd", "Y");
        passa = passa.replaceAll("\u00f1", "n");
        passa = passa.replaceAll("\u00d1", "N");
        passa = passa.replaceAll("['<>\\|/]", "");
        return passa;
    }
}

