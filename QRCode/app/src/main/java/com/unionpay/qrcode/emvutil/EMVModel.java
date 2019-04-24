package com.unionpay.qrcode.emvutil;

/**
 * @author homels
 * @date 2019/3/20
 */
public class EMVModel {
    /**
     * 支付系统
     */
    private String systemPayStr;
    /**
     * 商户码
     */
    private String merchantCode;
    /**
     * 商户类别
     */
    private String merchantType;
    /**
     * 静态还是动态
     */
    private String isActiveOrNot;
    /**
     * 交易货币
     */
    private String transactionCurrency;
    /**
     * 小费类型
     */
    private String convenienceType;
    private String convenienceNum1;
    private String ConvenienceNum2;
    /**
     * 国家编码
     */
    private String countryCode;
    /**
     * 商户名称
     */
    private String merchantName;
    private String merchantCity;
    private String zipCode;

    private String billNumber;
    /**
     * 手机号
     */
    private String phoneNumer;
    private String merchantTag;
    /**
     * 会员号
     */
    private String loytNumber;
    private String referenceTag;
    private String customerTag;

    private String tremialTag;
    private String purposeTag;
    private String addressTag;
    private String customerPhoneNumber;
    private String emailNumber;

    private String lpMerchantName;
    private String lpMerchantCity;
    private String transactionAmount;
    private String languagePreference;

    @Override
    public String toString() {
        return "EMVModel{" +
                "systemPayStr='" + systemPayStr + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", merchantType='" + merchantType + '\'' +
                ", isActiveOrNot='" + isActiveOrNot + '\'' +
                ", transactionCurrency='" + transactionCurrency + '\'' +
                ", convenienceType='" + convenienceType + '\'' +
                ", convenienceNum1='" + convenienceNum1 + '\'' +
                ", ConvenienceNum2='" + ConvenienceNum2 + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantCity='" + merchantCity + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", billNumber='" + billNumber + '\'' +
                ", phoneNumer='" + phoneNumer + '\'' +
                ", merchantTag='" + merchantTag + '\'' +
                ", loytNumber='" + loytNumber + '\'' +
                ", referenceTag='" + referenceTag + '\'' +
                ", customerTag='" + customerTag + '\'' +
                ", tremialTag='" + tremialTag + '\'' +
                ", purposeTag='" + purposeTag + '\'' +
                ", addressTag='" + addressTag + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", emailNumber='" + emailNumber + '\'' +
                ", lpMerchantName='" + lpMerchantName + '\'' +
                ", lpMerchantCity='" + lpMerchantCity + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", languagePreference='" + languagePreference + '\'' +
                '}';
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public void setSystemPayStr(String systemPayStr) {
        this.systemPayStr = systemPayStr;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public void setIsActiveOrNot(String isActiveOrNot) {
        this.isActiveOrNot = isActiveOrNot;
    }

    public void setConvenienceType(String convenienceType) {
        this.convenienceType = convenienceType;
    }

    public void setConvenienceNum1(String convenienceNum1) {
        this.convenienceNum1 = convenienceNum1;
    }

    public void setConvenienceNum2(String convenienceNum2) {
        this.ConvenienceNum2 = convenienceNum2;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public void setMerchantTag(String merchantTag) {
        this.merchantTag = merchantTag;
    }

    public void setLoytNumber(String loytNumber) {
        this.loytNumber = loytNumber;
    }

    public void setReferenceTag(String referenceTag) {
        this.referenceTag = referenceTag;
    }

    public void setCustomerTag(String customerTag) {
        this.customerTag = customerTag;
    }

    public void setTremialTag(String tremialTag) {
        this.tremialTag = tremialTag;
    }

    public void setPurposeTag(String purposeTag) {
        this.purposeTag = purposeTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setEmailNumber(String emailNumber) {
        this.emailNumber = emailNumber;
    }

    public void setLpMerchantName(String lpMerchantName) {
        this.lpMerchantName = lpMerchantName;
    }

    public void setLpMerchantCity(String lpMerchantCity) {
        this.lpMerchantCity = lpMerchantCity;
    }

    public String getSystemPayStr() {
        return systemPayStr;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public String getIsActiveOrNot() {
        return isActiveOrNot;
    }

    public String getConvenienceType() {
        return convenienceType;
    }

    public String getConvenienceNum1() {
        return convenienceNum1;
    }

    public String getConvenienceNum2() {
        return ConvenienceNum2;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public String getMerchantTag() {
        return merchantTag;
    }

    public String getLoytNumber() {
        return loytNumber;
    }

    public String getReferenceTag() {
        return referenceTag;
    }

    public String getCustomerTag() {
        return customerTag;
    }

    public String getTremialTag() {
        return tremialTag;
    }

    public String getPurposeTag() {
        return purposeTag;
    }

    public String getAddressTag() {
        return addressTag;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getEmailNumber() {
        return emailNumber;
    }

    public String getLpMerchantName() {
        return lpMerchantName;
    }

    public String getLpMerchantCity() {
        return lpMerchantCity;
    }
}
