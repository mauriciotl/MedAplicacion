package model.entities.usuario;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Tecnico extends Usuario implements Serializable {
    
        
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String registro;

   

// ===================================== 
// = Attributes  = 
// ===================================== 
    
    public Tecnico() {
    }

    public Tecnico(String nombre, String email, String password, String registro) {
        super(nombre, email, password);
        this.registro = registro;
    }
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    
    
    
}//Tecnico
