package model.entities.usuario;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Medico extends Usuario implements Serializable {
           
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String cedula;
    
    
// ===================================== 
// = Constructor  = 
// ===================================== 
    
    public Medico() {
    }

    
    public Medico(String nombre, String email, String password, String cedula) {
        super(nombre, email, password);
        this.cedula = cedula;
    }
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }



    
}//Medico
