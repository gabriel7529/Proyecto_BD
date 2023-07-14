package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import interfaces.Productos_Entradas_DetalleInterface;

public class Productos_Entradas_DetalleModel implements Productos_Entradas_DetalleInterface{

	@Override
	public int createSubject(Productos_Entradas_Detalle subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l2t_Productos_Entradas_Detalle VALUES (?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getEntDetCod());
			psm.setInt(2, subject.getProCod());
			psm.setInt(3, subject.getEntCabCod());
			psm.setInt(4, subject.getProCan());
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
	public List<Productos_Entradas_Detalle> listSubject() {
		List<Productos_Entradas_Detalle> listSubject = new ArrayList<Productos_Entradas_Detalle>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_Productos_Entradas_Detalle";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Productos_Entradas_Detalle subject = new Productos_Entradas_Detalle();
				subject.setEntDetCod(rs.getInt("EntDetCod"));
				subject.setProCod(rs.getInt("ProCod"));
				subject.setEntCabCod(rs.getInt("EntCabCod"));
				subject.setProCan(rs.getInt("ProCan"));
				subject.setEntDetEstReg(rs.getString("EntDetEstReg"));
				
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
	public Productos_Entradas_Detalle getSubject(String id) {
		Productos_Entradas_Detalle subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_productos_entradas_detalle WHERE EntDetCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Productos_Entradas_Detalle();
				subject.setEntDetCod(rs.getInt("EntDetCod"));
				subject.setProCod(rs.getInt("ProCod"));
				subject.setEntCabCod(rs.getInt("EntCabCod"));
				subject.setProCan(rs.getInt("ProCan"));
				subject.setEntDetEstReg(rs.getString("EntDetEstReg"));
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
			String sql = "DELETE FROM l2t_Productos_Entradas_Detalle WHERE EntDetCod=?";
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
	public int updateSubject(Productos_Entradas_Detalle subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();	
	        String sql = "UPDATE l2t_Productos_Entradas_Detalle SET proCod=?, entCabCod=?, proCan=?, EntDetEstReg=? WHERE entDetCod=?";
	        psm = cn.prepareStatement(sql);
	        
			psm.setInt(1, subject.getProCod());
			psm.setInt(2, subject.getEntCabCod());
			psm.setInt(3, subject.getProCan());
			psm.setString(4, subject.getEntDetEstReg());
			psm.setInt(5, subject.getEntDetCod());
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
