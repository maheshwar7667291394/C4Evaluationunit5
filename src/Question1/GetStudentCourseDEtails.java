package Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface GetStudentCourseDEtails {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter roll");
		int roll=input.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mahesh";
			try {
				Connection con=DriverManager.getConnection(url,"root","M13a1h8@");
				PreparedStatement ps=con.prepareStatement("select cname from course where cid in(select cid from student_course where roll=?)");
				ps.setInt(1, roll);
				ResultSet rs=ps.executeQuery();
				boolean flag=false;
				while(rs.next()) {
				  flag=true;
					System.out.println(rs.getString("cname"));
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
