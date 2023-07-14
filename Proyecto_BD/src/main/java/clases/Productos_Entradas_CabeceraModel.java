package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import interfaces.Productos_Entradas_CabeceraInterface;

public class Productos_Entradas_CabeceraModel implements Productos_Entradas_CabeceraInterface{

	@Override
	public int createSubject(Productos_Entradas_Cabecera subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "INSERT INTO l2t_productos_entradas_cabecera VALUES (?, ?, ?, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, subject.getEntCabCod());
			psm.setInt(2, subject.getPrvCod());
			psm.setInt(3, subject.getEstNum());
			psm.setString(4, subject.getEntcabfecAno());
			psm.setString(5, subject.getEntcabfecMes());
			psm.setString(6, subject.getEntcabfecDia());
			psm.setString(7, subject.getEntcabestReg());
		
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
	public List<Productos_Entradas_Cabecera> listSubject() {
		List<Productos_Entradas_Cabecera> listSubject = new ArrayList<Productos_Entradas_Cabecera>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_productos_entradas_cabecera";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Productos_Entradas_Cabecera subject = new Productos_Entradas_Cabecera();
				subject.setEntCabCod(rs.getInt("EntCabCod"));
				subject.setPrvCod(rs.getInt("PrvCod"));
				subject.setEstNum(rs.getInt("EstNum"));
				subject.setEntcabfecAno(rs.getString("EntCabFecAño"));
				subject.setEntcabfecMes(rs.getString("EntCabFecMes"));
				subject.setEntcabfecDia(rs.getString("EntCabFecDia"));
				subject.setEntcabestReg(rs.getString("EntCabEstReg"));
				
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
	public Productos_Entradas_Cabecera getSubject(String id) {
		Productos_Entradas_Cabecera subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConnection.getConexion();
			String sql = "SELECT * FROM l2t_productos_entradas_cabecera WHERE EntCabCod=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				subject = new Productos_Entradas_Cabecera();
				subject.setEntCabCod(rs.getInt("EntCabCod"));
				subject.setPrvCod(rs.getInt("PrvCod"));
				subject.setEstNum(rs.getInt("EstNum"));
				subject.setEntcabfecAno(rs.getString("EntCabFecAño"));
				subject.setEntcabfecMes(rs.getString("EntCabFecMes"));
				subject.setEntcabfecDia(rs.getString("EntCabFecDia"));
				subject.setEntcabestReg(rs.getString("EntCabEstReg"));
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
			String sql = "DELETE FROM l2t_productos_entradas_cabecera WHERE EntCabCod=?";
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
	public int updateSubject(Productos_Entradas_Cabecera subject) {
	    int value = 0;
	    Connection cn = null;
	    PreparedStatement psm = null;
	    
	    try {
	        cn = MysqlConnection.getConexion();	
	        String sql = "UPDATE l2t_productos_entradas_cabecera SET PrvCod=?, estNum=?,entCabFecAño=?, entCabFecMes=?, entCabFecDia=?, entCabEstReg=? WHERE entCabCod=?";
	        psm = cn.prepareStatement(sql);
	        
			psm.setInt(1, subject.getPrvCod());
			psm.setInt(2, subject.getEstNum());
			psm.setString(3, subject.getEntcabfecAno());
			psm.setString(4, subject.getEntcabfecMes());
			psm.setString(5, subject.getEntcabfecDia());
			psm.setString(6, subject.getEntcabestReg());
			psm.setInt(7, subject.getEntCabCod());
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
