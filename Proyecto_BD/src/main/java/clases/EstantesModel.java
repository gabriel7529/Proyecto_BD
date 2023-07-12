package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.EstantesInterface;

public class EstantesModel implements EstantesInterface {
	
	@Override
	public int createSubject(Estantes subject) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;

		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l2t_estantes VALUES (?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getEstNum());
			psm.setInt(2, subject.getAlmNum());
			psm.setInt(3, subject.getEstCap());
			psm.setString(4, subject.getEstReg());
			
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
	public List<Estantes> listSubject() {
		List<Estantes> listSubject = new ArrayList<Estantes>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_estantes";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Estantes subject = new Estantes();
				subject.setEstNum(rs.getInt("EstNum"));
				subject.setAlmNum(rs.getInt("AlmNum"));
				subject.setEstCap(rs.getInt("EstCap"));
				subject.setEstReg(rs.getString("EstReg"));
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
	public Estantes getSubject(String id) {
		Estantes subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;

		try {

			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_estantes WHERE estNum=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				subject = new Estantes();
				subject.setEstNum(rs.getInt("EstNum"));
				subject.setAlmNum(rs.getInt("AlmNum"));
				subject.setEstCap(rs.getInt("EstCap"));
				subject.setEstReg(rs.getString("EstReg"));
				
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
			String sql = "DELETE FROM l2t_estantes WHERE estNum=?";
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
	
	public int updateSubject(Estantes subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE l2t_estantes SET almNum=?, estCap=? ,estReg=? WHERE estNum=?";
	        psm = cn.prepareStatement(sql);
	       
			psm.setInt(1, subject.getAlmNum());
			psm.setInt(2, subject.getEstCap());
			psm.setString(3, subject.getEstReg());
			 psm.setInt(4, subject.getEstNum());
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
