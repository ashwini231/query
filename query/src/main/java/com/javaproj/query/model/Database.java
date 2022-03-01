package com.javaproj.query.model;

public class Database {
	private String ip;
	private String username;
	private String password;
	private String dbname;
	private int portno;
	
	public String getIP(){
		return ip;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getDBname(){
		return dbname;
	}
	public int getPort(){
		return portno;
	}
	public void setIP(String ip){
		this.ip=ip;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setDBname(String dbname){
		this.dbname=dbname;
	}
	public void setPort(int portno){
		this.portno=portno;
	}
	
}
