package org.mondayspainter.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.mondayspainter.db.Db;

@RequestScoped
@ManagedBean(name="beMember")
public class BeMemberBean {
	
	private Db database  = Db.getInstance();
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String askForMembership() {
		
		//ResultSet resultSet = database.sendQuery("");
		
		return null;
	}

}
