package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import interfaces.ProductosInterface;

public class ProductosModel implements ProductosInterface{

	@Override
	public int createSubject(Productos subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l1t_productos VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getProCod());
			psm.setString(2, subject.getProNom());
			psm.setInt(3, subject.getUniMedCod());
			psm.setInt(4, subject.getProSto());
			psm.setDouble(5, subject.getProPreVen());
			psm.setDouble(6, subject.getProPreCom());
			psm.setString(7, subject.getProEstReg());
			psm.setInt(8, subject.getProCat());
			
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

	@Override
	public List<Productos> listSubject() {
		List<Productos> listSubject = new ArrayList<Productos>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l1t_productos";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Productos subject = new Productos();
				subject.setProCod(rs.getInt("ProCod"));
				subject.setProNom(rs.getString("ProNom"));
				subject.setUniMedCod(rs.getInt("UniMedCod"));
				subject.setProSto(rs.getInt("ProSto"));
				subject.setProPreVen(rs.getDouble("ProPreVen"));
				subject.setProPreCom(rs.getDouble("ProEstReg"));
				subject.setProEstReg(rs.getString("ProEstReg"));
				subject.setProCat(rs.getInt("ProCat"));
				listSubject.add(subject);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if (rs != null) rs.close();
					if (psm != null) psm.close();
					if (cn != null) cn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		return listSubject;
	}

	@Override
	public Productos getSubject(String id) {
		Productos subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l1t_productos WHERE ProCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Productos();
				subject.setProCod(rs.getInt("ProCod"));
				subject.setProNom(rs.getString("ProNom"));
				subject.setUniMedCod(rs.getInt("UniMedCod"));
				subject.setProSto(rs.getInt("ProSto"));
				subject.setProPreVen(rs.getDouble("ProPreVen"));
				subject.setProPreCom(rs.getDouble("ProEstReg"));
				subject.setProEstReg(rs.getString("ProEstReg"));
				subject.setProCat(rs.getInt("ProCat"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psm != null) psm.close();
				if (cn != null) cn.close();
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
			String sql = "DELETE FROM l1t_productos WHERE ProCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			value = psm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	public int updateSubject(Productos subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();	
	        String sql = "UPDATE l1t_productos SET ProNom=?, UniMedCod=?,ProSto=?, ProPreVen=?, ProPreCom=?, ProEstReg=?, ProCat=? WHERE ProCod=?";
	        psm = cn.prepareStatement(sql);
			psm.setString(1, subject.getProNom());
			psm.setInt(2, subject.getUniMedCod());
			psm.setInt(3, subject.getProSto());
			psm.setDouble(4, subject.getProPreVen());
			psm.setDouble(5, subject.getProPreCom());
			psm.setString(6, subject.getProEstReg());
			psm.setInt(7, subject.getProCat());
			psm.setInt(8, subject.getProCod());
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
