package com.unionpay.qrcode.activity;

import android.util.Log;

import com.unionpay.qrcode.emvutil.merchant.QRCode;
import com.unionpay.qrcode.emvutil.EMVModel;

/**
 * @author homels
 * @date 2019/3/20
 * 处理页面上接收到的字符串
 */
public class HandleString {
    private QRCode code;
    EMVModel model;
    String polyStr;

    HandleString(EMVModel model, String polyStr) {
        this.model = model;
        code = new QRCode();
        this.polyStr = polyStr;
    }

    HandleString(EMVModel model) {
        this.model = model;
        code = new QRCode();
    }

    public String doHandle() {
        String s;
        code.set("00", "01");
        if ("静态码".equals(model.getIsActiveOrNot())) {
            s = "11";
        } else {
            s = "12";
        }
        code.set("01", s);
        s = model.getSystemPayStr().substring(0, 2);
        code.set(s, model.getMerchantCode());
        s = model.getMerchantType().substring(0, 4);
        code.set("52", s);
        //以上到类别
        s = model.getTransactionCurrency().substring(0, 3);
        code.set("53", s);
        s = model.getTransactionAmount();
        if (!("".equals(s))) {
            code.set("54", s);
        }
        s = model.getConvenienceType().substring(0, 2);
        if ("01".equals(s)) {
            code.set("55", "01");
        } else if ("02".equals(s)) {
            code.set("55", "02");
            code.set("56", model.getConvenienceNum1());
        } else if ("03".equals(s)) {
            code.set("55", "03");
            code.set("57", model.getConvenienceNum2());
        } else {
            //不做任何处理
        }
        s = model.getCountryCode().substring(0, 2);
        code.set("58", s);
        code.set("59", model.getMerchantName());
        code.set("60", model.getMerchantCity());
        if (!(model.getZipCode().equals(""))) {
            code.set("61", model.getZipCode());
        }
        if (!("".equals(model.getBillNumber()))) {
            code.set("62", "01", model.getBillNumber());
        }
        if (!("".equals(model.getPhoneNumer()))) {
            code.set("62", "02", model.getPhoneNumer());
        }
        if (!("".equals(model.getMerchantTag()))) {
            code.set("62", "03", model.getMerchantTag());
        }
        if (!("".equals(model.getLoytNumber()))) {
            code.set("62", "04", model.getLoytNumber());
        }
        if (!("".equals(model.getReferenceTag()))) {
            code.set("62", "05", model.getReferenceTag());
        }
        if (!("".equals(model.getCustomerTag()))) {
            code.set("62", "06", model.getCustomerTag());
        }
        if (!("".equals(model.getTremialTag()))) {
            code.set("62", "07", model.getTremialTag());
        }
        if (!("".equals(model.getPurposeTag()))) {
            code.set("62", "08", model.getPurposeTag());
        }
        String tt = "";
        if (!("".equals(model.getAddressTag()))) {
            tt += "A";
        }
        if (!("".equals(model.getCustomerPhoneNumber()))) {
            tt += "M";
        }
        if (!("".equals(model.getEmailNumber()))) {
            tt += "E";
        }
        if (!(tt.equals(""))) {
            code.set("62", "09", tt);
        }
        if (!("".equals(model.getLpMerchantName()))) {
            String ttt = model.getLanguagePreference().substring(0, 2);
            code.set("64", "00", ttt);
            code.set("64", "01", model.getLpMerchantName());
            if (!("".equals(model.getLpMerchantName()))) {
                code.set("64", "02", model.getLpMerchantCity());
            }
        }
        String result = code.doCompose(polyStr);
        return result;
    }

    public final String uselessString = "A08F2D8D";

    public String doHandle(int i, String uen, String expriyTime, String merchantId, String terminalId) {
        String s;
        code.set("00", "01");
        if ("静态码".equals(model.getIsActiveOrNot())) {
            s = "11";
        } else {
            s = "12";
        }
        code.set("01", s);
        code.set("33", "00", "SG.COM.NETS");
        code.set("33", "01", "1" + uen + expriyTime);
        code.set("33", "02", merchantId);
        code.set("33", "03", terminalId);
        code.set("33", "09", "0");
        code.set("33", "99", uselessString);
        s = model.getSystemPayStr().substring(0, 2);
        code.set(s, model.getMerchantCode());
        s = model.getMerchantType().substring(0, 4);
        code.set("52", s);
        //以上到类别
        s = model.getTransactionCurrency().substring(0, 3);
        code.set("53", s);
        s = model.getTransactionAmount();
        if (!("".equals(s))) {
            code.set("54", s);
        }
        s = model.getConvenienceType().substring(0, 2);
        if ("01".equals(s)) {
            code.set("55", "01");
        } else if ("02".equals(s)) {
            code.set("55", "02");
            code.set("56", model.getConvenienceNum1());
        } else if ("03".equals(s)) {
            code.set("55", "03");
            code.set("57", model.getConvenienceNum2());
        } else {
            //不做处理
        }
        s = model.getCountryCode().substring(0, 2);
        code.set("58", s);
        code.set("59", model.getMerchantName());
        code.set("60", model.getMerchantCity());
        if (!(model.getZipCode().equals(""))) {
            code.set("61", model.getZipCode());
        }
        if (!("".equals(model.getBillNumber()))) {
            code.set("62", "01", model.getBillNumber());
        }
        if (!("".equals(model.getPhoneNumer()))) {
            code.set("62", "02", model.getPhoneNumer());
        }
        if (!("".equals(model.getMerchantTag()))) {
            code.set("62", "03", model.getMerchantTag());
        }
        if (!("".equals(model.getLoytNumber()))) {
            code.set("62", "04", model.getLoytNumber());
        }
        if (!("".equals(model.getReferenceTag()))) {
            code.set("62", "05", model.getReferenceTag());
        }
        if (!("".equals(model.getCustomerTag()))) {
            code.set("62", "06", model.getCustomerTag());
        }
        if (!("".equals(model.getTremialTag()))) {
            code.set("62", "07", model.getTremialTag());
        }
        if (!("".equals(model.getPurposeTag()))) {
            code.set("62", "08", model.getPurposeTag());
        }
        String tt = "";
        if (!("".equals(model.getAddressTag()))) {
            tt += "A";
        }
        if (!("".equals(model.getCustomerPhoneNumber()))) {
            tt += "M";
        }
        if (!("".equals(model.getEmailNumber()))) {
            tt += "E";
        }
        if (!(tt.equals(""))) {
            code.set("62", "09", tt);
        }
        if (!("".equals(model.getLpMerchantName()))) {
            String ttt = model.getLanguagePreference().substring(0, 2);
            code.set("64", "00", ttt);
            code.set("64", "01", model.getLpMerchantName());
            if (!("".equals(model.getLpMerchantName()))) {
                code.set("64", "02", model.getLpMerchantCity());
            }
        }
        Log.e("code.tostring", code.toString());
        String result = code.doCompose("");
        Log.e("AAAAAAAAAAAAAA", result);
        return result;
    }

    public String doCompose() {
        return code.doCompose("");
    }
}
