package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import interfaces.Productos_Salidas_DetalleInterface;

public class Productos_Salidas_DetalleModel implements Productos_Salidas_DetalleInterface{

	@Override
	public int createSubject(Productos_Salidas_Detalle subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l4t_Productos_Salidas_Detalle VALUES (?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getSalCod());
			psm.setInt(2, subject.getProCod());
			psm.setInt(3, subject.getProCan());
			psm.setInt(4, subject.getSalDetPreTot());
			psm.setString(5, subject.getEntDetEstReg());

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
	public List<Productos_Salidas_Detalle> listSubject() {
		List<Productos_Salidas_Detalle> listSubject = new ArrayList<Productos_Salidas_Detalle>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l4t_Productos_Salidas_Detalle";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Productos_Salidas_Detalle subject = new Productos_Salidas_Detalle();
				subject.setSalCod(rs.getInt("SalCod"));
				subject.setProCod(rs.getInt("ProCod"));
				subject.setProCan(rs.getInt("ProCan"));
				subject.setSalDetPreTot(rs.getInt("SalDetPreTot"));
				subject.setEntDetEstReg(rs.getString("SalDetEstReg"));
				
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
	public Productos_Salidas_Detalle getSubject(String id) {
		Productos_Salidas_Detalle subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l4t_productos_Salidas_detalle WHERE SalCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Productos_Salidas_Detalle();
				subject.setSalCod(rs.getInt("SalCod"));
				subject.setProCod(rs.getInt("ProCod"));
				subject.setProCan(rs.getInt("ProCan"));
				subject.setSalDetPreTot(rs.getInt("SalDetPreTot"));
				subject.setEntDetEstReg(rs.getString("SalDetEstReg"));
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
			String sql = "DELETE FROM l4t_Productos_Salidas_Detalle WHERE EntDetCod=?";
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
	public int updateSubject(Productos_Salidas_Detalle subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();	
	        String sql = "UPDATE l4t_Productos_Salidas_Detalle SET proCod=?, proCan=?, salDetPreTot=?, salDetEstReg=? WHERE SalCod=?";
	        psm = cn.prepareStatement(sql);
	        
	       
			psm.setInt(1, subject.getProCod());
			psm.setInt(2, subject.getProCan());
			psm.setInt(3, subject.getSalDetPreTot());
			psm.setString(4, subject.getEntDetEstReg());
			 psm.setInt(5, subject.getSalCod());
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
