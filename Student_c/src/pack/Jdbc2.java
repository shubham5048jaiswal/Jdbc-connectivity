package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc2 {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","Sap1999@j");
			
			//3. create the statement
			Statement st=con.createStatement();
			int result = st.executeUpdate("insert into faculty(Name,subject,Id) values('Dinesh','DS','4')");
			if(result > 0) 
				System.out.println("A new data inserted successfully");
			
			else 
				System.out.println("unsucessful insertion");
			
		
					
			//5.close the connection
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
