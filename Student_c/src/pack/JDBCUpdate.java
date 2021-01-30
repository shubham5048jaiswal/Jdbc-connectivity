package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUpdate {

	public static void main(String[] args) {
		try {
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","Sap1999@j");
		
		String sql = "update faculty SET subject=?, Id=? where name=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "DBMS");
		st.setString(2, "3");
		st.setString(3, "shubham");
		
		
		int rowsUpdated = st.executeUpdate();
		if(rowsUpdated>0){
			System.out.println("An existing user was updated successfully!");
		}
		String sql1 = "select * from faculty" ;
		 
		Statement statement1 = con.createStatement();
		ResultSet result = statement1.executeQuery(sql1);
		
		int count = 0;
		while(result.next()) {
			String subject = result.getString("subject");
			String Id = result.getString("Id");
			String name = result.getString("name");
			
			String output = "student #%d: %s - %s - %s";
			System.out.println(String.format(output,count++,subject,Id,name));
		}
		}
		catch(Exception e) {
			System.out.println(e);

		}
	}

}
