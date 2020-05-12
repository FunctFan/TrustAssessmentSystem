package com.artisan.model;
/**
 * 
 * @author lex
 * 	工业网络的信息
 *
 */
public class Network {
	private int id;
	private String name;
	private String info;//网络介绍
	
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
