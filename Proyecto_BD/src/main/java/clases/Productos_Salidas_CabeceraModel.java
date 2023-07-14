package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import interfaces.Productos_Salidas_CabeceraInterface;

public class Productos_Salidas_CabeceraModel implements Productos_Salidas_CabeceraInterface{

	@Override
	public int createSubject(Productos_Salidas_Cabecera subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l4t_productos_Salidas_cabecera VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getSalCod());
			psm.setInt(2, subject.getCliCod());
			psm.setInt(3, subject.getProPreTot());
			psm.setString(4, subject.getEntcabfecAno());
			psm.setString(5, subject.getEntcabfecMes());
			psm.setString(6, subject.getEntcabfecDia());
			psm.setInt(7, subject.getSalConPag());
			psm.setInt(8, subject.getSalIgv());
			psm.setDouble(9, subject.getSalImpTot());
			psm.setString(10, subject.getEntcabestReg());
			
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
	public List<Productos_Salidas_Cabecera> listSubject() {
		List<Productos_Salidas_Cabecera> listSubject = new ArrayList<Productos_Salidas_Cabecera>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l4t_productos_Salidas_cabecera";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Productos_Salidas_Cabecera subject = new Productos_Salidas_Cabecera();
				subject.setSalCod(rs.getInt("SalCod"));
				subject.setCliCod(rs.getInt("CliCod"));
				subject.setProPreTot(rs.getInt("ProPreTot"));
				subject.setEntcabfecAno(rs.getString("SalCabFecAño"));
				subject.setEntcabfecMes(rs.getString("SalCabFecMes"));
				subject.setEntcabfecDia(rs.getString("SalCabFecDia"));
				subject.setSalConPag(rs.getInt("SalConPag"));
				subject.setSalIgv(rs.getInt("SalIgv"));
				subject.setSalImpTot(rs.getDouble("SalImpTot"));
				subject.setEntcabestReg(rs.getString("SalCabEstReg"));
				
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
	public Productos_Salidas_Cabecera getSubject(String id) {
		Productos_Salidas_Cabecera subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l4t_productos_Salidas_cabecera WHERE SalCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Productos_Salidas_Cabecera();
				subject.setSalCod(rs.getInt("SalCod"));
				subject.setCliCod(rs.getInt("CliCod"));
				subject.setProPreTot(rs.getInt("ProPreTot"));
				subject.setEntcabfecAno(rs.getString("SalCabFecAño"));
				subject.setEntcabfecMes(rs.getString("SalCabFecMes"));
				subject.setEntcabfecDia(rs.getString("SalCabFecDia"));
				subject.setSalConPag(rs.getInt("SalConPag"));
				subject.setSalIgv(rs.getInt("SalIgv"));
				subject.setSalImpTot(rs.getDouble("SalImpTot"));
				subject.setEntcabestReg(rs.getString("SalCabEstReg"));
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
			String sql = "DELETE FROM l4t_productos_Salidas_cabecera WHERE salCod=?";
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
	public int updateSubject(Productos_Salidas_Cabecera subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();	
	        String sql = "UPDATE l4t_productos_Salidas_cabecera SET cliCod=?, proPreTot=?, salCabFecAño=?, salCabFecMes=?, salCabFecDia=?, salConPag=?, salIgv=?, salImpTot=?, salCabEstReg=? WHERE salCod=?";
	        psm = cn.prepareStatement(sql);
	        
			psm.setInt(1, subject.getCliCod());
			psm.setInt(2, subject.getProPreTot());
			psm.setString(3, subject.getEntcabfecAno());
			psm.setString(4, subject.getEntcabfecMes());
			psm.setString(5, subject.getEntcabfecDia());
			psm.setInt(6, subject.getSalConPag());
			psm.setInt(7, subject.getSalIgv());
			psm.setDouble(8, subject.getSalImpTot());
			psm.setString(9, subject.getEntcabestReg());
			psm.setInt(10, subject.getSalCod());
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
