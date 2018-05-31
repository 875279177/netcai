package com.netcai.admin.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * 可逆加密
 * 对称密钥加密又叫专用密钥加密，即发送和接收数据的双方必使用相同的密钥对明文进行加密和解密运算。
 * 对称密钥加密算法主要包括：DES、3DES、IDEA、FEAL、BLOWFISH等。 
 * @author administrator
 */
public class AES {
    
    /**
     * 辅助数组，主要把byte值转化为对应的char值
     */
    private static char[] CHARS = "0123456789abcdef".toCharArray();
     
    public static String encode(String content,String password)
    {
    	return parseByte2HexStr(encrypt(content,password));
    }
    
    public static String decode(String content,String password)
    {
    	String result=null;
    	try {
    		result=new String(AES.decrypt(parseHexByte2Str(content),password),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    /**
     * 加密
     * 
     * 因为没有操作对象，也没有操作相同的资源，所以不会出现多线程问题
     * 
     * @param content
     *            需要加密的内容
     * @param password
     *            加密密码
     * @return
     */
    private static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result;
            // return parseByte2HexStr(result); // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把二进制byte数组转化为十六进制字符串
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            byte b = buf[i];
            byte c1 = (byte) ((b & 0xF0) >> 4);
            byte c2 = (byte) (b & 0x0F);
            
            sBuffer.append(CHARS[c1]).append(CHARS[c2]);
        }
        return sBuffer.toString().toUpperCase();
    }
    
    private static byte[] parseHexByte2Str(String str) {
        str = str.toLowerCase();
        byte[] bytes = new byte[str.length() / 2];
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length / 2; ++i) {
            char c1 = cs[i * 2];
            char c2 = cs[i * 2 + 1];
            int a1, a2;
            if (c1 < 'a') a1 = c1 - '0';
            else a1 = (c1 - 'a') + 10;
            if (c2 < 'a') a2 = c2 - '0';
            else a2 = (c2 - 'a') + 10;
            bytes[i] = (byte)(((a1 & 0x0F) << 4) | (a2 & 0x0F));
        }
        return bytes;
    }

    /**
     * 解密
     * 
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     */
    private static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}