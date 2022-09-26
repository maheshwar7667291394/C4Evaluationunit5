package Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertINtocourse {
	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("cid");
		int cid=input.nextInt();
		
		System.out.println("cname");
		String cname=input.next();
		
		System.out.println("fee");
		int fee=input.nextInt();
		
		System.out.println("duration");
		String duration=input.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mahesh";
			try {
				Connection con=DriverManager.getConnection(url,"root","M13a1h8@");
				PreparedStatement ps=con.prepareStatement("insert into course values(?,?,?,?)");
				ps.setInt(1, cid);
				ps.setString(2, cname);
				ps.setInt(3,fee);
				ps.setString(4,duration);
				
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
