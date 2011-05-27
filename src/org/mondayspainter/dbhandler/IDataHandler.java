package org.mondayspainter.dbhandler;

import java.util.ArrayList;

public interface IDataHandler<T> {
	
	 void select(T target);
 	 ArrayList<T> selectAll(T target);
 	 boolean delete(T target);
 	 boolean deleteAll();
 	 boolean update(T target);
 	 boolean insert(T target);
	
}
