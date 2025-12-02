package hclmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class postgres {
	public static void main(String args[]) {
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String password="123";
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			System.out.println("connected successfully");
			Statement stmt=conn.createStatement();
			String sql="SELECT * from employee";
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("employee table data: ");
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				java.math.BigDecimal salary=rs.getBigDecimal("salary");
				
				System.out.println(id+" | "+ name+" | "+salary);
			}
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
