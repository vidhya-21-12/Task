
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	private final String conUrl = "jdbc:postgresql://localhost/TestDb";
    private final String username = "postgres";
    private final String password = "root";

    private void Connect() {
    	try 
    		(Connection connection = DriverManager.getConnection(conUrl, username, password);){
    			
    			if(connection !=null) {
    				System.out.println("connected to postgresql \n");
    			}
    			else
    			{
    				System.out.println("Failed");
    			}
    			
    			Statement statement = connection.createStatement();
    			ResultSet resultset = statement.executeQuery("SELECT *FROM tbluser");
    			if(resultset.next())
    			{
    				System.out.println(resultset.getString("username")+ "\t"
    		                + resultset.getString("password"));
    			}
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}
    	
    }
    
    public static void main(String[] args) {
    	JdbcDemo d = new JdbcDemo();
    	d.Connect();
    	
    }
}
