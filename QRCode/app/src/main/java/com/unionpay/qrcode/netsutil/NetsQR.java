package com.unionpay.qrcode.netsutil;

import org.apache.commons.lang3.StringUtils;

public class NetsQR {
	final String SECRETSTRING = "THISISNETSSECRETSTRINGFORTESTING";
	public String decode(NetsModel model) {
		String result = "NETSqpay";
		int tagNum = 0;
		if(!"".equals(model.getMerchantID())) {
			tagNum ++;
		}
		if(!"".equals(model.getMerchantName())) {
			tagNum ++;
		}
		if(!"".equals(model.getTerminalID())) {
			tagNum ++;
		}
		if(!"".equals(model.getTransactionAmount())) {
			tagNum ++;
		}
		if(!"".equals(model.getTransactionTimes())) {
			tagNum ++;
		}
		if(!"".equals(model.getMinMaxValue())) {
			tagNum ++;
		}
		if(!"".equals(model.getTransactionID())) {
			tagNum ++;
		}
		if(!"".equals(model.getQualifier())) {
			tagNum ++;
		}
		result += model.getVersion();
		result += StringUtils.leftPad(String.valueOf(tagNum), 2, '0')+"";
		result += model.getUen();
		result += model.getExpDate();
		result += "0011" + model.getMerchantID();
		result += "01" + getLength(model.getMerchantName()) + model.getMerchantName();
		if(!"".equals(model.getTerminalID())) {
			result += "02" + getLength(model.getTerminalID()) + model.getTerminalID();
		}
		if(!"".equals(model.getTransactionAmount())) {
			result += "03" + getLength(model.getTransactionAmount()) + model.getTransactionAmount();
		}
		if(!"".equals(model.getTransactionTimes())) {
			result += "04" + getLength(model.getTransactionTimes()) + model.getTransactionTimes();
		}
		if(!"".equals(model.getMinMaxValue())) {
			result += "06" + getLength(model.getMinMaxValue()) + model.getMinMaxValue();
		}
		if(!"".equals(model.getTransactionID())) {
			result += "07" + getLength(model.getTransactionID()) + model.getTransactionID();
		}
		if(!"".equals(model.getQualifier())) {
			result += "09" + getLength(model.getQualifier()) + model.getQualifier();
		}
		result += SignatureGenerator.encodeBySHA256(result+SECRETSTRING);
		return result;
	}
	private String getLength(String target) {
		int length = target.length();
		return StringUtils.leftPad(String.valueOf(length), 2, '0');
	}
}
  


