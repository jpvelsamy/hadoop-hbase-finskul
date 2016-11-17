package com.finskul.hbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.phoenix.jdbc.PhoenixDriver;
import org.apache.phoenix.util.PhoenixRuntime;

public class JdbcClient {

	public static void connect() throws Exception {
	    Connection conn;
	    
	    /*Class.forName("org.apache.phoenix.queryserver.client.Driver");
	    conn =  DriverManager.getConnection("jdbc:phoenix:thin:url=http://bonsai-master:8765;serialization=PROTOBUF");*/
	    Class.forName(PhoenixDriver.class.getName());
	    String zkQuorum="bonsai-phoenix:2181";
	    conn=DriverManager.getConnection(PhoenixRuntime.JDBC_PROTOCOL + PhoenixRuntime.JDBC_PROTOCOL_SEPARATOR + zkQuorum);
	    System.out.println("got connection");
	    ResultSet rst = conn.createStatement().executeQuery("select * from \"orders\"");
	    while (rst.next()) {
	      System.out.println(rst.getString(1) + " " + rst.getString(2));
	    }
	    
	  }
}
