package org.mondayspainter.dataobject;

import org.mondayspainter.dbhandler.IDataHandler;
import org.mondayspainter.dbhandler.PlayerHandler;
import org.mondayspainter.transportobject.PlayerTransport;

public class Player extends DataObject<Player> {
	
	private String name;
	private String password;
	private int points;
	
	public Player() { }
	
	public PlayerTransport toTransportObject() {
		PlayerTransport t = new PlayerTransport();
		t.id = id;
		t.name = name;
		t.points = points;
		return t;
	}
	
	@Override
	public IDataHandler<Player> getDataHandler() {
		return new PlayerHandler();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


}
