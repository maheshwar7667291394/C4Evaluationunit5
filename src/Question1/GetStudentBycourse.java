package Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetStudentBycourse {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Cname");
		String cname=input.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mahesh";
			try {
				Connection con=DriverManager.getConnection(url,"root","M13a1h8@");
				PreparedStatement ps=con.prepareStatement("select *from student where roll in\r\n"
						+ "(select roll from student_course where\r\n"
						+ "cid=(select cid from course where cname=?)\r\n"
						+ ")");
				ps.setString(1, cname);
				ResultSet rs=ps.executeQuery();
				boolean flag=false;
				while(rs.next()) {
				  flag=true;
					System.out.println(rs.getInt("roll"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("address"));
					System.out.println(rs.getString("mobile"));
					System.out.println("===============");
				}
				if(!flag) {
					System.out.println("No record found");
				}
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	
	}

}
