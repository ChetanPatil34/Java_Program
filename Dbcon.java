import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
class Dbcon {

	public static void main(String args[])
	{
		
		try
		{
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Register successfull..!!");
		}
		catch(SQLException ex)
		{
			System.out.println("Error in Databace Conection");

		}
	}

}