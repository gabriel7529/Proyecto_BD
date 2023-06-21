package clases;
import interfaces.Unidad_MedidaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Unidad_MedidaModel implements Unidad_MedidaInterface {

	@Override
	public int createSubject(Unidad_Medida subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO gzz_unidades_de_medida VALUES (?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getUniMedCod());
			psm.setString(2, subject.getUniMedNom());
			
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
	public List<Unidad_Medida> listSubject() {
		List<Unidad_Medida> listSubject = new ArrayList<Unidad_Medida>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM gzz_unidades_de_medida";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Unidad_Medida subject = new Unidad_Medida();
				subject.setUniMedCod(rs.getInt("UniMedCod"));
				subject.setUniMedNom(rs.getString("UniMedNom"));
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
	public Unidad_Medida getSubject(String id) {
		Unidad_Medida subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM gzz_unidades_de_medida WHERE uniMedCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new Unidad_Medida();
				subject.setUniMedCod(rs.getInt("UniMedCod"));
				subject.setUniMedNom(rs.getString("UniMedNom"));
				
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
			String sql = "DELETE FROM gzz_unidades_de_medida WHERE uniMedCod=?";
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
	
	public int updateSubject(Unidad_Medida subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE gzz_unidades_de_medida SET uniMedNom=? WHERE uniMedCod=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, subject.getUniMedNom());
	        psm.setInt(2, subject.getUniMedCod());
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
