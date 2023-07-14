package interfaces;

import java.util.List;

import clases.Productos_Salidas_Detalle;

public interface Productos_Salidas_DetalleInterface {
	public int createSubject(Productos_Salidas_Detalle subject);

	public List<Productos_Salidas_Detalle> listSubject();

	public Productos_Salidas_Detalle getSubject(String id);

	public int delateSubject(String id);
}
