package org.mondayspainter.dbhandler;

import java.util.ArrayList;

import org.mondayspainter.dataobject.Round;
import org.mondayspainter.db.DbQueryAssistant;
import org.mondayspainter.db.SqlParameter;

public class RoundHandler implements IDataHandler<Round> {

	@Override
	public void select(Round target) {
		DbQueryAssistant.executeSelect(
								"round",
								target
							);
	}
	
	@Override
	public ArrayList<Round> selectAll(Round target) {
		return DbQueryAssistant.executeSelectAll(
								"round",
								target
							);
	}

	@Override
	public boolean delete(Round target) {
		return DbQueryAssistant.executeDelete(
								"round",
								target
							);
	}

	@Override
	public boolean deleteAll() {
		return false;
	}

	@Override
	public boolean update(Round target) {
		return DbQueryAssistant.executeUpdate(
								"round",
								target,
								new SqlParameter("paintobjectId", target.getPaintobjectId()),
								new SqlParameter("playerId", target.getPlayerId())
							);
	}

	@Override
	public boolean insert(Round target) {
		return DbQueryAssistant.executeInsert(
								"round", 
								target,
								new SqlParameter("paintobjectId", target.getPaintobjectId()),
								new SqlParameter("playerId", target.getPlayerId())
							);
	}

}
