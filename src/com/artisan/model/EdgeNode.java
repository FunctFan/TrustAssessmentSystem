package com.artisan.model;

public class EdgeNode {
	private int id;
	private String name;
	private int networkId; //�����ĸ�����
	private double trustValue;
	private String trustType;  //���š���ȷ����������
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNetworkId() {
		return networkId;
	}
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}
	public double getTrustValue() {
		return trustValue;
	}
	public void setTrustValue(double trustValue) {
		this.trustValue = trustValue;
	}
	public String getTrustType() {
		return trustType;
	}
	public void setTrustType(String trustType) {
		this.trustType = trustType;
	}
	
}
