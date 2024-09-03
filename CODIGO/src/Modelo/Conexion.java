package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author ltoledo
 * @fecha 01/09/2024
 * @version 1.0.0.2409
 * @descripcion Actividad 2, programa con conexion a MySQL y creacion de CRUD
 **/
public class Conexion {
    public Connection conexionDB;
    public final String base_dato = "db_empresa";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s", base_dato) ;    
    public final String usuario = "apempresa";
    public final String password = "Temp0ral1,";    
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void AbrirConexion() {
      try
      {
          Class.forName(jdbc);
          conexionDB = DriverManager.getConnection(urlConexion, usuario, password);
          
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }      
    }
    
    public void CerrarConexion(){
        try
      {
          conexionDB.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }  
    }
}
