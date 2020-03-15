/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Database {
    
    private static Database database;
    private final Connection connection;
    
    private Database() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver"); 
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendrier","root","admin");
        
    }
    
    public  static  void main (String[] args) throws SQLException, ClassNotFoundException {
       Database db = Database.getCOnnetion();
       String sql =  "select * from matieres" ;
       Statement smt = (Statement) db.connection.createStatement();
       ResultSet rs = smt.executeQuery(sql);
       while (rs.next()) {
            System.out.println(rs.getString("libelle"));
        }
   }
    
    public static Database getCOnnetion() throws SQLException, ClassNotFoundException{
        
        if (database == null) {
            
            database = new Database();
            
        }
        return database;
    }
    
    public static ArrayList<String> getMatieres() throws SQLException, ClassNotFoundException {
        Database db = Database.getCOnnetion();
        String sql =  "select * from matieres" ;
       Statement smt = (Statement) db.connection.createStatement();
       ResultSet rs = smt.executeQuery(sql);
        ArrayList<String> matieres = new ArrayList<>();
       while (rs.next()) {
            matieres.add(rs.getString("libelle"));
        }
       
       return matieres;
    }
}
