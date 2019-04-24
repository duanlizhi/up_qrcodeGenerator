
package com.unionpay.qrcode.emvutil.merchant;


public class CRCUtil {
	
	private static int initValue = 0xFFFF;
	private static int polynomial = 0x1021;

	public static String computeCRC(String data) {
		byte[] bytes = data.getBytes();
        initValue = 0xFFFF;
		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i) & 1) == 1);
				boolean c15 = ((initValue >> 15 & 1) == 1);
				initValue <<= 1;
				if (c15 ^ bit) {
					initValue ^= polynomial;
				}
			}
		}
		initValue &= 0xffff;
		return Integer.toHexString(initValue).toUpperCase();
	}
}
  


