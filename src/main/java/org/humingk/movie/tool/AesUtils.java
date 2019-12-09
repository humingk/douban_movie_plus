package org.humingk.movie.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES工具类
 *
 * @author humingk
 */
public class AesUtils {

    private static final String KEY_ALGORITHM = "AES";
    /**
     * 默认加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    @Value("${aes.password}")
    private static final String PASSWORD = "";


    /**
     * AES 加密
     *
     * @param data
     * @param password
     * @return
     */
    public static String encrypt(String data, String password) {
        try {
            // 密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = data.getBytes(StandardCharsets.UTF_8);
            // 加密器加密模式初始化
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * AES 解密
     *
     * @param data
     * @param password
     * @return
     */
    public static String decrypt(String data, String password) {
        try {
            // 密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 加密器加密模式初始化
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            // 解密
            byte[] result = cipher.doFinal(Base64Utils.decodeFromString(data));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 由密码生成加密秘钥
     *
     * @param password
     * @return
     */
    private static SecretKeySpec getSecretKey(String password) {
        KeyGenerator keyGenerator = null;
        try {
            // 指定算法的密钥生成器
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            // AES密钥长度 128
            keyGenerator.init(128, new SecureRandom(password.getBytes()));
            // 生成密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 转换为AES秘钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "sahsfdfkjkydks";
        String se = AesUtils.encrypt(s, "123456");
        String sd = AesUtils.decrypt(se, "123456");
        System.out.println(s);
        System.out.println(se);
        System.out.println(sd);
    }
}