package com.herry.soto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.herry.soto.bean.Persona;
import com.herry.soto.interfaces.DAOPersona;

public class DAOPersonImpl extends Conexion implements DAOPersona{

	@Override
	public void registrar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO PRUEBABD(ID,NOMBRE) VALUES(?,?)");
			st.setString(1,per.getId());
			st.setString(2,per.getNombre());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
	}

	@Override
	public void editar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("UPDATE PRUEBABD SET NOMBRE = ? WHERE ID = ?");
			st.setString(1,per.getNombre());
			st.setString(2,per.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
	}

	@Override
	public void eliminar(Persona per) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE FROM PRUEBABD WHERE ID = ?");
			st.setString(1,per.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> listahh = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("select * from PRUEBABD order by id");
			listahh = new ArrayList();
			ResultSet rs =  st.executeQuery();
			while (rs.next()) {
				Persona bhh = new Persona();
				bhh.setId(rs.getString("id"));
				bhh.setNombre(rs.getString("nombre"));
				listahh.add(bhh);
			}
			st.close();
			rs.close();//esto esta en vano ya que el st lo cierra automaticamente
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
		return listahh;
	}
	
}
