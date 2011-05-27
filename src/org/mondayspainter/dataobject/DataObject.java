/*
 * Author: Sharon Moll
 */
package org.mondayspainter.dataobject;

import java.util.ArrayList;

import org.mondayspainter.dbhandler.IDataHandler;

public abstract class DataObject<T> {
	protected int id;
	private IDataHandler<T> handler;
	
	public void select() {
		getHandler().select((T)this);
	}

	public ArrayList<T> selectAll() {
		return getHandler().selectAll((T)this);
	}

	public boolean delete() {
		return getHandler().delete((T)this);
	}

	public boolean deleteAll() {
		return getHandler().deleteAll();
	}
	
	public boolean update() {
		if(id > 0)
			return getHandler().update((T)this);
		else 
			return getHandler().insert((T)this);
	}
	
	private IDataHandler<T> getHandler() {
		if(handler == null)
			handler = getDataHandler();
		return handler;
	}
	
	public abstract IDataHandler<T> getDataHandler();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
