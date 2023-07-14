package interfaces;

import java.util.List;

import clases.Productos_Salidas_Cabecera;

public interface Productos_Salidas_CabeceraInterface {
	public int createSubject(Productos_Salidas_Cabecera subject);

	public List<Productos_Salidas_Cabecera> listSubject();

	public Productos_Salidas_Cabecera getSubject(String id);

	public int delateSubject(String id);
}
