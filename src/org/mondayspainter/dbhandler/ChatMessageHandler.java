package org.mondayspainter.dbhandler;

import java.util.ArrayList;

import org.mondayspainter.dataobject.ChatMessage;
import org.mondayspainter.db.DbQueryAssistant;
import org.mondayspainter.db.SqlParameter;

public class ChatMessageHandler implements IDataHandler<ChatMessage> {

	@Override
	public void select(ChatMessage target) {
		DbQueryAssistant.executeSelect(
								"message",
								target
							);
	}
	
	@Override
	public ArrayList<ChatMessage> selectAll(ChatMessage target) {
		return DbQueryAssistant.executeSelectAll(
								"message",
								target
							);
	}

	@Override
	public boolean delete(ChatMessage target) {
		return DbQueryAssistant.executeDelete(
								"message",
								target
							);
	}

	@Override
	public boolean deleteAll() {
		return false;
	}

	@Override
	public boolean update(ChatMessage target) {
		return DbQueryAssistant.executeUpdate(
								"message",
								target,
								new SqlParameter("text", target.getText()),
								new SqlParameter("playerId", target.getPlayerId())
							);
	}

	@Override
	public boolean insert(ChatMessage target) {
		return DbQueryAssistant.executeInsert(
								"message", 
								target,
								new SqlParameter("text", target.getText()),
								new SqlParameter("playerId", target.getPlayerId())
							);
	}

}
