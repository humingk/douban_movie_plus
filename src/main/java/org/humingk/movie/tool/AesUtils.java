package org.humingk.movie.tool;

import com.alibaba.fastjson.JSON;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES 加密解密工具类
 *
 * @author humingk
 */
public class AesUtils {
    private static final String KEY_AES = "AES";
    private static final String KEY = "youaretheapofmye";

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return byte2hex(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(cipher.doFinal(hex2byte(data)));
    }

    private static byte[] hex2byte(String stringhex) {
        if (stringhex == null) {
            return null;
        }
        int length = stringhex.length();
        if (length % 2 == 1) {
            return null;
        }
        byte[] bytes = new byte[length / 2];
        for (int i = 0; i != length / 2; i++) {
            bytes[i] = (byte) Integer.parseInt(stringhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return bytes;
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (int n = 0; n < bytes.length; n++) {
            temp = (Integer.toHexString(bytes[n] & 0XFF));
            if (temp.length() == 1) {
                stringBuilder.append("0").append(temp);
            } else {
                stringBuilder.append(temp);
            }
        }
        return stringBuilder.toString().toUpperCase();
    }


    public static void main(String[] args) throws Exception {
        String s = "{\"keyword\":\"星际\",\"offset\":0,\"limit\":5}";
        String se = AesUtils.encrypt(s);
        String sd = AesUtils.decrypt(se);
        System.out.println(s);
        System.out.println(se);
        System.out.println(sd);
    }
}