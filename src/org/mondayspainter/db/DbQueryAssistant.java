/*
 * Author: Sharon Moll
 * 
 */
package org.mondayspainter.db;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.config.PropertySetter;
import org.mondayspainter.dataobject.DataObject;

/*
 * STILL NEEDS TO BE REVISED
 */

public class DbQueryAssistant {
	
	public static <T extends DataObject<T>> void executeSelect(String table, T obj, SqlParameter ...params) {
		String q = DbQueryAssistant.createQuery(
									"SELECT * FROM "+table+" WHERE id=:id", 
									obj.getId(), 
									params
								);
		ResultSet r = Db.getInstance().sendQuery(q);
		try {
			r.next();
		} catch (SQLException e) {}
		setObjectData(obj, r);
	}
	
	public static <T extends DataObject<T>> ArrayList<T> executeSelectAll(String table, T obj) {
		String q = DbQueryAssistant.createQuery(
									"SELECT * FROM "+table+" ORDER BY id ASC"
								);
		ResultSet r = Db.getInstance().sendQuery(q);
		ArrayList<T> al = new ArrayList<T>();
		try {
			while(r.next()) {
				T o = (T)obj.getClass().newInstance();
				setObjectData(o, r);
				al.add(o);
			}
		} catch (Exception e) {}
		return al;
	}
	
	public static <T extends DataObject<T>> boolean executeDelete(String table, T obj, SqlParameter ...params) {
		String q = DbQueryAssistant.createQuery(
									"DELETE FROM "+table+" WHERE id=:id", 
									obj.getId(),
									params
								);
		Db.getInstance().insertQuery(q);
		return true;
	}
	
	public static <T extends DataObject<T>> boolean executeUpdate(String table, T obj, SqlParameter ...params) {
		String query = "UPDATE "+table+" SET ";
		for(SqlParameter p : params) {
			query += p.getKey()+"=':"+p.getKey()+"', ";
		}
		query = query.substring(0, query.length()-2)+" WHERE id=:id";		
		String q = DbQueryAssistant.createQuery(query, obj.getId(), params);
		Db.getInstance().insertQuery(q);
		return true;
	} 
	
	public static <T extends DataObject<T>> boolean executeInsert(String table, T obj, SqlParameter ...params) {
		String query = "INSERT INTO "+table+" (";
		for(SqlParameter p : params) {
			query += p.getKey()+",";
		}
		query = query.substring(0, query.length()-1)+") VALUES (";
		for(SqlParameter p : params) {
			query += "':"+p.getKey()+"',";
		}	
		query = query.substring(0, query.length()-1)+");";
		String q = DbQueryAssistant.createQuery(query, obj.getId(), params);
		
		//do Transaction for data persistence
		Db.getInstance().beginTransaction();
		Db.getInstance().insertQuery(q);
		ResultSet r = Db.getInstance().sendQuery("SELECT * FROM "+table+" ORDER BY id DESC");
		Db.getInstance().endTransaction();
		
		try {
			r.next();
		} catch (SQLException e) {}
		
		setObjectData(obj, r);
		return true;
	}  
	
	private static <T extends DataObject<T>> void setObjectData(T obj, ResultSet r) {
		PropertySetter ps = new PropertySetter(obj);			
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for(Field f : fields) {
				ps.setProperty(f.getName(), r.getString(f.getName()));
			}
			ps.setProperty("id", r.getString("id"));
		} catch (Exception e) {
			System.out.println("Wrong Datamapping in Dataobject!");
		}		
	}
	
	private static String createQuery(String query, int id, SqlParameter ...params) {
		query = query.toLowerCase();
		for(int c=0; c<params.length; c++) {
			query = query.replaceAll(":"+params[c].getKey().toLowerCase(), params[c].getValue());
		}		
		query = query.replaceAll(":id", String.valueOf(id));
		return query;
	}
	
	private static String createQuery(String query, SqlParameter ...params) {
		return createQuery(query, 0, params);
	}
}