package interfaces;

import java.util.List;

import clases.Productos_Entradas_Detalle;

public interface Productos_Entradas_DetalleInterface {
	public int createSubject(Productos_Entradas_Detalle subject);

	public List<Productos_Entradas_Detalle> listSubject();

	public Productos_Entradas_Detalle getSubject(String id);

	public int delateSubject(String id);
}
