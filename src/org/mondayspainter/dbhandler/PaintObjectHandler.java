package org.mondayspainter.dbhandler;

import java.util.ArrayList;

import org.mondayspainter.dataobject.PaintObject;
import org.mondayspainter.db.DbQueryAssistant;
import org.mondayspainter.db.SqlParameter;

public class PaintObjectHandler implements IDataHandler<PaintObject> {

	@Override
	public void select(PaintObject target) {
		DbQueryAssistant.executeSelect(
								"paintobject",
								target
							);
	}
	
	@Override
	public ArrayList<PaintObject> selectAll(PaintObject target) {
		return DbQueryAssistant.executeSelectAll(
								"paintobject",
								target
							);
	}

	@Override
	public boolean delete(PaintObject target) {
		return DbQueryAssistant.executeDelete(
								"paintobject",
								target
							);
	}

	@Override
	public boolean deleteAll() {
		return false;
	}

	@Override
	public boolean update(PaintObject target) {
		return DbQueryAssistant.executeUpdate(
								"paintobject",
								target,
								new SqlParameter("title", target.getTitle())
							);
	}

	@Override
	public boolean insert(PaintObject target) {
		return DbQueryAssistant.executeInsert(
								"paintobject", 
								target,
								new SqlParameter("title", target.getTitle())
							);
	}

}
