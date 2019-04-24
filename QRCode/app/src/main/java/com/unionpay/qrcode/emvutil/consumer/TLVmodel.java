
package com.unionpay.qrcode.emvutil.consumer;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class TLVmodel implements Serializable, Comparable<TLVmodel>{

	/**
	 * TLV
	 */
	private static final long serialVersionUID = -7043158572206171728L;
	private String id;
	private int length;
	private String value;

	public TLVmodel() {
	}

	public TLVmodel(String id, String value) {
		this.setId(id);
		this.setValue(value);
	}

	public String getLength() {
		return StringUtils.leftPad(HexUtil.intToHex(length/2), 2, '0');
	}

	private void setLength(int length) {
		this.length = length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		setLength(value.length());
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int compareTo(TLVmodel o) {
		return id.compareTo(o.getId());
	}
}
