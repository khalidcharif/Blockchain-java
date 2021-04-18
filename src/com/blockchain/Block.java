package com.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	
	private int index;
	private Long timestamp;
	private String data;
	private String previousHash;
	private String Hash;
	
	public Block(int index, String data, String previousHash) {
		super();
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = System.currentTimeMillis();
		this.Hash = calculateTheHash();
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getHash() {
		return Hash;
	}
	public void setHash(String hash) {
		Hash = hash;
	}
	
	public String calculateTheHash() {
		String text = String.valueOf(index 
					+ String.valueOf(timestamp) 
					+ String.valueOf(data) 
					+ previousHash
					);
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final byte bytes[] = digest.digest(text.getBytes());
		final StringBuilder hexString = new StringBuilder();
		for(final byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString(); 
	}

	@Override
	public String toString() {
		return "The "+ index + "th Block [index=" + index + ", timestamp=" + timestamp + ", data=" + data + ", previousHash="
				+ previousHash + ", Hash=" + Hash + "]";
	}
	
	

}
