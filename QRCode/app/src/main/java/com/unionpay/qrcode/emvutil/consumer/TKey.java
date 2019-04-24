
package com.unionpay.qrcode.emvutil.consumer;

import java.io.Serializable;


public class TKey implements Serializable, Comparable<TKey> {
	
	private static final long serialVersionUID = 8892806955692419095L;
	
	private String id;
	private boolean root;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}
	public int compareTo(TKey o) {
		return id.compareTo(o.getId());
	}
}
  


