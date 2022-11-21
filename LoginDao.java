package bean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class LoginDao{

    

    
        
        
    
	public static boolean vulnerable(User user){
		boolean status=false;
		try{


// create our mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/login";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      
      // our SQL SELECT query. 
            String query = "SELECT * FROM user WHERE (username='"+user.getUsername()+"' and password='"+user.getPassword()+"')";
            
                  // create the java statement
                  Statement st = conn.createStatement();

                  // execute the query, and get a java resultset
                  ResultSet rs = st.executeQuery(query);

                  // iterate through the java resultset
                  while (rs.next())
                  {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                   

                    // print the results
                    System.out.format("%s, %s\n", username, password);
                    if(username!=null || password!=null){
                        status=true;
                    }
                    else{
                        status=false;
                    }
                  }
                  st.close();
                }
			
		catch(Exception e){}
		return status;
	}
        
        public static User nonVulnerable( User user) throws ClassNotFoundException, SQLException {
             String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/login";
      Class.forName(myDriver);
      try {
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
        
            //String strSql = "SELECT * FROM user WHERE (username='"+bean.getUsername()+"' and password='"+bean.getPassword()+"')";
            String strSql = "select * from user WHERE username=? and  password=?";
            PreparedStatement statement  = conn.prepareStatement( strSql );
            
                statement.setString( 1, user.getUsername() );
                statement.setString( 2, user.getPassword() );
                ResultSet resultSet = statement.executeQuery();
                
                    if ( resultSet.next() ) {
                        return new User(
                                
                                resultSet.getString( "username" ),
                                resultSet.getString( "password" )
                               
                        );
                    } else {
                        return null;
                    }
                
            
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }
        
        public static ArrayList<User> users(){
            
            ArrayList<User> List_users=new ArrayList<>();
            try{

// create our mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/login";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      
      // our SQL SELECT query. 
            String query = "SELECT * FROM user";
            
                  // create the java statement
                  Statement st = conn.createStatement();

                  // execute the query, and get a java resultset
                  ResultSet rs = st.executeQuery(query);
                  
                  // iterate through the java resultset
                  while (rs.next())
                  {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                   User loginBean=new User(username, password);
                   List_users.add(loginBean);
                  }
                  st.close();
                }
			
		catch(Exception e){}
		return List_users;
	}
        
        }
