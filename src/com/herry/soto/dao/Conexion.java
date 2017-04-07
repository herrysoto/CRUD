package com.herry.soto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

		protected Connection conexion;
		
		final String JDBC_DRIVER="oracle.jdbc.OracleDriver" ;
		final String BD_URL="jdbc:oracle:thin:@10.0.0.125:1521:PRUEBA" ;
		final String USER="A11012016" ;
		final String PASS="TEST" ;
		
	public void conectar() throws Exception{
		try {
			Class.forName(JDBC_DRIVER);
			conexion = DriverManager.getConnection(BD_URL, USER, PASS);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void cerrar() throws SQLException{
		if(conexion !=null){
			if(!conexion.isClosed()){
				conexion.close();
			}
		}
	}


}
