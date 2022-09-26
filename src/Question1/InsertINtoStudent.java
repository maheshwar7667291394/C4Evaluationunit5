package Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertINtoStudent {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter roll");
		int roll=input.nextInt();
		
		System.out.println("Enter name");
		String name=input.next();
		
		System.out.println("Enter address");
		String address=input.next();
		
		System.out.println("Enter mobile");
		String mobile=input.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mahesh";
			try {
				Connection con=DriverManager.getConnection(url,"root","M13a1h8@");
				PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
				ps.setInt(1, roll);
				ps.setString(2, name);
				ps.setString(3,address);
				ps.setString(4, mobile);
				
				int x=ps.executeUpdate();
				if(x>0)
					System.out.println("insertion succusful");
				else
					System.out.println("not inserted");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}

}
