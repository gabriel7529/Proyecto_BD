package clases;
import interfaces.RubroProveedorInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class RubroProveedorModel implements RubroProveedorInterface {

	@Override
	public int createSubject(RubroProveedor subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO gzz_rubro_proveedor VALUES (?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getRubProCod());
			psm.setString(2, subject.getRubNom());
			psm.setString(3, subject.getRubEstReg());
			
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
	public List<RubroProveedor> listSubject() {
		List<RubroProveedor> listSubject = new ArrayList<RubroProveedor>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM gzz_rubro_proveedor";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				RubroProveedor subject = new RubroProveedor();
				subject.setRubProCod(rs.getInt("RubProCod"));
				subject.setRubNom(rs.getString("RubNom"));
				subject.setRubEstReg(rs.getString("RubEstReg"));
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
	public RubroProveedor getSubject(String id) {
		RubroProveedor subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM gzz_rubro_proveedor WHERE rubProCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new RubroProveedor();
				subject.setRubProCod(rs.getInt("RubProCod"));
				subject.setRubNom(rs.getString("RubNom"));
				subject.setRubEstReg(rs.getString("RubEstReg"));
				
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
			String sql = "DELETE FROM gzz_rubro_proveedor WHERE rubProCod=?";
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
	
	public int updateSubject(RubroProveedor subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE gzz_rubro_proveedor SET rubNom=?, rubEstReg=? WHERE rubProCod=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, subject.getRubNom());
	        psm.setString(2, subject.getRubEstReg());
	        psm.setInt(3, subject.getRubProCod());
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
