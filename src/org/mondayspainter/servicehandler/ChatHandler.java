/*
 * Author: Sharon Moll
 * 
 */

package org.mondayspainter.servicehandler;

import org.mondayspainter.methods.ChatMessageMethods;


public class ChatHandler extends BasicHandler {

	public Object getLastMessages() {
		
		ChatMessageMethods m = new ChatMessageMethods();
		return m.getLastMessages();
		
	}	
	
	public void addMessage() {
		
		ChatMessageMethods m = new ChatMessageMethods();
		m.addMessageAndCompare(arguments.data.get("message"));
		
	}
	
}