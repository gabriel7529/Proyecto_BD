package interfaces;

import java.util.List;

import clases.Productos;

public interface CategoriaInterface {
public int createSubject(Productos subject);
	
	public List<Productos> listSubject();
	
	public Productos getSubject(String id);
	
	public int delateSubject(String id);
}
