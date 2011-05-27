package org.mondayspainter.db;

public class SqlParameter {
	private String key;
	private String value;
	
	public SqlParameter(String key, Object value) {
		this.key = key;
		setValue(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value.toString();
	}
}
