package org.mondayspainter.beans;

import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.mondayspainter.db.Db;

/*
 * Author: Nenad Dimitrijevic
 * Date created: 08.03.2011
 */

@SessionScoped
@ManagedBean(name="loginBackingBean")
public class LoginBackingBean {

	private UIInput userNoComponent;
	
	public void validatePassword(FacesContext context, UIComponent component, Object value) {
		String playerName = (String) userNoComponent.getLocalValue();
		String playerPassword = (String) value.toString();
		
		if(playerName != null && playerPassword != null) {
			Db db = Db.getInstance();
			ResultSet resultSet = db.sendQuery("SELECT * FROM player p where p.name='"+playerName+"' and p.password='"+playerPassword+"'");
			
			try {
				if(resultSet.next()) {
					
					if(resultSet.getString("password").equals(playerPassword)) {					
						//Player
						GameBean gameBean = (GameBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
						PlayerBean player = gameBean.getPlayer();
						
						player.setId(Integer.valueOf(resultSet.getString("id")));
						player.setPassword(resultSet.getString("password"));
						player.setPoints(Integer.valueOf(resultSet.getString("points")));
						
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		FacesMessage message = new FacesMessage("Login Failed");
		context.addMessage(component.getClientId(context), message);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(message);
	}

	public UIInput getUserNoComponent() {
		return userNoComponent;
	}

	public void setUserNoComponent(UIInput userNoComponent) {
		this.userNoComponent = userNoComponent;
	}
	
}
