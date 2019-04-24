
package com.unionpay.qrcode.emvutil.merchant;

import android.util.Log;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;


public class QRCode {
    private SortedSetMultimap<TKey, TLVmodel> map;

    public QRCode() {
        map = TreeMultimap.create();
    }

    public void set(String id, String data) {
        TKey header = new TKey();
        header.setId(id);
        header.setRoot(true);
        TLVmodel qrdata = new TLVmodel(id, data);
        map.put(header, qrdata);
    }

    public void set(String id, String tag, String data) {
        TKey header = new TKey();
        header.setId(id);
        header.setRoot(false);
        TLVmodel qrdata = new TLVmodel(tag, data);
        map.put(header, qrdata);
    }

    public String doCompose(String polyStr) {
        StringBuffer sb = new StringBuffer();

        for (TKey key : map.keySet()) {
            StringBuffer st = new StringBuffer();
            Collection<TLVmodel> values = map.get(key);
            Iterator<TLVmodel> it = values.iterator();

            sb.append(key.getId());
            if (key.isRoot()) {
                while (it.hasNext()) {
                    TLVmodel qrdata = it.next();
                    sb.append(qrdata.getLength());
                    sb.append(qrdata.getValue());
                }
            } else {
                while (it.hasNext()) {
                    TLVmodel qrdata = it.next();
                    st.append(qrdata.getId());
                    st.append(qrdata.getLength());
                    st.append(qrdata.getValue());
                }
                sb.append(StringUtils.leftPad(String.valueOf(st.length()), 2, '0'));
                sb.append(st.toString());
            }
        }
        Log.e("6304",sb.toString());
        try {
            sb.append(polyStr);
            sb.append("6304");
            sb.append(CRCUtil.computeCRC(sb.toString()));
        } catch (NullPointerException ex) {
            Log.e("NNNNNNNNNNNNNNNNNNNNNN","空指针");
        }
        return sb.toString();
    }
}
  


