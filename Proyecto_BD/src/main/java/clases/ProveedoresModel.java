package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ProveedoresInterface;

public class ProveedoresModel implements ProveedoresInterface {
	
	@Override
	public int createSubject(Proveedores subject) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l3m_proveedores VALUES (?, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getPrvCod());
			psm.setString(2, subject.getPrvNom());
			psm.setString(3, subject.getPrvTel());
			psm.setString(4, subject.getProDir());
			psm.setInt(5, subject.getRubPrv());
			psm.setString(6, subject.getPrvEstReg());
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
	public List<Proveedores> listSubject() {
		List<Proveedores> listSubject = new ArrayList<Proveedores>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l3m_proveedores";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Proveedores subject = new Proveedores();
				subject.setPrvCod(rs.getInt("PrvCod"));
				subject.setPrvNom(rs.getString("PrvNom"));
				subject.setPrvTel(rs.getString("PrvTel"));
				subject.setProDir(rs.getString("ProDir"));
				subject.setRubPrv(rs.getInt("RubPrv"));
				subject.setPrvEstReg(rs.getString("PrvEstReg"));
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
	public Proveedores getSubject(String id) {
		Proveedores subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l3m_proveedores WHERE PrvCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new Proveedores();
				subject.setPrvCod(rs.getInt("PrvCod"));
				subject.setPrvNom(rs.getString("PrvNom"));
				subject.setPrvTel(rs.getString("PrvTel"));
				subject.setProDir(rs.getString("ProDir"));
				subject.setRubPrv(rs.getInt("RubPrv"));
				subject.setPrvEstReg(rs.getString("PrvEstReg"));
				
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
			String sql = "DELETE FROM l3m_proveedores WHERE estNum=?";
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
	
	public int updateSubject(Proveedores subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE l3m_proveedores SET prvNom=?, prvTel=? , proDir=?, RubPrv=?, prvEstReg=?  WHERE prvCod=?";
	        psm = cn.prepareStatement(sql);
	       
	        psm.setInt(1, subject.getPrvCod());
			psm.setString(1, subject.getPrvNom());
			psm.setString(2, subject.getPrvTel());
			psm.setString(3, subject.getProDir());
			psm.setInt(4, subject.getRubPrv());
			psm.setString(5, subject.getPrvEstReg());
			 psm.setInt(6, subject.getPrvCod());
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
