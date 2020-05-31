package org.humingk.movie.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

/**
 * AES 加密解密工具类
 *
 * @author humingk
 */
@Component
public class AesUtil {
  /** AesUtil所用的加密方式 */
  @Value("${custom.aes.way}")
  private String aesWay;

  /** AesUtil所用的加密密钥 */
  @Value("${custom.aes.key}")
  private String AES_KEY;

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
      bytes[i] = (byte) Integer.parseInt(stringhex.substring(i * 2, i * 2 + 2), 16);
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
    System.out.println("--------------");
    System.out.println("密码1233");
    System.out.println(new BCryptPasswordEncoder().encode("1233"));
    System.out.println("--------------");
    ArrayList list =
        new ArrayList() {
          {
            add("1233");
            add("client");
            add("星际");
            add("0");
            add("8");
            add("10");
            add("humingk");
            add("id2");
            add("id3");
            add("id4");
            add("1111@email.com");
            add("2222@email.com");
            add("3333@email.com");
            add("4444@email.com");
          }
        };
    for (Object str : list) {
      String se = new AesUtil().encrypt((String) str);
      String sd = new AesUtil().decrypt(se);
      System.out.println("=======================================");
      System.out.println("origin:  " + str);
      System.out.println("encrypt: " + se);
      System.out.println("decrypt: " + sd);
    }
  }

  /**
   * AES加密
   *
   * @param data
   * @return
   * @throws Exception
   */
  public String encrypt(String data) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), aesWay);
    Cipher cipher = Cipher.getInstance(aesWay);
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
  public String decrypt(String data) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), aesWay);
    Cipher cipher = Cipher.getInstance(aesWay);
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
    return new String(cipher.doFinal(hex2byte(data)));
  }
}
/*

--------------
密码1233
$2a$10$So3l2tsWnv2g/f3vs.OlQubgBVc30eSv69aTDaPCXgGT0V.m.auQa
--------------
=======================================
origin:  1233
encrypt: C3C677983D0D8107BBC765B313434298
decrypt: 1233
=======================================
origin:  client
encrypt: C739ADEAE10BA412E7E9D6E73BE46074
decrypt: client
=======================================
origin:  星际
encrypt: 749FD964EBD6179937E2A06A5DBB3159
decrypt: 星际
=======================================
origin:  0
encrypt: 4388C5414A7C171319245B4615F76371
decrypt: 0
=======================================
origin:  8
encrypt: 612F0B49A900219779BBCEB0A4363A2C
decrypt: 8
=======================================
origin:  10
encrypt: 7E11B78899E3530F085C80C35704427E
decrypt: 10
=======================================
origin:  humingk
encrypt: 1B5F5DF2DF03E9CFFEE51F3BC0FD863E
decrypt: humingk
=======================================
origin:  id2
encrypt: A27766EBD9C14EF51AB657774CF32888
decrypt: id2
=======================================
origin:  id3
encrypt: B65C2DA51068CD58022990E8FF8F589B
decrypt: id3
=======================================
origin:  id4
encrypt: 2953C93592CA0509916C61CBEA2551C8
decrypt: id4
=======================================
origin:  1111@email.com
encrypt: 2A047491F383E46CED6D0F6F772186F0
decrypt: 1111@email.com
=======================================
origin:  2222@email.com
encrypt: 446DE8C57F5A145B00F8D993F04C4DB1
decrypt: 2222@email.com
=======================================
origin:  3333@email.com
encrypt: AB57815ED9E720C555B6BC6F171156F2
decrypt: 3333@email.com
=======================================
origin:  4444@email.com
encrypt: 4357CE698A101609D7A9D168E7DB8311
decrypt: 4444@email.com

 */
