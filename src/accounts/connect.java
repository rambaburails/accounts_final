package accounts;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.*;
import java.util.Properties;
 
public class connect
{
  static void doSshTunnel( String strSshUser, String strSshPassword, String strSshHost, int nSshPort, String strRemoteHost, int nLocalPort, int nRemotePort ) throws JSchException
  {
    final JSch jsch = new JSch();
    Session session = jsch.getSession( strSshUser, strSshHost, 22 );
    session.setPassword( strSshPassword );
     
    final Properties config = new Properties();
    config.put( "StrictHostKeyChecking", "no" );
    session.setConfig( config );
     
    session.connect();
    session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
    System.out.println("in do ssh tunnel");
  }
   
  static Connection ConnectDB()
  {
      Connection con = null;
    try
    {
      String strSshUser = "server";                  // SSH loging username
      String strSshPassword = "server";                   // SSH login password
      String strSshHost = "192.168.1.99";          // hostname or ip or SSH server
      int nSshPort = 22;                                    // remote SSH host port number
      String strRemoteHost = "localhost";  // hostname or ip of your database server
      int nLocalPort = 3366;                                // local port number use to bind SSH tunnel
      int nRemotePort = 3306;                               // remote port number of your database 
      String strDbUser = "root";                    // database loging username
      String strDbPassword = "server";                    // database login password
       
      //doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort, nRemotePort);
      System.out.println("SSH Connection Succes");
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:"+nLocalPort, strDbUser, strDbPassword);
      
      System.out.println("sql connection done");
     
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return con;
  }
}