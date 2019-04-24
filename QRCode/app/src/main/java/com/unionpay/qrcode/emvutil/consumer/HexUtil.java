
package com.unionpay.qrcode.emvutil.consumer;


public class HexUtil {
    public static String intToHex(int n) {
        StringBuilder sb = new StringBuilder(8);
        String result;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;            
        }
        result = sb.reverse().toString();
        return result;
    }
    
    public static int hexToInt(String s) {
    	return Integer.parseInt(s,16);
    }
}
  


