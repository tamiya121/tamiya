<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
public class Person {
	private String name;
	private String id;
	private String pwd;
	private String trans;
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", pwd=" + pwd + ", trans=" + trans + "]";
	}
	
	
}
%>
<%
String param = request.getParameter("param");
Gson gson = new Gson();
Person p = gson.fromJson(request.getReader(), Person.class);


List<Person> pList = new ArrayList<Person>();

for(int i=1; i<=10; i++){
	p = new Person();
	p.setId("id" + i);
	p.setPwd("비번" + i);
	p.setName("이름" + i);
	p.setTrans(((i%2)+1) + "");
	pList.add(p);
}
out.println(gson.toJson(pList));
%>    
