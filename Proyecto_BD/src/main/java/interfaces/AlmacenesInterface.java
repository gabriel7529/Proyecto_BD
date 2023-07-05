package interfaces;

import java.util.List;

import clases.Almacenes;

public interface AlmacenesInterface {
	public int createSubject(Almacenes subject);

	public List<Almacenes> listSubject();

	public Almacenes getSubject(String id);

	public int delateSubject(String id);
}
