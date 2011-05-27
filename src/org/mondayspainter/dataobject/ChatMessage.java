package org.mondayspainter.dataobject;

import org.mondayspainter.dbhandler.ChatMessageHandler;
import org.mondayspainter.dbhandler.IDataHandler;
import org.mondayspainter.transportobject.ChatMessageTransport;

public class ChatMessage extends DataObject<ChatMessage> {
	
	private String text;
	private int playerId;
	
	public ChatMessage() { }
	
	public ChatMessageTransport toTransportObject() {
		ChatMessageTransport t = new ChatMessageTransport();
		t.id = id;
		t.message = text;
		return t;
	}
	
	@Override
	public IDataHandler<ChatMessage> getDataHandler() {
		return new ChatMessageHandler();
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
}
