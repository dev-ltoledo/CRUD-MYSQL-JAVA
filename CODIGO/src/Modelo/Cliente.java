package Modelo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente extends Persona{
    Conexion conexionMySQL;
    private String Nit;
    private int Id;
    public Cliente(){}
    public Cliente(
            String Nit,
            String Nombre, 
            String Apellido,
            String Direccion,
            String Telefono,
            String FechaNacimiento,
            int Id)
            {
                super(Nombre, Apellido, Direccion, Telefono, FechaNacimiento); 
                this.Nit = Nit;
                this.Id = Id;
            }
    
    public String GetNit(){
        return Nit;
    }
    
    public void SetNit(String Nit){
        this.Nit = Nit;
    }
    
    public int GetId(){
        return Id;
    }
    
    public void SetId(int Id){
        this.Id = Id;
    }
    
    public DefaultTableModel Leer(){
        DefaultTableModel table = new DefaultTableModel();
        try
        {                       
            conexionMySQL = new Conexion();
            conexionMySQL.AbrirConexion();
            
            String encabezado[] = {"Id", "Nit", "Nombre", "Apellido", "Direccion", "Telefono", "Fecha de nacimiento"};
            String cuerpo[] = new String[7];
            String query = "SELECT id_cliente, nit, nombre, apellido, direccion, telefono, fecha_nacimiento FROM cliente;";
            
            ResultSet consulta = conexionMySQL.conexionDB.createStatement().executeQuery(query);
            
            table.setColumnIdentifiers(encabezado);
            
            while(consulta.next()){
                cuerpo[0] = consulta.getString("id_cliente");
                cuerpo[1] = consulta.getString("nit");
                cuerpo[2] = consulta.getString("nombre");
                cuerpo[3] = consulta.getString("apellido");
                cuerpo[4] = consulta.getString("direccion");
                cuerpo[5] = consulta.getString("telefono");
                cuerpo[6] = consulta.getString("fecha_nacimiento");
                table.addRow(cuerpo);
            }
            
            conexionMySQL.CerrarConexion();                        
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            return table;
        }    
    }
    
    public void agregar(){        
        try
        {
            conexionMySQL = new Conexion();
            PreparedStatement parametro;
            String query = "INSERT INTO cliente (nit, nombre, apellido, direccion, telefono, fecha_nacimiento) VALUES(?,?,?,?,?,?);";
                 
            conexionMySQL.AbrirConexion();
            parametro = (PreparedStatement) conexionMySQL.conexionDB.prepareStatement(query);
            parametro.setString(1, GetNit());
            parametro.setString(2, GetNombre());
            parametro.setString(3, GetApellido());
            parametro.setString(4, GetDireccion());
            parametro.setString(5, GetTelefono());
            parametro.setString(6, GetFechaNacimiento());
            
            int execute = parametro.executeUpdate();
            conexionMySQL.CerrarConexion();
            
            JOptionPane.showMessageDialog(null, "Registro agregado con exito", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editar(){
        try
        {
            conexionMySQL = new Conexion();
            PreparedStatement parametro;
            String query = "UPDATE cliente set nit=?, nombre=?, apellido=?, direccion=?, telefono=?, fecha_nacimiento=? where id_cliente = ?;";
                 
            conexionMySQL.AbrirConexion();
            parametro = (PreparedStatement) conexionMySQL.conexionDB.prepareStatement(query);
            parametro.setString(1, GetNit());
            parametro.setString(2, GetNombre());
            parametro.setString(3, GetApellido());
            parametro.setString(4, GetDireccion());
            parametro.setString(5, GetTelefono());
            parametro.setString(6, GetFechaNacimiento());
            parametro.setInt(7, GetId());
            
            int execute = parametro.executeUpdate();
            conexionMySQL.CerrarConexion();
            
            JOptionPane.showMessageDialog(null, "Registro Actualizado con exito", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(){
         try
        {
            conexionMySQL = new Conexion();
            PreparedStatement parametro;
            String query = "delete from cliente where id_cliente = ?;";
                 
            conexionMySQL.AbrirConexion();
            parametro = (PreparedStatement) conexionMySQL.conexionDB.prepareStatement(query);
            parametro.setInt(1, GetId());
            
            int execute = parametro.executeUpdate();
            conexionMySQL.CerrarConexion();
            
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
