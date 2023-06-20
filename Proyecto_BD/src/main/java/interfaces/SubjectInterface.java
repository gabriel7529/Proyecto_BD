package interfaces;

import java.util.List;

import clases.Clientes;

public interface SubjectInterface {
	
	
	public int createSubject(Clientes subject);
	
	public List<Clientes> listSubject();
	
	public Clientes getSubject(String id);
	
	public int delateSubject(String id);
	
}
