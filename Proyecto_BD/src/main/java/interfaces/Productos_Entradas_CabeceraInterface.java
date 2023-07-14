package interfaces;

import java.util.List;

import clases.Productos_Entradas_Cabecera;

public interface Productos_Entradas_CabeceraInterface {
	public int createSubject(Productos_Entradas_Cabecera subject);

	public List<Productos_Entradas_Cabecera> listSubject();

	public Productos_Entradas_Cabecera getSubject(String id);

	public int delateSubject(String id);
}
