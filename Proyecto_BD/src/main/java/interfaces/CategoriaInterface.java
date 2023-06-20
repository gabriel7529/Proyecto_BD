package interfaces;

import java.util.List;

import clases.Categoria;

public interface CategoriaInterface {
public int createSubject(Categoria subject);
	
	public List<Categoria> listSubject();
	
	public Categoria getSubject(String id);
	
	public int delateSubject(String id);
}
