package clases;
import interfaces.SubjectInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class ClienteModel implements SubjectInterface{

	@Override
	public int createSubject(Clientes subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getCliCod());
			psm.setString(2, subject.getCliNom());
			psm.setInt(3, subject.getCliRuc());
			psm.setString(4, subject.getCliDir());
			
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
	public List<Clientes> listSubject() {
		List<Clientes> listSubject = new ArrayList<Clientes>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM clientes";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Clientes subject = new Clientes();
				subject.setCliCod(rs.getInt("CliCod"));
				subject.setCliNom(rs.getString("CliNom"));
				subject.setCliRuc(rs.getInt("CilRuc"));
				subject.setCliDir(rs.getString("CliDir"));
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
	public Clientes getSubject(String id) {
		Clientes subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM clientes WHERE cliCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Clientes();
				subject.setCliCod(rs.getInt("CliCod"));
				subject.setCliNom(rs.getString("CliNom"));
				subject.setCliRuc(rs.getInt("CilRuc"));
				subject.setCliDir(rs.getString("CliDir"));
				
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
			String sql = "DELETE FROM clientes WHERE cliCod=?";
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
	public int updateSubject(Clientes subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();
	        String sql = "UPDATE clientes SET cliNom=?, cilRuc=?,cliDir=? WHERE cliCod=?";
	        psm = cn.prepareStatement(sql);
	        psm.setString(1, subject.getCliNom());
	        psm.setInt(2, subject.getCliRuc());
	        psm.setString(3, subject.getCliDir());
	        psm.setInt(4, subject.getCliCod());
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
