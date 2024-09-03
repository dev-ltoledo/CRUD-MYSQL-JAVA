package Modelo;

public class Persona {
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String FechaNacimiento;
    public Persona(){}
    public Persona(
            String Nombre, 
            String Apellido,
            String Direccion,
            String Telefono,
            String FechaNacimiento)
            {
                this.Nombre = Nombre;
                this.Apellido = Apellido;
                this.Direccion = Direccion;
                this.Telefono = Telefono;
                this.FechaNacimiento = FechaNacimiento;
            }
    
    public String GetNombre(){
        return Nombre;
    }
    
    public void SetNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String GetApellido(){
        return Apellido;
    }
    
    public void SetApellido(String Apellido){
        this.Apellido = Apellido;
    }
    
    public String GetDireccion(){
        return Direccion;
    }
    
    public void SetDireccion(String Direccion){
        this.Direccion = Direccion;
    }
    
    public String GetTelefono(){
        return Telefono;
    }
    
    public void SetTelefono(String Telefono){
        this.Telefono = Telefono;
    }
    
    public String GetFechaNacimiento(){
        return FechaNacimiento;
    }
    
    public void SetFechaNacimiento(String FechaNacimiento){
        this.FechaNacimiento = FechaNacimiento;
    }        
}
