
package com.unionpay.qrcode.emvutil.consumer;

public class Main {
	
	public static void main(String[] args) {
		QRCode code = new QRCode();
		code.set("61", "4F","A0000000555555");
		code.set("61", "57","1234567890123458D191220112345F");
		String result = code.doCompose();
		System.out.println(Base64Util.converte(result));
		QRCode code1 = new QRCode();
		code1.set("61", "4F","0101010101010105");
		code.set("61", "51", "0102030405060708090A0B");
		result = code1.doCompose();
		System.out.println(Base64Util.converte(result));
	}
}
  


