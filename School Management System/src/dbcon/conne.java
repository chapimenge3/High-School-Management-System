package dbcon;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import h1.*;
import javax.swing.JOptionPane;

/**
 *
 * @author SPY database connection is all set here
 */
public class conne 
{
    public static  Connection connection;
    static  Statement idgetter ;
    static PreparedStatement p ,pp,ppp;
    static ResultSet rs ;
    static boolean is_connected = false;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/chapi";
    static  int idcount;
    static int idcountTeach;

    /**
     *
     * @throws SQLException
     */
    public static void connect()
    {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "") ;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error ","EROOR",JOptionPane.ERROR_MESSAGE);
        }
        //
        is_connected = true;
    }

    /**
     *
     * @throws SQLException
     */
    public static void disconnect() throws SQLException {
        if (is_connected) {
            
                //p.close();
                connection.close();
                is_connected = false;         
        }
    }

    /**
     *
     * @param user
     * @param password
     * @return boolean
     * @throws java.sql.SQLException
     */
    public static boolean auth(String user , String password) throws SQLException
    {
        p  =  connection.prepareStatement("select * from account where user_Name = ? and password = ?") ;
        p.setString(1, user);
        p.setString(2, password);
        rs = p.executeQuery();
        return rs.next();
       
    }
    public static boolean authAdmin(String user , String password) throws SQLException
    {
        p  =  connection.prepareStatement("select * from admin where userName = ? and password = ?") ;
        p.setString(1, user);
        p.setString(2, password);
        rs = p.executeQuery();
        return rs.next();
       
    }
//    public static void reg(String ... reg )
//    {
//        
//        
//    }

    /**
     *
     * @return
     * @throws SQLException
     */
    private static int getidnum() throws SQLException
    {
    	
        idgetter = connection.createStatement();
        String sql;
        sql = "SELECT * FROM idcount";
        ResultSet rss = idgetter.executeQuery(sql);
        while(rss.next())
        {
        	 idcount =rss.getInt("idnum");
    	}
        idgetter.close();             
    	return idcount;
    }
    private static int getTeachId() throws SQLException
    {
        idgetter = connection.createStatement();
        String sql;
        sql = "SELECT * FROM `teacherid`";
        ResultSet rss = idgetter.executeQuery(sql);
        while(rss.next())
        {
        	 idcountTeach =rss.getInt("idcount");
    	}
        idgetter.close();
    	return idcountTeach ;        
    }

    /**
     *
     * @param fName
     * @param lName
     * @param bDate
     * @param age
     * @param city
     * @param phone
     * @param email
     * @param gender
     * @param grade
     * @return p.executepdate () 
     * @throws java.sql.SQLException
     */
    public  static int regStdInfo(String fName,String lName , String bDate , int age ,String city, String phone ,String email , String gender , int grade, String ename 
            , String ephone ,String ecity ,String eadrress  ) throws SQLException
    {
        int id;
        id = getidnum();
        p = connection.prepareStatement
        ("INSERT INTO `student` (`id`, `firstName`, `lastName`, `birthDate`, `age`, `city`, `phone`, `email`, `gender`,`grade`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)") ; 
        //System.out.println(p.toString());
        p.setString(1, Integer.toString(id));
        p.setString(2, fName);
        p.setString(3, lName);
        p.setString(4, bDate);
        p.setInt(5, age);
        p.setString(6, city);
        p.setString(7, phone);
        p.setString(8,  email);
        p.setString(9, gender);
        p.setInt(10,grade);
        int excutee ;
        excutee = p.executeUpdate();
        p.close();
        emergRegStdInfo( Integer.toString(id) , ename, ephone, ecity, eadrress);
        p.close();
        id++;
        setIDChange(id);
        p.close();
        return excutee ;  
    }
    public static void emergRegStdInfo(String id , String name , String phone ,String city ,String adrress ) throws SQLException
    {
        p = connection.prepareStatement (" INSERT INTO `stdemergency` (`id`, `emergName`, `emergPhone`, `emergCity`, `emergAddress`) VALUES ( ?, ?, ?, ?, ?) " ) ;
        p.setString(1, id);
        p.setString(2, name);
        p.setString(3, phone);
        p.setString(4, city);
        p.setString(5, adrress);
        p.executeUpdate();
        p.close() ;
    }
    public static int regTeachInfo(String name ,String gender , String phone ,String bDate ,String city ,String email,String adrress , String nationality ,String status ,String accademic ,double salary , String depName , int age) throws SQLException
    {
         int id = 0;
       try
       {
       
            id = getTeachId();
       pp = connection.prepareStatement ("INSERT INTO `teacher` (`TId`, `Tname`, `Tgender`, `Tphone`, `TbirthDate`, `Tcity`, `Taddrress`, `Temail`, `Tnationality`, `Tstatus`, `TaccademicStatus`, `Tsalary`, `depName`, `age`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
       
       pp.setString(1, Integer.toString(id));
       pp.setString(2, name);
       pp.setString(3, gender);
       pp.setString(4, phone);
       pp.setString(5, bDate);
       pp.setString(6, city);
       pp.setString(7, adrress);
       pp.setString(8, email);
       pp.setString(9, nationality);
       pp.setString(10, status);
       pp.setString(11, accademic);
       pp.setDouble(12, salary);
       pp.setString(13, depName);
       pp.setInt(14, age);
       int excutee ;
        
       //System.out.println("ddddddd");
       excutee = pp.executeUpdate();
       pp.close(); 
       }
       catch ( SQLException e)
       {
           e.printStackTrace();
       }
      //System.out.println("ccccc");
      try
      {
       pp.close();     
       id++;
       setIDChangeTeach(id);
      }
      catch(SQLException e)
      {
          
      }
       //return excutee ;  
        return 0;
    
    }
    
    //public static void teachRegInfo(String )
    private static void setIDChange(int id ) 
    {
        try
        {
            p = connection.prepareStatement("UPDATE idcount SET `idnum` = ?");
            p.setInt(1, id);
            p.executeUpdate();
        }
        catch (SQLException e )
        {
            System.out.println("Student ID didn't update itself due to some problem");
        }
        finally
        {
            try {
                p.close();
            } catch (SQLException ex) {
                //Logger.getLogger(conne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private static  void setIDChangeTeach(int id)
    {
        try
        {
            ppp = connection.prepareStatement("UPDATE `teacherid` SET `idcount`= ? ");
            ppp.setInt(1, id);
            ppp.executeUpdate();
        }
        catch (SQLException e )
        {
            System.out.println("Teacher Id didn't update due to some problem");
        }
        finally
        {
            try {
                ppp.close();
            } catch (SQLException ex) {
                //Logger.getLogger(conne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   //build the mehood 02
    
    
    // search part

    /**
     *
     * @return
     */
    
    //@SuppressWarnings("empty-statement")
    public static ResultSet searchStd(String choice , String search) throws SQLException
    {
        
       
            
        if(null != choice)
        //System.out.println(choice);
        //p = connection.prepareStatement("SELECT `id`, `firstName`, `lastName`,`grade` FROM `student` WHERE `id` REGEXP ? ");
        switch (choice) {
            case "Grade":
                System.out.println("if 1");
                p = connection.prepareStatement("SELECT `id`, `firstName`, `lastName`,`grade` FROM `student` WHERE `grade` REGEXP ? ");
                //p.setString(1 , search);
                break;
            case "LastName":
                System.out.println("if 2");
                p = connection.prepareStatement("SELECT `id`, `firstName`, `lastName`,`grade` FROM `student` WHERE `lastName` REGEXP ? ");
                //p.setString( 1 , search);
                break;
            case "FirstName":
                System.out.println("3");
                p = connection.prepareStatement("SELECT `id`, `firstName`, `lastName`,`grade` FROM `student` WHERE `firstName` REGEXP ?  ");
                break;
            default:
                break;
        }
        p.setString( 1 , search);
        ResultSet rss = p.executeQuery();
        
        System.out.println("after rs");
//        while(rss.next())
//        {
//            System.out.println( rss.getString("lastName"));
//        }
        //p.close();
        return rss;
    }
    public static ResultSet searchTeach(String choice,String search) throws SQLException
    {
        if(null != choice)
        {
            switch (choice) {
                case "name":
                    System.out.println("if 1");
                    p = connection.prepareStatement("Select `Tid`, `Tname`, `depName`, `age` FROM `teacher`  WHERE `Tname` REGEXP ? ");
                    //p.setString(1 , search);
                    break;
                case "department":
                    System.out.println("if 2");
                    p = connection.prepareStatement("Select `Tid`, `Tname`, `depName`, `age` FROM `teacher`  WHERE `depName` REGEXP ? ");
                    //p.setString( 1 , search);
                    break;
                case "age":
                    System.out.println("3");
                    p = connection.prepareStatement("Select `Tid`, `Tname`, `depName`, `age` FROM `teacher`  WHERE `age` REGEXP ?  ");
                    break;
                default:
                    break;
            }
        p.setString( 1 , search);
        ResultSet rss = p.executeQuery();
        return rss;
        }
        return null;
    }
    public static ResultSet searchAcc(String user) throws SQLException
    {
        p = connection.prepareStatement("SELECT * FROM `account` where `user_name` REGEXP ?");
        p.setString(1, user);
        ResultSet rs = p.executeQuery();
        return rs;
        
    }
    public static void deleteStd (String id) throws SQLException
    {
         p = connection.prepareStatement("DELETE FROM `student` WHERE  `id` = ? " );
        p.setString(1, id);
        p.executeUpdate();
        p.close();
        p = p = connection.prepareStatement("DELETE FROM `stdemergency` WHERE `id` = ? " );
        p.setString(1, id);
        p.close();
    }
    public static void deleteTeach (String id) throws SQLException
    {
        PreparedStatement p = connection.prepareStatement("DELETE FROM `teacher` WHERE  `Tid` = ? " );
        p.setString(1, id);
        p.executeUpdate();
        p.close();
    }
    public static void removeAcc (String userName) throws SQLException
    {
        PreparedStatement p = connection.prepareStatement("DELETE FROM `account` WHERE `user_name` = ? " );
        p.setString(1, userName);
        p.executeUpdate();
        p.close();
    }
    public static void addAcc (String userName , String Password) throws SQLException
    {
        PreparedStatement p = connection.prepareStatement("INSERT INTO `account`(`user_name`, `password`) VALUES (?,?) " );
        p.setString(1, userName);
        p.setString(2, Password);
        p.executeUpdate();
        p.close();
    }
    public static void deleteAllStd () throws SQLException
    {
        p = connection.prepareStatement("DELETE FROM `student`" );
        p.executeUpdate();
        p.close();
    }
    public static void deleteAllTeach () throws SQLException
    {
        PreparedStatement p = connection.prepareStatement("DELETE FROM `teacher`" );
        p.executeUpdate();
        p.close();
    }
    public static void removeAllAcc () throws SQLException
    {
        PreparedStatement p = connection.prepareStatement("DELETE FROM `account`" );
        p.executeUpdate();
        p.close();
    }
    public static void deleteAllStdChoice (String choice) throws SQLException
    {
        p = connection.prepareStatement("alter table `student` drop ?" );
       
        if(null != choice)
        {
            switch (choice) {
                case "age":
                    System.out.println("if 1");
                    p = connection.prepareStatement("alter table `student` drop `age` " );
                   
                    break;
                case "city":
                    
                    p = connection.prepareStatement("alter table `student` drop `city` ");
                   
                    break;
                case "phone":
                   
                    p = connection.prepareStatement("alter table `student` drop `phone` ");
                    break;
                default:
                    break;
            }
        }
        p.executeUpdate();
        p.close();
    }
    
}