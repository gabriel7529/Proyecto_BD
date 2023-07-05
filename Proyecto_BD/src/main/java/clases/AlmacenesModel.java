package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.AlmacenesInterface;

public class AlmacenesModel implements AlmacenesInterface {

	@Override
	public int createSubject(Almacenes subject) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l2t_almacenes VALUES (?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getAlmNum());
			psm.setString(2, subject.getAlmDir());
			psm.setString(3, subject.getAlmEstReg());
			
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
	public List<Almacenes> listSubject() {
		List<Almacenes> listSubject = new ArrayList<Almacenes>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_almacenes";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Almacenes subject = new Almacenes();
				subject.setAlmNum(rs.getInt("AlmNum"));
				subject.setAlmDir(rs.getString("AlmDir"));
				subject.setAlmEstReg(rs.getString("AlmEstReg"));
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
	public Almacenes getSubject(String id) {
		Almacenes subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_almacenes WHERE almNum=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new Almacenes();
				subject.setAlmNum(rs.getInt("almNum"));
				subject.setAlmDir(rs.getString("almDir"));
				subject.setAlmEstReg(rs.getString("almEstReg"));
				
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
			String sql = "DELETE FROM l2t_almacenes WHERE almCod=?";
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
	
	public int updateSubject(Almacenes subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE l2t_almacenes SET almDir=?, almEstReg=? WHERE almNum=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, subject.getAlmDir());
	        psm.setString(2, subject.getAlmEstReg());
	        psm.setInt(3, subject.getAlmNum());
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
