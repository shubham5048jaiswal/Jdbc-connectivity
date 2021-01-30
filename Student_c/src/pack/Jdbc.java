package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) {
		try {
		//1.load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Sap1999@j");
		//3. create the statement
		Statement st=con.createStatement();
		//4.execute the query
		ResultSet rs = st.executeQuery("select * from student");
		
		while(rs.next())
			System.out.println(rs.getInt("RollNo")+ " " +rs.getString("Name")+ " "+ rs.getString("city"));
		
		//5.close the connection
		con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	

}
