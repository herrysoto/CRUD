package com.herry.soto.interfaces;

import java.util.List;
import com.herry.soto.bean.Persona;

public interface DAOPersona {
	public void registrar(Persona per) throws Exception;
	public void editar(Persona per) throws Exception;
	public void eliminar(Persona per) throws Exception;
	public List<Persona> listar() throws Exception;
}
