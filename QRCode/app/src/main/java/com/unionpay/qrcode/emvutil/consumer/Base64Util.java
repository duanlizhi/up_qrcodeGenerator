
package com.unionpay.qrcode.emvutil.consumer;

import org.apache.commons.codec.binary.Base64;



public class Base64Util {
	
	/**
	 * String 拼成的字符串
	 * TODO  把字符串hexToByte并用base64编码
	 */
	public static String converte(String s) {
		return new String(Base64.encodeBase64(hexToByte(s)));
	}
	
    public static String byteToHex(byte[] bytes) {
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }
        return sb.toString().trim();
    }
    
    public static byte[] hexToByte(String hex) {
        int m = 0, n = 0;
        int byteLen = hex.length() / 2; 
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
            ret[i] = Byte.valueOf((byte)intVal);
        }
        return ret;
    }

    public static String stringToHexAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        String[] s = sbu.toString().split(",");
        StringBuffer result = new StringBuffer();
        for(int i = 0; i<s.length; i++) {
            int temp = Integer.parseInt(s[i]);
            result.append(Integer.toHexString(temp));
        }
        return result.toString().toUpperCase();
    }
}
  


