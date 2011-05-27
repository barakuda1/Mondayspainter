package org.mondayspainter.dataobject;

import org.mondayspainter.dbhandler.IDataHandler;
import org.mondayspainter.dbhandler.RoundHandler;
import org.mondayspainter.transportobject.RoundTransport;

public class Round extends DataObject<Round> {
	
	private int paintobjectId;
	private int playerId;
	
	public Round() { }
	
	public RoundTransport toTransportObject() {
		return null;
	}
	
	@Override
	public IDataHandler<Round> getDataHandler() {
		return new RoundHandler();
	}
	
	public int getPaintobjectId() {
		return paintobjectId;
	}

	public void setPaintobjectId(int paintobjectId) {
		this.paintobjectId = paintobjectId;
	}

	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
}
