/*
 * Decompiled with CFR 0_122.
 */
package blserial;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class BLCriptografiaReversivel {
    private static final String SENHA = "%5tslDw2#*5gHasUQp";
    private static final String ALGORITMO = "PBEWithMD5AndDES";
    private static SecretKey skey;
    private static KeySpec ks;
    private static PBEParameterSpec ps;
    private static BASE64Encoder enc;
    private static BASE64Decoder dec;

    public static final String criptografar(String text) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(1, (Key)skey, ps);
        return enc.encode(cipher.doFinal(text.getBytes()));
    }

    public static final String descriptografar(String text) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(2, (Key)skey, ps);
        String ret = null;
        try {
            ret = new String(cipher.doFinal(dec.decodeBuffer(text)));
        }
        catch (Exception exception) {
            // empty catch block
        }
        return ret;
    }

    static {
        enc = new BASE64Encoder();
        dec = new BASE64Decoder();
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            ps = new PBEParameterSpec(new byte[]{3, 1, 4, 1, 5, 9, 2, 6}, 20);
            ks = new PBEKeySpec("%5tslDw2#*5gHasUQp".toCharArray());
            skey = skf.generateSecret(ks);
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
    }
}

