
package com.unionpay.qrcode.netsutil;

/**  
* ����ʱ�䣺2019��4��11�� ����4:36:14  

* ��Ŀ���ƣ�EMVTest2  
* @author homrls  
* @version 1.0   
* @since JDK 1.8.0_21  
* �ļ����ƣ�NetsModel.java  
* ��˵����  
*/

public class NetsModel {
	/**
	 * �汾��
	 */
	String version;
	/**
	 * tag����
	 */
	String nr;
	String uen;
	/**
	 * ����ʱ��
	 */
	String expDate;
	/**
	 * �̻�ID
	 */
	String merchantID;
	/**
	 * �̻���
	 */
	String merchantName;
	/**
	 * �ն�ID
	 */
	String terminalID;
	/**
	 * ���׽��
	 */
	String transactionAmount;
	/**
	 * ����ʱ��
	 */
	String transactionTimes;
	/**
	 * ���ֵ��Сֵ
	 */
	String minMaxValue;
	/**
	 * ����ID
	 */
	String transactionID;
	/**
	 * ��ά��ṹ
	 */
	String qrForm;
	/**
	 * ��ʶ�Ƿ���޸�
	 */
	String qualifier;
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getUen() {
		return uen;
	}
	public void setUen(String uen) {
		this.uen = uen;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionTimes() {
		return transactionTimes;
	}
	public void setTransactionTimes(String transactionTimes) {
		this.transactionTimes = transactionTimes;
	}
	public String getMinMaxValue() {
		return minMaxValue;
	}
	public void setMinMaxValue(String minMaxValue) {
		this.minMaxValue = minMaxValue;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getQrForm() {
		return qrForm;
	}
	public void setQrForm(String qrForm) {
		this.qrForm = qrForm;
	}
	public String getQualifier() {
		return qualifier;
	}
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	
	@Override
	public String toString() {
		return "NetsModel [version=" + version + ", nr=" + nr + ", uen=" + uen + ", expDate=" + expDate
				+ ", merchantID=" + merchantID + ", merchantName=" + merchantName + ", terminalID=" + terminalID
				+ ", transactionAmount=" + transactionAmount + ", transactionTimes=" + transactionTimes
				+ ", minMaxValue=" + minMaxValue + ", transactionID=" + transactionID + ", qrForm=" + qrForm
				+ ", qualifier=" + qualifier + "]";
	}
}
  


