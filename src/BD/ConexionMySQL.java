/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIR_J
 */
public class ConexionMySQL {
    
    /*Creacion de variables**/
    String bd="usuarios";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;

    /*Metodo constructor de la clase*/
    public Connection Conectar() {
        try {
            /*conexion*/
            Class.forName(driver);
            /*Candena de conexion*/
            cx=DriverManager.getConnection(url+bd,user,password);
            System.out.println("Exito Se conecto a la bd: "+bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar con la bd " +bd+" por: ");
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
 public void desconectar() throws SQLException{
 cx.close();
 }
 
 //PRUEBA DE CONEXION
 public static void main(String[] args) {
 ConexionMySQL conexion=new ConexionMySQL();
 conexion.Conectar();
 }
 
}
