
package com.unionpay.qrcode.netsutil;

/**  
* ����ʱ�䣺2019��4��11�� ����2:27:59  

* ��Ŀ���ƣ�EMVTest2  
* @author homrls  
* @version 1.0   
* @since JDK 1.8.0_21  
* �ļ����ƣ�Test.java  
* ��˵����  
*/

public class Test {
	public static void main(String[] args) {
		NetsModel model = new NetsModel();
		model.setUen("0123456789");
		model.setVersion("0");
		model.setExpDate("31122088");
		model.setMerchantID("11135036100");
		model.setMerchantName("TEST_MERCHANT_NETS");
		model.setTerminalID("35036103");
		model.setTransactionAmount("00001234");
		model.setTransactionTimes("11112018111111");
		model.setMinMaxValue("0000000030000000");
		model.setTransactionID("0000");
		model.setQrForm("0");
		model.setQualifier("0");
		
		NetsQR qrCode = new NetsQR();
		System.out.println(qrCode.decode(model));
	}
	
}
  


