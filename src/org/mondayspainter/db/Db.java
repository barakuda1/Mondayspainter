package org.mondayspainter.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/*
 * Author: Nenad Dimitrijevic
 * Date created: 08.03.2011
 */

public class Db {
	
	private static Db instance;

    private MysqlDataSource database;
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    private boolean transaction = false;
    
    public static Db getInstance() {
    	if(instance == null)
    		instance = new Db();
    	return instance;
    }

    private Db(){
        database = new MysqlDataSource();

        database.setDatabaseName("mondayspainter");
        database.setServerName("localhost");
        database.setPort(Integer.parseInt("3306"));
        database.setUser("root");
        database.setPassword("");

        try {
            connection = database.getConnection();
        } catch (SQLException e) {
            System.err.println("Es konnte keine Verbindung zur Datenbank aufgebaut werden!");
        }
    
    }
    
    public void beginTransaction() {
    	transaction = true;
    	try {
			statement  = connection.createStatement();
		} catch (Exception e) {}
    }
    
    public void endTransaction() {
    	transaction = false;
    }
    
    private Statement getStatement() {
    	if(transaction) {
    		return statement;
    	}
    	try {
			statement = connection.createStatement();
		} catch (Exception e) {}
    	return statement;
    }

    public ResultSet sendQuery(String query){
        try {
            statement = this.getStatement();
            resultset = statement.executeQuery(query);
            return resultset;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void insertQuery(String query) {
        try {
            statement = this.getStatement();
            statement.executeUpdate(query);            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

