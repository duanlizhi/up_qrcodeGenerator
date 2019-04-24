
package com.unionpay.qrcode.emvutil.consumer;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;


/**
 * @author Lenovo
 */
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

	public String doCompose() {
		StringBuffer sb = new StringBuffer();
		sb.append("85054350563031");
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
				sb.append(StringUtils.leftPad(HexUtil.intToHex(st.length()/2), 2, '0'));
				sb.append(st.toString());
			}
		}
		return sb.toString();
	}
}
  


