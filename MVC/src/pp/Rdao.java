package pp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Rdao {

	private Connection con;
	
	public Connection getCon() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/spr440","root","1213");
	}
	
	public int empAdd(Emp e) throws ClassNotFoundException, SQLException
	{
		con = getCon();
		String qr = "insert into emp values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setInt(3, e.getSal());
		return ps.executeUpdate();
	}
	
	public int deleteEmp(int id) throws ClassNotFoundException, SQLException
	{
		con= getCon();
		String qr = "delete from emp where id=?";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	public int updateEmp(Emp e) throws ClassNotFoundException, SQLException
	{
		con = getCon();
		String qr = "update emp set name=?,sal=? where id=?";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setString(1, e.getName());
		ps.setInt(2, e.getSal());
		ps.setInt(3, e.getId());
		return ps.executeUpdate();
		
	}
	
	public List<Emp> showEmp() throws ClassNotFoundException, SQLException
	{
		ArrayList<Emp> al = new ArrayList<>();
		con = getCon();
		String qr = "select * from emp";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qr);
		while(rs.next())
		{
			Emp e = new Emp();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setSal(rs.getInt("sal"));
			al.add(e);
		}
		return al;
	}
	
	public List<Emp> showByPage(int s,int t) throws ClassNotFoundException, SQLException
	{
		ArrayList<Emp> al = new ArrayList<>();
		con = getCon();
		String qr = "select * from emp limit "+s+","+t;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qr);
		while(rs.next())
		{
			Emp e= new Emp();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setSal(rs.getInt("sal"));
			al.add(e);
		}
		return al;
	}
}
