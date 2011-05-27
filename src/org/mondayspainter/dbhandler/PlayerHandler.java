package org.mondayspainter.dbhandler;

import java.util.ArrayList;

import org.mondayspainter.dataobject.ChatMessage;
import org.mondayspainter.dataobject.Player;
import org.mondayspainter.db.DbQueryAssistant;
import org.mondayspainter.db.SqlParameter;

public class PlayerHandler implements IDataHandler<Player> {

	@Override
	public void select(Player target) {
		DbQueryAssistant.executeSelect(
								"player",
								target
							);
	}
	
	@Override
	public ArrayList<Player> selectAll(Player target) {
		return DbQueryAssistant.executeSelectAll(
								"player",
								target
							);
	}

	@Override
	public boolean delete(Player target) {
		return DbQueryAssistant.executeDelete(
								"player",
								target
							);
	}

	@Override
	public boolean deleteAll() {
		return false;
	}

	@Override
	public boolean update(Player target) {
		return DbQueryAssistant.executeUpdate(
								"player",
								target,
								new SqlParameter("name", target.getName()),
								new SqlParameter("password", target.getPassword()),
								new SqlParameter("points", target.getPoints())
							);
	}

	@Override
	public boolean insert(Player target) {
		return DbQueryAssistant.executeInsert(
								"player", 
								target,
								new SqlParameter("name", target.getName()),
								new SqlParameter("password", target.getPassword()),
								new SqlParameter("points", target.getPoints())
							);
	}

}
