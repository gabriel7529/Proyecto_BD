package interfaces;

import java.util.List;

import clases.RubroProveedor;


public interface RubroProveedorInterface {
	public int createSubject(RubroProveedor subject);

	public List<RubroProveedor> listSubject();

	public RubroProveedor getSubject(String id);

	public int delateSubject(String id);
}
