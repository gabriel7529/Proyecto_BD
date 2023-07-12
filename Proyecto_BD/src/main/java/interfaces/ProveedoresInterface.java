package interfaces;

import java.util.List;

import clases.Proveedores;

public interface ProveedoresInterface {

	public int createSubject(Proveedores subject);

	public List<Proveedores> listSubject();

	public Proveedores getSubject(String id);

	public int delateSubject(String id);
}
