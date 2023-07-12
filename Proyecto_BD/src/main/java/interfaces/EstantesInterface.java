package interfaces;

import java.util.List;

import clases.Estantes;

public interface EstantesInterface {

	public int createSubject(Estantes subject);

	public List<Estantes> listSubject();

	public Estantes getSubject(String id);

	public int delateSubject(String id);
}
