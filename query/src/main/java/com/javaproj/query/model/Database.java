package com.javaproj.query.model;

public class Database {
	private String ip;
	private String username;
	private String password;
	private String dbname;
	private String portno;
	
	public String getIp(){
		return ip;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getDbname(){
		return dbname;
	}
	public String getPortno(){
		return portno;
	}
	public void setIp(String ip){
		this.ip=ip;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setDbname(String dbname){
		this.dbname=dbname;
	}
	public void setPortno(String portno){
		this.portno=portno;
	}

}
