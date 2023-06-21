package interfaces;

import java.util.List;

import clases.Unidad_Medida;

public interface Unidad_MedidaInterface {
	public int createSubject(Unidad_Medida subject);

	public List<Unidad_Medida> listSubject();

	public Unidad_Medida getSubject(String id);

	public int delateSubject(String id);
}
