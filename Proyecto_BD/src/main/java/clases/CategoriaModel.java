package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import interfaces.CategoriaInterface;

public class CategoriaModel implements CategoriaInterface {

	@Override
	public int createSubject(Categoria subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO categorias_productos VALUES (?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getCatProCod());
			psm.setString(2, subject.getNombre());
			psm.setString(3, subject.getEstado());

			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;

	}

	@Override
	public List<Categoria> listSubject() {
		List<Categoria> listSubject = new ArrayList<Categoria>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM categorias_productos";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Categoria subject = new Categoria();
				subject.setCatProCod(rs.getInt("CatProCod"));
				subject.setNombre(rs.getString("CatProNom"));
				subject.setEstado(rs.getString("CatEstReg"));

				listSubject.add(subject);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listSubject;
	}

	@Override
	public Categoria getSubject(String id) {
		Categoria subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM categorias_productos WHERE catProCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new Categoria();
				subject.setCatProCod(rs.getInt("CatProCod"));
				subject.setNombre(rs.getString("CatProNom"));
				subject.setEstado(rs.getString("CatEstReg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subject;

	}

	@Override
	public int delateSubject(String id) {
		int value = 0;

		Connection cn = null;
		PreparedStatement psm = null;
		try {

			cn = MysqlConnection.getConexion();
			String sql = "DELETE FROM categorias_productos WHERE CatProCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (psm != null)
					psm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;

	}
	public int updateSubject(Categoria subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE categorias_productos SET catProNom=?, catEstReg=? WHERE catProCod=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, subject.getNombre());
	        psm.setString(2, subject.getEstado());
	        psm.setInt(3, subject.getCatProCod());
	        value = psm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (psm != null) psm.close();
	            if (cn != null) cn.close();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    return value;
	}
}
