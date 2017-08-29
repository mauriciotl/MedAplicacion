package model.entities.usuario;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Administrador extends Usuario implements Serializable {

    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String tipo;

// ===================================== 
// = Constructor  = 
// ===================================== 
    
    public Administrador() {
    }

    public Administrador(String nombre, String email, String password, String tipo) {
        super(nombre, email, password);
        this.tipo = tipo;
    }
    
    
    
    

// ===================================== 
// = getters / setters                 = 
// ===================================== 


    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}//Administrador
