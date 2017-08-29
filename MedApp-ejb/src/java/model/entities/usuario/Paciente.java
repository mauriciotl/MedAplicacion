package model.entities.usuario;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Paciente extends Usuario implements Serializable {
    

// ===================================== 
// = Attributes                        = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String telefono;

// ===================================== 
// = Constructor  = 
// ===================================== 
    
    public Paciente() {
    }

    public Paciente(String nombre, String email, String password, String telefono) {
        super(nombre, email, password);
        this.telefono = telefono;
    }
    
    
// ===================================== 
// = g / s  = 
// ===================================== 


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
// ===================================== 
// = Overrided methods  = 
// ===================================== 

    

}//Paciente
