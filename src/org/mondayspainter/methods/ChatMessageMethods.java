package org.mondayspainter.methods;

import java.util.ArrayList;

import org.mondayspainter.dataobject.ChatMessage;
import org.mondayspainter.dataobject.Player;
import org.mondayspainter.transportobject.ChatMessageTransport;

public class ChatMessageMethods {
	
	public void addMessageAndCompare(String msg){
		ChatMessage m = new ChatMessage();
		m.setText(msg);
		m.update();
		
		deleteAllMessagesButLast20();
		
		//compare word
		
	}
	
	public void deleteAllMessagesButLast20() {
		ArrayList<ChatMessage> msgs = new ChatMessage().selectAll();
		if(msgs.size() > 20) {
			for(int c=0; c < 20; c++) {
				msgs.get(0).delete();
			}
		}
	}
	
	public ArrayList<ChatMessageTransport> getLastMessages() {
		ArrayList<ChatMessage> msgs = new ChatMessage().selectAll();
		ArrayList<ChatMessageTransport> ret = new ArrayList<ChatMessageTransport>();
		
		for(ChatMessage msg : msgs) {
			Player p = new Player();
			p.setId(msg.getPlayerId());
			p.select();
			
			ChatMessageTransport cmt = msg.toTransportObject();
			cmt.author = p.getName();
			ret.add(cmt);
		}
		return ret;
	}
}
