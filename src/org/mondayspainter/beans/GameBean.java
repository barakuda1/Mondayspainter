package org.mondayspainter.beans;

/*
 * Author: Nenad Dimitrijevic
 * Date created: 29.03.2011
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mondayspainter.db.Db;

@SessionScoped
@ManagedBean(name="game")
public class GameBean {
	
	private Db database = Db.getInstance();
	private PlayerBean player = new PlayerBean();

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public PlayerBean getPlayer() {
		return player;
	}
	
	public String logIn() {
		if(this.player != null && this.player.getId() != 0 && !this.player.getName().equals("") 
				&& !this.player.getPassword().equals("") && this.player.getPoints() >= 0) {
			return "logInAllowed";
		}
		return "logInNotAllowed";
	}

}
